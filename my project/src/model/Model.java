package model;

import java.io.IOException;

import algorithmes.mazeGenerators.Maze3d;

// TODO: Auto-generated Javadoc
/**
 * The Interface Model- this class is for the controller,
 * that uses at this functions when needs.
 */
public interface Model {
	
	/**
	 * M generate.
	 *
	 * @param nameMaze the name maze
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param alg the alg
	 */
	public void m_generate(String nameMaze,int x,int y,int z,String alg);
	
	/**
	 * M display.
	 *
	 * @param name the name
	 */
	public void m_display(String name);
	
	/**
	 * M display cross section.
	 *
	 * @param num the num
	 * @param index the index
	 * @param name the name
	 */
	public void m_display_cross_section(int num,String index,String name);
	
	/**
	 * M save maze.
	 *
	 * @param mazeName the maze name
	 * @param fileName the file name
	 */
	public void m_save_maze(String mazeName,String fileName);
	
	/**
	 * M load maze.
	 *
	 * @param fileName the file name
	 * @param mazeName the maze name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void m_load_maze(String fileName,String mazeName) throws IOException;
	
	/**
	 * M solve.
	 *
	 * @param mazeName the maze name
	 * @param alg the alg
	 */
	public void m_solve(String mazeName,String alg);
	
	/**
	 * M display solution.
	 *
	 * @param mazeName the maze name
	 */
	public void m_display_solution(String mazeName);
	
	/**
	 * M exit.
	 */
	public void m_exit();
	public boolean isSolutionExist(Maze3d maze);
	public Maze3d mazeByName(String name);
}
