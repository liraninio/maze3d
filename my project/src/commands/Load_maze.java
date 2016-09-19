package commands;

import java.io.IOException;


import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Load_maze- is for loading a maze3d by the file the user asked, and by the name of the maze.
 */
public class Load_maze implements Command {

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
 * Instantiates a new load maze.
 *
 * @param c the c
 */
public Load_maze(Model m,View v){
	this.m=m;
	this.v=v;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		String []temp=command.split(" ");
		if(temp.length==3){
			m.m_load_maze(temp[1], temp[2]);
		}else
			v.display_message("Wrong input\n");
		
	}

}
