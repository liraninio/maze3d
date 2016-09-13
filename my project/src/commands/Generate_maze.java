package commands;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Generate_maze- is for generating a maze3d at the length the user asked
 * and by the algorithm the user asked.
 */
public class Generate_maze implements Command {

/** The c. */
public Controller c;

/**
 * Instantiates a new generate maze.
 *
 * @param c the c
 */
public Generate_maze(Controller c){
	this.c=c;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String [] temp=command.split(" ");
		if(temp.length==6){
			int x,y,z;
			try{
			x=Integer.parseInt(temp[2]);
			y=Integer.parseInt(temp[3]);
			z=Integer.parseInt(temp[4]);
			c.c_generate(temp[1], x, y, z,temp[5]);
			}catch(NumberFormatException  e){
				c.display_message("Wrong input- you should send numbers of the length\n");
				
			}
		}else{
			this.c.display_message("Wrong Input- you should write the command,the length\n");
		
		}
		
	}

}
