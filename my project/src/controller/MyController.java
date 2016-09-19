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

// TODO: Auto-generated Javadoc
/**
 * The Class MyController- this class is "exercizing" all the functions
 * this class is mediate between the model and the view.
 */
public class MyController{// implements Controller {
}
///** The model. */
//private Model model;
//
///** The view. */
//private View view;
//
///** The commands. */
//HashMap<String,Command>commands;
//
///**
// * Instantiates a new my controller.
// *
// * @param m the m
// * @param v the v
// */
//public MyController(Model m,View v){
//	this.model=m;
//	this.view=v;
//}
//
///* (non-Javadoc)
// * @see controller.Controller#display_message(java.lang.String)
// */
//@Override
//public void display_message(String message) {
//	view.display_message(message);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#setModel(model.Model)
// */
//@Override
//public void setModel(Model m) {
//	this.model=m;
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#setView(view.View)
// */
//
////public void setView(View v) {
////	this.view=v;
////	this.commands=new HashMap<String,Command>();
////	this.commands.put("generate_maze",new Generate_maze(this));
////	this.commands.put("display",new Display(this));
////	this.commands.put("display_cross_section",new Display_cross_section(this));
////	this.commands.put("save_maze",new Save_maze(this));
////	this.commands.put("load_maze",new Load_maze(this));
////	this.commands.put("dir",new Dir(this));
////	this.commands.put("solve_maze",new Solve(this));
////	this.commands.put("display_solution",new Display_solution(this));
////	this.commands.put("exit",new Exit(this));
////	this.view.v_send_commands(commands);
////}
//	
//
///* (non-Javadoc)
// * @see controller.Controller#c_generate(java.lang.String, int, int, int, java.lang.String)
// */
//@Override
//public void c_generate(String nameMaze, int x, int y, int z,String alg) {
//	this.model.m_generate(nameMaze, x, y, z,alg);
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_display(java.lang.String)
// */
//@Override
//public void c_display(String name) {
//	model.m_display(name);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_displayAnswer(java.lang.String)
// */
//@Override
//public void c_displayAnswer(String maze) {
//	view.v_display(maze);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_display_cross_section(int, java.lang.String, java.lang.String)
// */
//@Override
//public void c_display_cross_section(int num,String index, String name) {
//	model.m_display_cross_section(num,index, name);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_save_maze(java.lang.String, java.lang.String)
// */
//@Override
//public void c_save_maze(String mazeName, String fileName) {
//	model.m_save_maze(mazeName, fileName);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_load_maze(java.lang.String, java.lang.String)
// */
//@Override
//public void c_load_maze(String fileName, String mazeName) throws IOException {
//	model.m_load_maze(fileName, mazeName);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_dir(java.lang.String)
// */
//@Override
//public void c_dir(String path) {
//	view.v_dir(path);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_solve(java.lang.String, java.lang.String)
// */
//@Override
//public void c_solve(String mazeName, String alg) {
//	model.m_solve(mazeName, alg);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_display_solution(java.lang.String)
// */
//@Override
//public void c_display_solution(String mazeName) {
//	model.m_display_solution(mazeName);
//	
//}
//
///* (non-Javadoc)
// * @see controller.Controller#c_exit()
// */
//@Override
//public void c_exit() {
//	model.m_exit();
//	
//}
//
//
//}
