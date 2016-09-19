package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;

import controller.Controller;
import presenter.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class MyView- this class is responsible on the actions that 
 * only shoe the user things from the model.
 * this class knows only the controller that mediate 
 * between the model and the view.
 */
public class MyView extends Observable implements View {
	
	/** The controller. */
	private Controller controller;
	
	/** The cli. */
	private CLI cli;
	
	/** The in. */
	protected BufferedReader in;
	
	/** The out. */
	protected PrintWriter out;
	
	/** The commands. */
	protected HashMap<String,Command> commands;

	/* (non-Javadoc)
	 * @see view.View#v_start()
	 */
	public void v_start() {
		cli.start();

	}
	
	/**
	 * Instantiates a new my view.
	 *
	 * @param in the in
	 * @param out the out
	 * @param commands the commands
	 */
	public MyView(BufferedReader in,PrintWriter out,HashMap<String,Command> commands){
		this.in=in;
		this.out=out;
		this.commands=commands;
		this.cli=new CLI(in,out,commands);
	}
	
	/**
	 * Instantiates a new my view.
	 *
	 * @param cont the cont
	 */
	public MyView(Controller cont){
		this.setController(cont);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Gets the cli.
	 *
	 * @return the cli
	 */
	public CLI getCli() {
		return cli;
	}

	/**
	 * Sets the cli.
	 *
	 * @param cli the new cli
	 */
	public void setCli(CLI cli) {
		this.cli = cli;
	}

	/**
	 * Gets the in.
	 *
	 * @return the in
	 */
	public BufferedReader getIn() {
		return in;
	}

	/**
	 * Sets the in.
	 *
	 * @param in the new in
	 */
	public void setIn(BufferedReader in) {
		this.in = in;
	}

	/**
	 * Gets the out.
	 *
	 * @return the out
	 */
	public PrintWriter getOut() {
		return out;
	}

	/**
	 * Sets the out.
	 *
	 * @param out the new out
	 */
	public void setOut(PrintWriter out) {
		this.out = out;
	}
	
	/**
	 * Sets the c.
	 *
	 * @param c the new c
	 */
	public void setC(Controller c){
		this.controller=c;
	}

	/* (non-Javadoc)
	 * @see view.View#display_message(java.lang.String)
	 */
	@Override
	public void display_message(String message) {
		out.write(message);
		out.flush();

	}
	
	/* (non-Javadoc)
	 * @see view.View#v_send_commands(java.util.HashMap)
	 */
	@Override
	public void v_send_commands(HashMap<String, Command> commands) {
		this.cli=new CLI(in,out,commands);

	}
	
	/* (non-Javadoc)
	 * @see view.View#v_display(java.lang.String)
	 */
	@Override
	public void v_display(String maze) {
		out.write(maze);
	}
	/**
	 * This function is for printing all the files that are exist in the directory.
	 */
	/* (non-Javadoc)
	 * @see view.View#v_dir(java.lang.String)
	 */
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
	public void setCommand(HashMap<String,Command> commands){
		this.commands=new HashMap<String,Command>();
		this.commands=commands;
		this.cli.setHash(commands);
	}
}

