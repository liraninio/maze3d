package commands;

import java.io.IOException;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Load_maze- is for loading a maze3d by the file the user asked, and by the name of the maze.
 */
public class Load_maze implements Command {

/** The c. */
private Controller c;

/**
 * Instantiates a new load maze.
 *
 * @param c the c
 */
public Load_maze(Controller c){
	this.c=c;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		String []temp=command.split(" ");
		if(temp.length==3){
			c.c_load_maze(temp[1], temp[2]);
		}else
			c.display_message("Wrong input\n");
		
	}

}
