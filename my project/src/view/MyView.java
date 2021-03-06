package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;

import algorithmes.mazeGenerators.Position;
import algorithmes.search.Solution;
import model.CurrentMaze;
//import controller.Controller;
import presenter.Command;
import utils.PropertiesXml;

// TODO: Auto-generated Javadoc
/**
 * The Class MyView- this class is responsible on the actions that 
 * only shoe the user things from the model.
 * this class knows only the controller that mediate 
 * between the model and the view.
 */
public class MyView extends Observable implements View {
	
	/** The controller. */
//	private Controller controller;
	
	/** The cli. */
	private CLI cli;
	
	/** The in. */
	protected BufferedReader in;
	
	/** The out. */
	protected PrintWriter out;
	
	/** The commands. */
	protected HashMap<String,Command> commands;
	private MazeWindow gui;
	private CurrentMaze currentMaze;
	private String mazeName;
	private boolean hint;

	public boolean getHint() {
		return hint;
	}

	public void setHint(boolean hint) {
		this.hint = hint;
	}

	public String getMazeName() {
		return mazeName;
	}

	public void setMazeName(String mazeName) {
		this.mazeName = mazeName;
	}

	public CurrentMaze getCurrentMaze() {
		return currentMaze;
	}

	public void setNewCurrentMaze(CurrentMaze currentMaze) {
		this.currentMaze = currentMaze;
		this.gui.setNewCurrentmaze(currentMaze);
	}

	/* (non-Javadoc)
	 * @see view.View#v_start()
	 */
	public void v_start() {
		//cli.setHash(commands);
		String temp=PropertiesXml.getProperties().getUi();
		if(temp.equals("gui")){
		//cli.start();
		this.gui=new MazeWindow(this);
		gui.start();
		}else{
			cli=new CLI(in,out);
			cli.setHash(commands);
			cli.start();
		}

	}
	
	/**
	 * Instantiates a new my view.
	 *
	 * @param in the in
	 * @param out the out
	 * @param commands the commands
	 */
	public MyView(BufferedReader in,PrintWriter out){
		this.in=in;
		this.out=out;
		
		this.cli=new CLI(in,out);
		//if(gui==null){
			
		//}
		//this.gui=new MazeWindow(this);
		//gui.start();
	}
	public MyView(){
		this.cli=null;
	}
	
	/**
	 * Instantiates a new my view.
	 *
	 * @param cont the cont
	 */
//	public MyView(Controller cont){
//		this.setController(cont);
//	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
//	public Controller getController() {
//		return controller;
//	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
//	public void setController(Controller controller) {
//		this.controller = controller;
//	}

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
//	public void setC(Controller c){
//		this.controller=c;
//	}

	/* (non-Javadoc)
	 * @see view.View#display_message(java.lang.String)
	 */
	@Override
	public void display_message(String message) {
		String in=(message);
		String [] com=null;
		com=in.split(" ");
		if(gui==null){
		out.write(message);
		out.flush();}
		else{
			if(com[1].equals("solution")){
				gui.solutionAnimation(currentMaze.getCurrentSolution());
			}
			gui.displayMessage(message);
		}

	}
	
	/* (non-Javadoc)
	 * @see view.View#v_send_commands(java.util.HashMap)
	 */
	@Override
	public void v_send_commands(HashMap<String, Command> commands) {
		this.cli.setHash(commands);

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
	//	this.cli.setHash(commands);
	}
	public void executeCommand(String string){
//		Scanner s = new Scanner(string);
//		try{
//		String command=s.next();
//		if(commands.containsKey(command)){
//			setChanged();
//			notifyObservers(string);
//			s.close();
//		}
//		else
//			out.println("No such command");
//		s.close();
//		}catch(NoSuchElementException e){
//			out.println("No such command");
//		}
//	}
//		String[]temp=string.split(" ");
//		if(commands.containsKey(temp[0]))
//			string.doCommad();
		//cli.start();
		setChanged();
		notifyObservers(string);
	//	out.println(string);
	}

	@Override
	public CurrentMaze setPosCurrentMaze(CurrentMaze currentmaze) {
		this.gui.setPosCurrentmaze(currentmaze);
		return null;
	}

	@Override
	public boolean getGui() {
		if(gui==null)
			return false;
		return true;
	}
	public void solution(Solution<Position>sol){
		if(cli!=null){
			
		}
	}

	
}

