package commands;

import java.io.IOException;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Dir- is for printing the user all the files under the directory we asked for.
 */
public class Dir implements Command {

/** The c. */
private Controller c;

/**
 * Instantiates a new dir.
 *
 * @param c the c
 */
public Dir(Controller c){
	this.c=c;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		String [] temp=command.split(" ");
		if (temp.length==2){
			c.c_dir(temp[1]);
		}
		else{
			c.display_message("Wrong input\n");
		}
		
	}

}
