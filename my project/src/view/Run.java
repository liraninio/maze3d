package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;

import model.MyModel;
import presenter.Presenter;
import utils.PropertiesXml;

//public class Run {
//
//	public static void main(String[] args) {
//		MazeWindow win=new MazeWindow("liran",1000, 400);
//win.run();
//	}
//
//}
public class Run {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		PropertiesXml.writeToXml();
		PropertiesXml.readXml();
		 MyView view=new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out, true));
		 MyModel model=new MyModel();
		Presenter p=new Presenter(view,model);
		view.addObserver(p);
		model.addObserver(p);
		view.v_start();
		//MazeWindow m=new MazeWindow(view);
		
		
//		GUI win = new GUI();
//		win.start();


	}

}