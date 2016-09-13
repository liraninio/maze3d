package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI {
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String,Command> hash;
	
	public CLI(BufferedReader i, PrintWriter o){
		
		this.in=i;
		this.out=o;
		this.hash=new HashMap<String,Command>();
		
	}
	

	public CLI(BufferedReader in,PrintWriter out,HashMap<String,Command> hash) {
		this.in=in;
		this.out=out;
		this.hash=new HashMap<String,Command>(hash);
		
	}

//
//	public void start(){
//		Thread thread=new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				try{
//					out.println("Please enter the command");
//					out.flush();
//					String commandName=in.readLine();
//					Command command;
//					while(!commandName.equals("exit")){
//						command=hash.get(commandName.split(" ")[0]);
//						if(command!=null){
//							if(commandName.split(" ").length>1){
//								command.doCommand(commandName.substring(commandName.indexOf(' ')+1));
//							}else {
//								out.println("There is no parameter");
//								out.flush();
//							}
//
//						}else{
//							out.println("This commans is not Exist");
//							out.flush();
//						}
//						out.println("Please enter command");
//						commandName=in.readLine();
//						out.flush();
//					}
//					hash.get("exit").doCommand("");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			}
//		
//
//		});
//		thread.start();

	//}	
public void start(){
		//crate Thread
		new Thread(new Runnable() {

			@Override
			public void run() {
				try{
					//ask user for command.

					out.println("Please enter your command");
					out.flush();
					//get command
					String commandName=in.readLine();
					Command command=null;

					while(!commandName.equals("exit")){
						command= hash.get(commandName.split(" ")[0]);
						if(command!=null){
							if(commandName.split(" ").length>1){
								command.doCommand(commandName.substring(commandName.indexOf(' ') ));
							}else {
								out.println("InValid Parmeter\n");
								out.flush();
							}
						}else {
							out.println("this command is not exits\n");
							out.flush();
						}

						out.println("please enter a new command");
						out.flush();
						commandName = in.readLine();

					}
					hash.get("exit").doCommand("");


				}catch(Exception e){
					e.printStackTrace();
				}

}
		}).start();

	}


	public HashMap<String, Command> getHash() {
		return hash;
	}


	public void setHash(HashMap<String, Command> hash) {
		this.hash = hash;
	}
	
}
