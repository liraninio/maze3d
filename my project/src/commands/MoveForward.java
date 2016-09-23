package commands;

import java.io.IOException;

import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class MoveForward.
 */
public class MoveForward implements Command{

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new move forward.
	 *
	 * @param m the m
	 * @param v the v
	 */
	public MoveForward(Model m,View v){
		this.m=m;
		this.v=v;
	}

	/**
	 * Gets the m.
	 *
	 * @return the m
	 */
	public Model getM() {
		return m;
	}

	/**
	 * Sets the m.
	 *
	 * @param m the new m
	 */
	public void setM(Model m) {
		this.m = m;
	}

	/**
	 * Gets the v.
	 *
	 * @return the v
	 */
	public View getV() {
		return v;
	}

	/**
	 * Sets the v.
	 *
	 * @param v the new v
	 */
	public void setV(View v) {
		this.v = v;
	}

	/* (non-Javadoc)
	 * @see presenter.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) throws IOException {
		String [] temp=command.split(" ");
		if(temp.length==1&&command.equals("moveForward")){
			m.m_moveForward();
		}else{
			v.display_message("Bad paramaters\n");
		}
		
	}
}
