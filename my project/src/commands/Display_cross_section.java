package commands;

import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Display_cross_section-is for printing the user the maze2d by the index and the pivot we asked for.
 */
public class Display_cross_section implements Command {
	
	/** The c. */
	private Controller c;
	
	/**
	 * Instantiates a new display cross section.
	 *
	 * @param c the c
	 */
	public Display_cross_section(Controller c){
		this.c=c;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String [] temp=command.split(" ");
		try{
			if (temp.length==4){

				int num=Integer.parseInt(temp[1]);
				String index=temp[2];
				String name=temp[3];
				if(index.equals("x")||index.equals("y")||index.equals("z"))
					c.c_display_cross_section(num,index, name);
				else
					c.display_message("you should choose x or y or z\n");

			}else
			{
				c.display_message("Wrong input");
			}
		}catch(NumberFormatException  e){
			c.display_message("Wrong input- you should send a number of the index\n");


		}
	}
}
