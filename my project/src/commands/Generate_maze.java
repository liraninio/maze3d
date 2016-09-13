package commands;

import controller.Command;
import controller.Controller;

public class Generate_maze implements Command {
public Controller c;

public Generate_maze(Controller c){
	this.c=c;
}
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
