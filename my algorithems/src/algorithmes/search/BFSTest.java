package algorithmes.search;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import algorithmes.mazeGenerators.Maze3d;
import algorithmes.mazeGenerators.Position;
import algorithmes.mazeGenerators.lastCellTree;
import algorithmes.mazeGenerators.randomCellTree;
import algorithms.Demo.MazeAdapter;

// TODO: Auto-generated Javadoc
/**
 * The Class BFSTest.
 */
public class BFSTest {

	/**
	 * Check last cell algorithm.
	 */
	@Test
	public void checkLastCell() {
		Maze3d maze;
		Position p=new Position(12,12,12);
		maze=new lastCellTree().generate(p);
		MazeAdapter m=new MazeAdapter(maze);
		CommonSearcher<Position> searcher=new BFS<Position>();
		Solution<Position> solution= searcher.search(m);
		assertNotNull(solution);
	}
	
	/**
	 * Check random cell algorithm.
	 */
	@Test
	public void checkRandomCell() {
		Maze3d maze;
		Position p=new Position(12,12,12);
		maze=new randomCellTree().generate(p);
		MazeAdapter m=new MazeAdapter(maze);
		CommonSearcher<Position> searcher=new BFS<Position>();
		Solution<Position> solution= searcher.search(m);
		assertNotNull(solution);
	}
}
