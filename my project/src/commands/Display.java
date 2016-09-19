package commands;


import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Display-is for printing the maze3d for user.
 */
public class Display implements Command{

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
 * Instantiates a new display.
 *
 * @param c the c
 */
public Display(Model m,View v){
	this.m=m;
	this.v=v;
}

/* (non-Javadoc)
 * @see controller.Command#doCommand(java.lang.String)
 */
@Override
public void doCommand(String command) {
	String [] temp=command.split(" ");
	if (temp.length==2){
		String s=temp[1];
		m.m_display(s);
	}else
	{
		v.display_message("Wrong input");
	}
	
	
	
}

}
