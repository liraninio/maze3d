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

	private ExecutorService executor=Executors.newFixedThreadPool(2);

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
				switch(alg){
				case "radomCell": maze=new randomCellTree().generate(p);
				break;
				case "lastCell": maze=new lastCellTree().generate(p);
				break;
				case "simple": maze=new SimpleMaze3dGenerator().generate(p);
				break;
				default: setChanged();
				notifyObservers("try again\n");
				}
				if(maze!=null)
					return maze;
				else return null;
			}

		});
		try{
			Maze3d maze=m.get();
			if(maze==null)
				return;
			mazeNames.put(nameMaze,maze);
		}catch(InterruptedException | ExecutionException e){
			e.printStackTrace();
		}

		setChanged();
		notifyObservers("maze " + nameMaze+ " is ready\n");

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
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
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
			InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
			byte[]temp=new byte[100000];
			in.read(temp);
			in.close();
			Maze3d maze=new Maze3d(temp);
			mazeNames.put(mazeName,maze);
			setChanged();
			notifyObservers("The maze was loaded successfully\n");
		}catch(FileNotFoundException e){
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
					if((!alg.equals("DFS"))&&(!alg.equals("BFS"))){
						setChanged();
						notifyObservers("The algorithm is not exist\n");

					}else{
						CommonSearcher<Position> searcher;
						Maze3d maze=mazeNames.get(mazeName);
						MazeAdapter m=new MazeAdapter(maze);
						ArrayList<State<Position>> s;
						if(alg.equals("DFS")){
							searcher=new DFS<Position>();
							s=searcher.search(m).getStates();
							Solution<Position> temp=new Solution<Position>(s);
							solutions.put(mazeName, temp);
							solution.put(maze,temp);
							saveSolution(solution.get(mazeNames.get(mazeName)));
							return temp;
							//							setChanged();
							//							notifyObservers("The solution of the maze "+mazeName+" is ready\n" );
						}
						if(alg.equals("BFS")){
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
					new GZIPOutputStream(new FileOutputStream("fileMazeZip.zip")));
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
			FileInputStream mazeFile = new FileInputStream("fileMazeZip.zip");
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
}
