package commands;

import java.io.IOException;

import controller.Command;
import controller.Controller;

public class Load_maze implements Command {
private Controller c;
public Load_maze(Controller c){
	this.c=c;
}
	@Override
	public void doCommand(String command) throws IOException {
		String []temp=command.split(" ");
		if(temp.length==3){
			c.c_load_maze(temp[1], temp[2]);
		}else
			c.display_message("Wrong input\n");
		
	}

}
