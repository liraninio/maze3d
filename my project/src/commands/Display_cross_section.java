package commands;

import controller.Command;
import controller.Controller;

public class Display_cross_section implements Command {
	private Controller c;
	public Display_cross_section(Controller c){
		this.c=c;
	}
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
