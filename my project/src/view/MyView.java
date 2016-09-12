package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public class MyView implements View {
	private Controller controller;
	private CLI cli;
	protected BufferedReader in;
	protected PrintWriter out;
	protected HashMap<String,Command> commands;

	public void v_start() {
		cli.start();

	}
	public MyView(BufferedReader in,PrintWriter out,HashMap<String,Command> commands){
		this.in=in;
		this.out=out;
		this.commands=commands;
		this.cli=new CLI(in,out,commands);
	}
	public MyView(Controller cont){
		this.setController(cont);
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public CLI getCli() {
		return cli;
	}

	public void setCli(CLI cli) {
		this.cli = cli;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}
	public void setC(Controller c){
		this.controller=c;
	}

	@Override
	public void display_message(String message) {
		out.write(message);
		out.flush();

	}
	@Override
	public void v_send_commands(HashMap<String, Command> commands) {
		this.cli=new CLI(in,out,commands);

	}
	@Override
	public void v_display(String maze) {
		out.write(maze);
	}
	@Override

	public void v_dir(String path) {
		try{
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++){
				if (listOfFiles[i].isFile())
					out.println("File " + listOfFiles[i].getName());
				else if (listOfFiles[i].isDirectory()) 
					out.println("Directory " + listOfFiles[i].getName());
			}
		}catch(NullPointerException e){
			out.println("Bad parameters, try again");
		}

	}
}

