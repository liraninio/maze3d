package controller;

import java.io.IOException;

import model.Model;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Interface Controller- this class is for the view and the model
 * that can use this functions when they needs to.
 */
public interface Controller {
	
	/**
	 * C generate.
	 *
	 * @param nameMaze the name maze
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param alg the alg
	 */
	public void c_generate(String nameMaze,int x,int y,int z,String alg);
	
	/**
	 * Display message.
	 *
	 * @param string the string
	 */
	public void display_message(String string);
	
	/**
	 * Sets the model.
	 *
	 * @param m the new model
	 */
	public void setModel(Model m);
	
	/**
	 * Sets the view.
	 *
	 * @param v the new view
	 */
	public void setView(View v);
	
	/**
	 * C display.
	 *
	 * @param name the name
	 */
	public void c_display(String name);
	
	/**
	 * C display answer.
	 *
	 * @param maze the maze
	 */
	public void c_displayAnswer(String maze);
	
	/**
	 * C display cross section.
	 *
	 * @param num the num
	 * @param index the index
	 * @param name the name
	 */
	public void c_display_cross_section(int num,String index,String name);
	
	/**
	 * C save maze.
	 *
	 * @param mazeName the maze name
	 * @param fileName the file name
	 */
	public void c_save_maze(String mazeName,String fileName);
	
	/**
	 * C load maze.
	 *
	 * @param fileName the file name
	 * @param mazeName the maze name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void c_load_maze(String fileName,String mazeName) throws IOException;
	
	/**
	 * C dir.
	 *
	 * @param path the path
	 */
	public void c_dir(String path);
	
	/**
	 * C solve.
	 *
	 * @param mazeName the maze name
	 * @param alg the alg
	 */
	public void c_solve(String mazeName,String alg);
	
	/**
	 * C display solution.
	 *
	 * @param mazeName the maze name
	 */
	public void c_display_solution(String mazeName);
	
	/**
	 * C exit.
	 */
	public void c_exit();
	
	
}
