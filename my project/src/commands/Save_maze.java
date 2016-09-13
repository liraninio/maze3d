package commands;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Save_maze- is for saving the maze3d at the file that the user asked.
 */
public class Save_maze implements Command {

/** The c. */
private Controller c;

/**
 * Instantiates a new save maze.
 *
 * @param c the c
 */
public Save_maze(Controller c){
	this.c=c;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String [] temp=command.split(" ");
		if(temp.length==3)
		c.c_save_maze(temp[1],temp[2]);
		else
			c.display_message("Wrong Input");
		
	}

}
