package controller;

import java.io.IOException;

import model.Model;
import view.View;

public interface Controller {
	public void controller_generate(String nameMaze,int x,int y,int z);

	public void display_message(String string);
	public void setModel(Model m);
	public void setView(View v);
	public void c_display(String name);
	public void c_displayAnswer(String maze);
	public void c_display_cross_section(int num,String index,String name);
	public void c_save_maze(String mazeName,String fileName);
	public void c_load_maze(String fileName,String mazeName) throws IOException;
	public void c_dir(String path);
	public void c_solve(String mazeName,String alg);
	public void c_display_solution(String mazeName);
	public void c_exit();
	
	
}
