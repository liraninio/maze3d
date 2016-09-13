package commands;

import java.io.IOException;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Exit- is for close the program when the user ask,
 * and close the open threads and the open files.
 */
public class Exit implements Command {

/** The c. */
private Controller c;

/**
 * Instantiates a new exit.
 *
 * @param c the c
 */
public Exit(Controller c){
	this.c=c;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		c.c_exit();
		
	}

}
