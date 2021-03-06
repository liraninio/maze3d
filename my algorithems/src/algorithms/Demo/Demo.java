
package algorithms.Demo;

import java.util.ArrayList;

import algorithmes.mazeGenerators.Maze3d;
import algorithmes.mazeGenerators.Maze3dGenerator;
import algorithmes.mazeGenerators.Position;
import algorithmes.mazeGenerators.lastCellTree;
import algorithmes.search.BFS;
import algorithmes.search.CommonSearcher;
import algorithmes.search.DFS;
import algorithmes.search.State;


/**
 * The Class Demo- is the run the main
 * that checking the algorithms 
 * and the maze.
 */
public class Demo {
	
	/**
	 * Test maze generator.
	 *
	 * @param mg the mg
	 */
	public static void run(Maze3dGenerator mg){

		Position p=new Position(9,9,9);
		Maze3d maze=mg.generate(p);
		System.out.println("***** The maze is *****");
		System.out.println(maze);
		System.out.println(maze.getStartPosition());
		System.out.println(maze.getGoalPosition());
		MazeAdapter m=new MazeAdapter(maze);
		CommonSearcher<Position> searcher;
		//ArrayList<State<Position>>s3;
		ArrayList<State<Position>> s3;
		ArrayList<State<Position>> s4;
		System.out.println("dfs");
		searcher=new DFS<Position>();
		s4=searcher.search(m).getStates();
		System.out.println("The solution is "+s4);
		System.out.println("number of modes "+searcher.getNumberOfNodesEvaluated());
		System.out.println("bfs");
		searcher=new BFS<Position>();
		s3=searcher.search(m).getStates();
		System.out.println("The solution is "+s3);
		System.out.println("number of modes "+searcher.getNumberOfNodesEvaluated());

	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		run(new lastCellTree());
		//testMazeGenerator(new Maze3dGenerator());
	}
}