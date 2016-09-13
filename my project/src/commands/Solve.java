package commands;

import java.io.IOException;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Solve- is for solving the maze3d by the algorithm the user asked for (DFS/BFS).
 */
public class Solve implements Command{

/** The c. */
private Controller c;

/**
 * Instantiates a new solve.
 *
 * @param c the c
 */
public Solve(Controller c){
	this.c=c;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		String[] temp=command.split(" ");
		if(temp.length==3)
		{
			c.c_solve(temp[1],temp[2]);
		}else
			c.display_message("Wrong input, please try again\n");
	}

}
