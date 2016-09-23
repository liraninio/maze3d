package view;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import presenter.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class CLI- is a receptor for commands from the user
 * the cli is getting a command and send it to the responsible command.
 */
public class CLI {
	
	/** The in. */
	private BufferedReader in;
	
	/** The out. */
	private PrintWriter out;
	
	/** The hash. */
	private HashMap<String,Command> hash;
	
	/**
	 * Instantiates a new cli.
	 *
	 * @param i the i
	 * @param o the o
	 */
//	public CLI(BufferedReader i, PrintWriter o){
//		
//		this.in=i;
//		this.out=o;
//		this.hash=new HashMap<String,Command>();
//		
//	}
	
/**
 * the cli is getting an output file, input file and a hash that saving the name of the mazes.
 *
 * @param in the in
 * @param out the out
 * @param hash the hash
 */
	public CLI(BufferedReader in,PrintWriter out){
		this.in=in;
		this.out=out;
		hash=new HashMap<String,Command>();
		
	}


/**
 * Start.
 */
public void start(){
		//create Thread
	//	new Thread(new Runnable() {
			

			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
	//		@Override
	//		public void run() {
				try{
					//ask user for command.
					
					out.println("1-for creating a maze use the command:"
							+ " generate_maze\n    now split and after that the name\n "
							+ "   split and after that type the 3 numbers that will be the length\n    split and after that the algorithm(lastCell/randomCell/simple)\n");
					out.println("2-for view all files in adirectory use the command: dir\n"
							+ "    now split and write the path\n");
					out.println("3-for printing the maze use the command: display\n"
							+ "    now split and write the name of the maze\n");
					out.println("4-For printing a 2d maze use the command: display_cross_section\n"
							+ "    now split and after that write the index\n"
							+ "    split and after that write the pivot(x/y/z)\n"
							+ "    split and write the name of the maze\n");
					out.println("5-For saving a maze use the command: save_maze\n"
							+ "    split and write the name of the maze\n"
							+ "    split write the name of the file\n");
					out.println("6-For loading a maze use the command: load_maze\n"
							+ "    split and write the name of the file\n"
							+ "    split and write the namr of the maze\n");
					out.println("7-For solving the maze use the command: solve_maze\n"
							+ "    split and write the name of the maze\n"
							+ "    split and write the name of the algorithm(DFS/BFS)\n");
					out.println("8-For printing the solution use the command: display_solution\n"
							+ "    split and write the name of the maze\n");
					out.println("9-For closing the program use the command: exit\n");
					out.println("Please enter your command");
					out.flush();
					//get command
					String commandName=in.readLine();
					Command command=null;

					while(!commandName.equals("exit")){
						command= hash.get(commandName.split(" ")[0]);
						if(command!=null){
							
							if(commandName.split(" ").length>=1){
								if(commandName.split(" ").length==1)
									command.doCommand(commandName);
								else
								command.doCommand(commandName.substring(commandName.indexOf(' ') ));
							}else {
								out.println("InValid Parmeter\n");
								out.flush();
							}
						}else {
							out.println("this command is not exits\n");
							out.flush();
						}

						out.println("please enter a new command");
						out.flush();
						commandName = in.readLine();

					}
					hash.get("exit").doCommand("");


				}catch(Exception e){
					e.printStackTrace();
				}

}
	//	}).start();

//	}


	/**
	 * Gets the hash.
	 *
	 * @return the hash
	 */
	public HashMap<String, Command> getHash() {
		return hash;
	}


	/**
	 * Sets the hash.
	 *
	 * @param hash the hash
	 */
	public void setHash(HashMap<String, Command> hash) {
		this.hash=hash;
	}
	
}
