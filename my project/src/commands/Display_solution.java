package commands;

import java.io.IOException;

import controller.Command;
import controller.Controller;

public class Display_solution implements Command{
private Controller c;
public Display_solution(Controller c){
	this.c=c;
}
	@Override
	public void doCommand(String command) throws IOException {
		String [] temp=command.split(" ");
		if(temp.length==2){
			c.c_display_solution(temp[1]);
		}else
			c.display_message("Wrong input\n");
		
	}

}
