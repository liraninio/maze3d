package commands;

import controller.Command;
import controller.Controller;

public class Display implements Command{
public Controller c;
public Display(Controller c){
	this.c=c;
}
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
