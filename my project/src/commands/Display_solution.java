package commands;

import java.io.IOException;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Display_solution-is for printing the solution for the user.
 */
public class Display_solution implements Command{

/** The c. */
private Controller c;

/**
 * Instantiates a new display solution.
 *
 * @param c the c
 */
public Display_solution(Controller c){
	this.c=c;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		String [] temp=command.split(" ");
		if(temp.length==2){
			c.c_display_solution(temp[1]);
		}else
			c.display_message("Wrong input\n");
		
	}

}
