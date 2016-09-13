package commands;

import java.io.IOException;

import controller.Command;
import controller.Controller;

public class Exit implements Command {
private Controller c;
public Exit(Controller c){
	this.c=c;
}
	@Override
	public void doCommand(String command) throws IOException {
		c.c_exit();
		
	}

}
