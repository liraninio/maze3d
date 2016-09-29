package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import model.MyModel;
import presenter.Command;
import presenter.Presenter;
import utils.PropertiesXml;
import view.MyView;

public class Run {
//
	public static void main(String[] args) {
		//PropertiesXml.writeToXml();
		PropertiesXml.readXml();
	MyModel model= new MyModel();
	MyView view= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));
	Presenter p=new Presenter(view,model);
	model.addObserver(p);
	view.addObserver(p);
	view.v_start();
	

	}

}
