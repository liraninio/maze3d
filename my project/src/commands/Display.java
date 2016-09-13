package commands;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Display-is for printing the maze3d for user.
 */
public class Display implements Command{

/** The c. */
public Controller c;

/**
 * Instantiates a new display.
 *
 * @param c the c
 */
public Display(Controller c){
	this.c=c;
}

/* (non-Javadoc)
 * @see controller.Command#doCommand(java.lang.String)
 */
@Override
public void doCommand(String command) {
	String [] temp=command.split(" ");
	if (temp.length==2){
		String s=temp[1];
		c.c_display(s);
	}else
	{
		c.display_message("Wrong input");
	}
	
	
	
}

}
