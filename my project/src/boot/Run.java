package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.MyController;
import model.MyModel;
import view.CLI;
import view.MyView;

public class Run {
//
	public static void main(String[] args) {
//		MyModel myModel= new MyModel();
//		MyView myView= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out),new HashMap<String,Command>());
//		MyController myController= new MyController(myModel,myView);
//		
//		myModel.setC(myController);
//		myView.setC(myController);
//		myView.v_start();
//		myModel.m_generate("liran", 3, 3, 3);
	MyModel myModel= new MyModel();
	MyView myView= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out), new HashMap<String, Command>());
	MyController myController= new MyController(myModel,myView);
	myController.setView(myView);
	
	myModel.setC(myController);
	myView.setC(myController);
	//CLI cli=new CLI(myView.getIn(), myView.getOut(), myView.getCommands());
	//myView.setCli(cli);
	//CLI cli=new CLI(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out), new HashMap<String, Command>());
	myView.v_start();

	}

}
