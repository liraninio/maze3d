package presenter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import commands.Dir;
import commands.Display;
import commands.Display_cross_section;
import commands.Display_solution;
import commands.Exit;
import commands.Generate_maze;
import commands.Load_maze;
import commands.Save_maze;
import commands.Solve;
import model.Model;
import view.View;

public class Presenter implements Observer {
private View v;
private  Model m;
private HashMap<String,Command>commands;

public Presenter(View v, Model m){
	this.v=v;
	this.m=m;
	this.commands=new HashMap<String,Command>();
	commands.put("generate_maze", new Generate_maze(this.m,this.v));
	v.setCommand(commands);
	
	createCommands();
	v.setCommand(commands);
	
}
	@Override
	public void update(Observable o, Object command) {
		if (o==v){
			String input=((String)command);
			String [] com=null;
			com=input.split(" ");
			if(commands.containsKey(com[0])){
			try {
				commands.get(com[0]).doCommand(input);
			} catch (IOException e) {
				v.display_message("This is not type of String\n");
				e.printStackTrace();
			}
			}else{
				v.display_message("This command is not exist");
			}
			
		}
		if(o==m){
			String input=((String)command);
			v.display_message(input);
		}
		
	}
	public void createCommands(){
		//HashMap<String,Command>temp= new HashMap<String,Command>();
//		HashMap<String,Command> commands=new HashMap<String,Command>();
		this.commands=new HashMap<String,Command>();
		this.commands.put("generate_maze",new Generate_maze(m,v));
		this.commands.put("display",new Display(m,v));
		this.commands.put("display_cross_section",new Display_cross_section(m,v));
		this.commands.put("save_maze",new Save_maze(m,v));
		this.commands.put("load_maze",new Load_maze(m,v));
		this.commands.put("dir",new Dir(m,v));
		this.commands.put("solve_maze",new Solve(m,v));
		this.commands.put("display_solution",new Display_solution(m,v));
		this.commands.put("exit",new Exit(m,v));
		
	}

}