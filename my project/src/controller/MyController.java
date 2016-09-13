package controller;
import java.io.IOException;
import java.util.HashMap;

import commands.Dir;
import commands.Display;
import commands.Display_cross_section;
import commands.Display_solution;
import commands.Exit;
import commands.Generate_maze;
import commands.Load_maze;
import commands.Save_maze;
import commands.Solve;
import model.Model;
import view.View;

public class MyController implements Controller {
private Model model;
private View view;
HashMap<String,Command>commands;
public MyController(Model m,View v){
	this.model=m;
	this.view=v;
}

@Override
public void display_message(String message) {
	view.display_message(message);
	
}
@Override
public void setModel(Model m) {
	this.model=m;
	
}
@Override
public void setView(View v) {
	this.view=v;
	this.commands=new HashMap<String,Command>();
	this.commands.put("generate_maze",new Generate_maze(this));
	this.commands.put("display",new Display(this));
	this.commands.put("display_cross_section",new Display_cross_section(this));
	this.commands.put("save_maze",new Save_maze(this));
	this.commands.put("load_maze",new Load_maze(this));
	this.commands.put("dir",new Dir(this));
	this.commands.put("solve_maze",new Solve(this));
	this.commands.put("display_solution",new Display_solution(this));
	this.commands.put("exit",new Exit(this));
	this.view.v_send_commands(commands);
}
	

@Override
public void controller_generate(String nameMaze, int x, int y, int z) {
	this.model.m_generate(nameMaze, x, y, z);
}

@Override
public void c_display(String name) {
	model.m_display(name);
	
}

@Override
public void c_displayAnswer(String maze) {
	view.v_display(maze);
	
}

@Override
public void c_display_cross_section(int num,String index, String name) {
	model.m_display_cross_section(num,index, name);
	
}

@Override
public void c_save_maze(String mazeName, String fileName) {
	model.m_save_maze(mazeName, fileName);
	
}

@Override
public void c_load_maze(String fileName, String mazeName) throws IOException {
	model.m_load_maze(fileName, mazeName);
	
}

@Override
public void c_dir(String path) {
	view.v_dir(path);
	
}

@Override
public void c_solve(String mazeName, String alg) {
	model.m_solve(mazeName, alg);
	
}

@Override
public void c_display_solution(String mazeName) {
	model.m_display_solution(mazeName);
	
}

@Override
public void c_exit() {
	model.m_exit();
	
}


}
