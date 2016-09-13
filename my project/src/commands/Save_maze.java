package commands;

import controller.Command;
import controller.Controller;

public class Save_maze implements Command {
private Controller c;
public Save_maze(Controller c){
	this.c=c;
}
	@Override
	public void doCommand(String command) {
		String [] temp=command.split(" ");
		if(temp.length==3)
		c.c_save_maze(temp[1],temp[2]);
		else
			c.display_message("Wrong Input");
		
	}

}