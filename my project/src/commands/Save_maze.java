package commands;


import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Save_maze- is for saving the maze3d at the file that the user asked.
 */
public class Save_maze implements Command {


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
 * Instantiates a new save maze.
 *
 * @param c the c
 */
public Save_maze(Model m,View v){
	this.m=m;
	this.v=v;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String [] temp=command.split(" ");
		if(temp.length==3)
		m.m_save_maze(temp[1],temp[2]);
		else
			v.display_message("Wrong Input");
		
	}

}
