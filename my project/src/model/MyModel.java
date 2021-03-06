package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import algorithmes.mazeGenerators.Maze3d;
import algorithmes.mazeGenerators.Maze3dGenerator;
import algorithmes.mazeGenerators.Position;
import algorithmes.mazeGenerators.SimpleMaze3dGenerator;
import algorithmes.mazeGenerators.lastCellTree;
import algorithmes.mazeGenerators.randomCellTree;
import algorithmes.search.BFS;
import algorithmes.search.CommonSearcher;
import algorithmes.search.DFS;
import algorithmes.search.Solution;
import algorithmes.search.State;
import algorithms.Demo.MazeAdapter;
//import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
import utils.PropertiesXml;


/**
 * The Class MyModel-This class is exercising
 * all the functions that calculating things.
 * this class knows only the controller and its communicate with the view by the mediator-controller.
 */
public class MyModel extends Observable implements Model{


	/** The maze names. */
	private HashMap<String, Maze3d>mazeNames;

	/** The threads. */
	private ArrayList<Thread>threads;

	private ExecutorService executor=Executors.newFixedThreadPool(PropertiesXml.getProperties().getNumOfThreads());
	private CurrentMaze m_currentMaze;
	public CurrentMaze getM_currentMaze() {
		return m_currentMaze;
	}

	public void setM_currentMaze(CurrentMaze m_currentMaze) {
		this.m_currentMaze = m_currentMaze;
	}
	/** The solutions. */
	private HashMap<String,Solution<Position>> solutions;
	private HashMap<Maze3d,Solution<Position>>solution;
	/**
	 * Instantiates a new my model.
	 */
	public MyModel(){
		this.mazeNames=new HashMap<String, Maze3d>();
		this.solutions=new HashMap<String, Solution<Position>>();
		this.threads=new ArrayList<Thread>();
		this.solution=new HashMap<Maze3d, Solution<Position>>();
		loadFromZip();

	}

	/**
	 * Sets the c.
	 *
	 * @param c the new c
	 */


	/**
	 * Sol- this function is for convert to string.
	 *
	 * @param solution the solution
	 * @return the string
	 */
	private String sol(Solution<Position>solution){

		String s=new String();
		ArrayList<State<Position>> temp;
		temp=solution.getStates();

		while(!temp.isEmpty()){
			s+=temp.remove(0);
			s+=" ";

		}
		return s;
	}

	/**
	 * Maze 2 d- this function is for convert to string.
	 *
	 * @param a the a
	 * @return the string
	 */
	private String maze2d(int[][]a){
		String aString="\n";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++ ) {
				aString = aString + " " + a[i][j];
			}
			aString = aString + "\n";
		}
		return aString;
	}
	/**
	 * This function is generating a maze by the 3 algorithms- that the user decides.
	 */
	/* (non-Javadoc)
	 * @see model.Model#m_generate(java.lang.String, int, int, int, java.lang.String)
	 */
	@Override
	public void m_generate(String nameMaze, int x, int y, int z,String alg) {
		//	Thread thread=new Thread(new Runnable() {

		//		@Override
		//		public void run() {

		Future<Maze3d> m = executor.submit (new Callable<Maze3d> (){

			@Override
			public Maze3d call() throws Exception {
				Maze3d maze=null;
				Position p=new Position(x,y,z);
				if(alg==null){
					maze=generateByProp().generate(p);
					new CurrentMaze(maze);
				}
				else{
					switch(alg){
					case "randomCell": maze=new randomCellTree().generate(p);
					return maze;
					
					case "lastCell": maze=new lastCellTree().generate(p);
					
					return maze;
					case "simple": maze=new SimpleMaze3dGenerator().generate(p);
					
					return maze;
					//case "null":maze=generateByProp().generate(p);
					//break;
					default: setChanged();
					notifyObservers("try again\n");
					}
				}
				
					return maze;
				
			}

		});
		try{
			Maze3d maze=m.get();
			if(maze==null)
				return;
			mazeNames.put(nameMaze,maze);
			this.m_currentMaze=new CurrentMaze(maze);
			this.m_currentMaze.setName(nameMaze);
		}catch(InterruptedException | ExecutionException e){
			e.printStackTrace();
		}

		setChanged();
		notifyObservers(".maze " + nameMaze+ " is ready\n");


	}

	//});
	//thread.start();
	//	threads.add(thread);
	//	}
	/**
	 * This function is for printing a maze3d.
	 */
	/* (non-Javadoc)
	 * @see model.Model#m_display(java.lang.String)
	 */
	@Override
	public void m_display(String name) {
		if(!mazeNames.containsKey(name)){
			setChanged();
			notifyObservers("The maze is not exist\n");

		}else{
			Maze3d maze=mazeNames.get(name);
			String s=maze.toString();
			setChanged();
			notifyObservers(s);

		}

	}
	/**
	 * This function is for printing a maze2d.
	 */
	/* (non-Javadoc)
	 * @see model.Model#m_display_cross_section(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void m_display_cross_section(int num,String index, String name) {

		if(!mazeNames.containsKey(name)){
			setChanged();
			notifyObservers("The maze is not exist\n");
		}else{
			Maze3d maze=mazeNames.get(name);
			if((index.equals("x")&&num>=maze.getP().getX())||(index.equals("y")&&num>=maze.getP().getY())||(index.equals("z")&&num>=maze.getP().getZ()))
			{
				setChanged();
				notifyObservers("There is an exception\n");	
			}else{
				String temp = null;
				if(index.equals("x"))
				{
					int[][] a=maze.getCrossSectionByX(num);
					temp=maze2d(a);
				}
				if(index.equals("y"))
				{
					int[][] a=maze.getCrossSectionByY(num);
					temp=maze2d(a);
				}
				if(index.equals("z"))
				{
					int[][] a=maze.getCrossSectionByZ(num);
					temp=maze2d(a);
				}
				setChanged();
				notifyObservers(temp);
			}
		}

	}
	/**
	 * This function is for saving the maze in a file.
	 */
	/* (non-Javadoc)
	 * @see model.Model#m_save_maze(java.lang.String, java.lang.String)
	 */
	@Override
	public void m_save_maze(String mazeName, String fileName) {
		if(!mazeNames.containsKey(mazeName)){
			setChanged();
			notifyObservers("The maze is not exist\n");
		}else{
			try{
				Maze3d maze=mazeNames.get(mazeName);
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream("resources/mazes/"+fileName));
				out.write(maze.toByteArray());
				out.close();
				saveToZip();
				setChanged();
				notifyObservers("The maze "+ mazeName+" was saved successfully\n");

			}catch(IOException e)
			{
				setChanged();
				notifyObservers("cant save the maze\n");
			}
		}

	}
	/**
	 * This function is for loading a maze from file.
	 */
	/* (non-Javadoc)
	 * @see model.Model#m_load_maze(java.lang.String, java.lang.String)
	 */
	@Override
	public void m_load_maze(String fileName, String mazeName) throws IOException{
		try{
			InputStream in = new MyDecompressorInputStream(new FileInputStream("resources/mazes/"+fileName));
			byte[]temp=new byte[100000];
			in.read(temp);
			in.close();
			Maze3d maze=new Maze3d(temp);
			this.m_currentMaze=new CurrentMaze(maze);
			this.m_currentMaze.setName(mazeName);
			mazeNames.put(mazeName,maze);
			setChanged();
			notifyObservers(".The maze "+mazeName+" was loaded successfully\n");
		}catch(FileNotFoundException e){
			setChanged();
			notifyObservers("Can't load the maze, the file name or the maze name is wrong");
			e.printStackTrace();
		}


	}
	/**
	 * This function is for solving a maze by the algorithms-DFS/BFS.
	 */
	/* (non-Javadoc)
	 * @see model.Model#m_solve(java.lang.String, java.lang.String)
	 */
	@Override
	public void m_solve(String mazeName, String alg) {
		//	Thread thread=new Thread(new Runnable() {

		//		@Override
		//		public void run() {

		Future<Solution<Position>> sol = executor.submit (new Callable<Solution<Position>> (){

			@Override
			public Solution<Position> call() throws Exception {

				if (!mazeNames.containsKey(mazeName)){
					setChanged();
					notifyObservers("The maze isn't exist\n");
				}else{
					String temp1=alg;
					if(temp1==null)
						temp1=PropertiesXml.getProperties().getSolveAlg();
					if((!temp1.equals("DFS"))&&(!temp1.equals("BFS"))){
						setChanged();
						notifyObservers("The algorithm is not exist\n");

					}else{
						CommonSearcher<Position> searcher;
						Maze3d maze=mazeNames.get(mazeName);
						if(mazeName.equals(m_currentMaze.getName()))
							maze.setStart(m_currentMaze.getCurrentPosition());
						MazeAdapter m=new MazeAdapter(maze);
						ArrayList<State<Position>> s;
						if(temp1.equals("DFS")){
							searcher=new DFS<Position>();
							s=searcher.search(m).getStates();
							Solution<Position> temp=new Solution<Position>(s);
							solutions.put(mazeName, temp);
							solution.put(maze,temp);
							try {
								saveSolution(solution.get(mazeNames.get(mazeName)));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return temp;
							//							setChanged();
							//							notifyObservers("The solution of the maze "+mazeName+" is ready\n" );
						}
						if(temp1.equals("BFS")){
							searcher=new BFS<Position>();
							s=searcher.search(m).getStates();
							Solution<Position> temp=new Solution<Position>(s);
							solutions.put(mazeName, temp);
							solution.put(maze,temp);
							return temp;
							//							setChanged();
							//							notifyObservers("The solution of thw maze "+mazeName+" is ready\n" );
						}
					}
					
				}

				return null;

			}
		});
		try {
			Solution<Position>temp=sol.get();
			if(temp.equals(null))
				return;
			else{
				this.m_currentMaze.setCurrentSolution(temp);
				setChanged();
				notifyObservers("The solution of the maze "+mazeName+" is ready\n");
			}

		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}


	}

	//	});
	//		thread.start();
	//		threads.add(thread);
	//}
	/**
	 * This function is for printing the solution of the maze.
	 */

	/* (non-Javadoc)
	 * @see model.Model#m_display_solution(java.lang.String)
	 */
	@Override
	public void m_display_solution(String mazeName) {
		if(!mazeNames.containsKey(mazeName)){
			setChanged();
			notifyObservers("The maze "+mazeName+" is not exist\n");
		}else{
			Maze3d temp=mazeNames.get(mazeName);
			Solution<Position>tem=solution.get(temp);
			String s=sol(tem);
			setChanged();
			notifyObservers("The solution is: "+ s);
		}

	}
	/**
	 * This function is for exit from the program 
	 * and close all the open threads and the open file.
	 */
	/* (non-Javadoc)
	 * @see model.Model#m_exit()
	 */
	@Override
	public void m_exit() {
		saveToZip();
		//		while (!threads.isEmpty()){
		//			threads.get(0).destroy();
		//			threads.remove(0);
		//		}

		System.exit(0);//This is function is for closing the threads and the file.
	}

	@Override
	public boolean isSolutionExist(Maze3d maze) {

		return solution.containsKey(maze);

	}

	@Override
	public Maze3d mazeByName(String name) {
		return mazeNames.get(name);
	}
	private void saveSolution(Solution<Position>sol) throws FileNotFoundException, IOException{
		try{
			File file=new File("solutions");
			ObjectOutputStream output;
			output = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
			output.writeObject(sol.toString());
			output.flush();
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public void saveToZip() {
		try {
			// save the maze to a ZIP file using GZIPOutputstream
			ObjectOutputStream mazeOut = new ObjectOutputStream(
					new GZIPOutputStream(new FileOutputStream("resources/solutionmaps/fileMazeZip.zip")));
			// write the two hashMaps (with all the info) to the file
			mazeOut.writeObject(mazeNames);
			mazeOut.writeObject(solution);
			mazeOut.flush();
			mazeOut.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();


		}
	}
	@SuppressWarnings("unchecked")

	public void loadFromZip() {
		try {
			FileInputStream mazeFile = new FileInputStream("resources/solutionmaps/fileMazeZip.zip");
			ObjectInputStream mazeIn = new ObjectInputStream(new GZIPInputStream(mazeFile));
			mazeNames = (HashMap<String , Maze3d>) mazeIn.readObject();
			solution = (HashMap<Maze3d , Solution<Position>>) mazeIn.readObject();
			mazeIn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Maze3dGenerator generateByProp(){
		String alg=PropertiesXml.getProperties().getGenerateAlg();
		switch(alg){
		case "lastCell":
			return new lastCellTree();
		case "randomCell":
			return new randomCellTree();
		case "simple":
			return new SimpleMaze3dGenerator();
		default: return null;
		}
	}
//This function is checking if we can move up.
	@Override
	public void m_moveUp() {
		Maze3d maze=this.m_currentMaze.getCurrentMaze();
		Position p=this.m_currentMaze.getCurrentPosition();
		String [] moves=maze.getPossibleMoves(p);
		for(String move:moves){
			if(move.equals("Up")){
				Position temp=new Position(p.getX()+2,p.getY(),p.getZ());
				this.m_currentMaze.setCurrentPosition(temp);
				setChanged();
				notifyObservers("move");
			}
		}
		
	}
	//This function is checking if we can move Down.
	@Override
	public void m_moveDown() {
		Maze3d maze=this.m_currentMaze.getCurrentMaze();
		Position p=this.m_currentMaze.getCurrentPosition();
		String [] moves=maze.getPossibleMoves(p);
		for(String move:moves){
			if(move.equals("Down")){
				Position temp=new Position(p.getX()-2,p.getY(),p.getZ());
				this.m_currentMaze.setCurrentPosition(temp);
				setChanged();
				notifyObservers("move");
			}
		}
		
	}
	//This function is checking if we can move Right
	@Override
	public void m_moveRight() {
		Maze3d maze=this.m_currentMaze.getCurrentMaze();
		Position p=this.m_currentMaze.getCurrentPosition();
		String [] moves=maze.getPossibleMoves(p);
		for(String move:moves){
			if(move.equals("Right")){
				Position temp=new Position(p.getX(),p.getY(),p.getZ()+1);
				this.m_currentMaze.setCurrentPosition(temp);
				setChanged();
				notifyObservers("move");
			}
		}
		
	}
	//This function is checking if we can move Left.
	@Override
	public void m_moveLeft() {
		Maze3d maze=this.m_currentMaze.getCurrentMaze();
		Position p=this.m_currentMaze.getCurrentPosition();
		String [] moves=maze.getPossibleMoves(p);
		for(String move:moves){
			if(move.equals("Left")){
				Position temp=new Position(p.getX(),p.getY(),p.getZ()-1);
				this.m_currentMaze.setCurrentPosition(temp);
				setChanged();
				notifyObservers("move");
			}
		}
		
	}
	//This function is checking if we can move Forward.
	@Override
	public void m_moveForward() {
		Maze3d maze=this.m_currentMaze.getCurrentMaze();
		Position p=this.m_currentMaze.getCurrentPosition();
		String [] moves=maze.getPossibleMoves(p);
		for(String move:moves){
			if(move.equals("Forward")){
				Position temp=new Position(p.getX(),p.getY()+1,p.getZ());
				this.m_currentMaze.setCurrentPosition(temp);
				setChanged();
				notifyObservers("move");
			}
		}
		
	}
	//This function is checking if we can move Backward.
	@Override
	public void m_moveBackward() {
		Maze3d maze=this.m_currentMaze.getCurrentMaze();
		Position p=this.m_currentMaze.getCurrentPosition();
		String [] moves=maze.getPossibleMoves(p);
		for(String move:moves){
			if(move.equals("BackWard")){
				Position temp=new Position(p.getX(),p.getY()-1,p.getZ());
				this.m_currentMaze.setCurrentPosition(temp);
				setChanged();
				notifyObservers("move");
			}
		}
		
	}

	@Override
	public void m_hint() {
		ArrayList<State<Position>> s;
		CommonSearcher<Position> searcher;
		MazeAdapter m=new MazeAdapter(m_currentMaze.getCurrentMaze());
		searcher=new DFS<Position>();
		s=searcher.search(m).getStates();
		int i=s.indexOf(m_currentMaze.getCurrentPosition());
		Position t=s.get(i+1).getState();
		//Solution<Position> temp=new Solution<Position>(s);
		//this.m_currentMaze.setCurrentSolution(temp);
		//solution.put(m_currentMaze.getCurrentMaze(),temp);
		this.m_currentMaze.setHint(t);
		setChanged();
		notifyObservers("hint");
		
	}
}
