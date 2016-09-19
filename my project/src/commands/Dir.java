package commands;

import java.io.IOException;


import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Dir- is for printing the user all the files under the directory we asked for.
 */
public class Dir implements Command {


private Model m;
private View v;

public Model getM() {
	return m;
}

public void setM(Model m) {
	this.m = m;
}

public View getV() {
	return v;
}

public void setV(View v) {
	this.v = v;
}

/**
 * Instantiates a new dir.
 *
 * @param c the c
 */
public Dir(Model m,View v){
	this.m=m;
	this.v=v;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		String [] temp=command.split(" ");
		if (temp.length==2){
			v.v_dir(temp[1]);
		}
		else{
			v.display_message("Wrong input\n");
		}
		
	}

}
