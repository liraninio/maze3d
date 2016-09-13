package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

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
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel implements Model {
	private Controller controller;
	private HashMap<String, Maze3d>mazeNames;
	private ArrayList<Thread>threads;
	private ArrayList<File>files;
	private HashMap<String,Solution<Position>> solutions;
	public MyModel(){
		this.mazeNames=new HashMap<String, Maze3d>();
		this.solutions=new HashMap<String, Solution<Position>>();
		this.threads=new ArrayList<Thread>();
		this.files=new ArrayList<File>();
	}
	public void setC(Controller c){
		this.controller=c;
	}
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
	@Override
	public void m_generate(String nameMaze, int x, int y, int z,String alg) {
		Thread thread=new Thread(new Runnable() {

			@Override
			public void run() {
				Position p=new Position(x,y,z);
				Maze3d maze=null;
				switch(alg){
				case "radomCell": maze=new randomCellTree().generate(p);
				break;
				case "lastCell": maze=new lastCellTree().generate(p);
				break;
				case "simple": maze=new SimpleMaze3dGenerator().generate(p);
				break;
				default: controller.display_message("Wrong input, the algorithm for buildind maze is not exist\n");
				}
				
				mazeNames.put(nameMaze, maze);
				controller.display_message("maze " + nameMaze+ " is ready\n");

}
			
		});
		thread.start();
		threads.add(thread);
	}

	@Override
	public void m_display(String name) {
		if(!mazeNames.containsKey(name)){
			controller.display_message("The maze is not exist\n");
		}else{
			Maze3d maze=mazeNames.get(name);
			String s=maze.toString();
			controller.display_message(s);
		}

	}
	@Override
	public void m_display_cross_section(int num,String index, String name) {

		if(!mazeNames.containsKey(name)){
			controller.display_message("The maze is not exist\n");
		}else{
			Maze3d maze=mazeNames.get(name);
			if((index.equals("x")&&num>=maze.getP().getX())||(index.equals("y")&&num>=maze.getP().getY())||(index.equals("z")&&num>=maze.getP().getZ()))
			{
				controller.display_message("There is an exception\n");	
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
				controller.display_message(temp);
			}
		}

	}
	@Override
	public void m_save_maze(String mazeName, String fileName) {
		if(!mazeNames.containsKey(mazeName)){
			controller.display_message("The maze is not exist\n");
		}else{
			try{
				Maze3d maze=mazeNames.get(mazeName);
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
				out.write(maze.toByteArray());
				out.close();
				controller.display_message("The maze "+ mazeName+" was saved successfully\n");

			}catch(IOException e)
			{
				controller.display_message("cant save the maze\n");
			}
		}

	}
	@Override
	public void m_load_maze(String fileName, String mazeName) throws IOException{
		try{
			InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
			byte[]temp=new byte[100000];
			in.read(temp);
			in.close();
			Maze3d maze=new Maze3d(temp);
			mazeNames.put(mazeName,maze);
			controller.display_message("The maze was loaded successfully\n");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}


	}
	@Override
	public void m_solve(String mazeName, String alg) {
		Thread thread=new Thread(new Runnable() {

			@Override
			public void run() {



				if (!mazeNames.containsKey(mazeName)){
					controller.display_message("The maze isn't exist\n");
				}else{
					if((!alg.equals("DFS"))&&(!alg.equals("BFS")))
						controller.display_message("The algorithm is not exist\n");
					CommonSearcher<Position> searcher;
					Maze3d maze=mazeNames.get(mazeName);
					MazeAdapter m=new MazeAdapter(maze);
					ArrayList<State<Position>> s;
					if(alg.equals("DFS")){
						searcher=new DFS<Position>();
						s=searcher.search(m).getStates();
						Solution<Position> temp=new Solution<Position>(s);
						solutions.put(mazeName, temp);
						controller.display_message("The solution of thw maze "+mazeName+" is ready\n" );
					}
					if(alg.equals("BFS")){
						searcher=new BFS<Position>();
						s=searcher.search(m).getStates();
						Solution<Position> temp=new Solution<Position>(s);
						solutions.put(mazeName, temp);
						controller.display_message("The solution of thw maze "+mazeName+" is ready\n" );
					}
				}

			}
		
	});
		thread.start();
		threads.add(thread);
}

		@Override
		public void m_display_solution(String mazeName) {
			if(!solutions.containsKey(mazeName)){
				controller.display_message("The maze "+mazeName+" is not exist\n");
			}else{
				Solution<Position>temp=solutions.get(mazeName);
				String s=sol(temp);
				controller.display_message("The solution is: "+ s);
			}

		}
		@Override
		public void m_exit() {
			while (!threads.isEmpty()){
				threads.remove(0);
			}
			
			
		}
}
