package commands;

import java.io.IOException;

import algorithmes.mazeGenerators.Maze3d;
import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Solve- is for solving the maze3d by the algorithm the user asked for (DFS/BFS).
 */
public class Solve implements Command{

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
 * Instantiates a new solve.
 *
 * @param c the c
 */
public Solve(Model m,View v){
	this.m=m;
	this.v=v;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		String[] temp=command.split(" ");
		if(temp.length==3)
		{
			Maze3d ma=m.mazeByName(temp[1]);
			if(m.isSolutionExist(ma))
				v.display_message("The maze "+temp[1]+" is ready\n");
			else
			m.m_solve(temp[1],temp[2]);
		}else
			v.display_message("Wrong input, please try again\n");
	}

}
