package commands;

import java.io.IOException;


import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Exit- is for close the program when the user ask,
 * and close the open threads and the open files.
 */
public class Exit implements Command {

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
 * Instantiates a new exit.
 *
 * @param c the c
 */
public Exit(Model m,View v){
	this.m=m;
	this.v=v;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		m.m_exit();
		
	}

}
