package commands;


import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Generate_maze- is for generating a maze3d at the length the user asked
 * and by the algorithm the user asked.
 */
public class Generate_maze implements Command {

/** The c. */

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
 * Instantiates a new generate maze.
 *
 * @param c the c
 */
public Generate_maze(Model m,View v){
	this.m=m;
	this.v=v;
}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String [] temp=command.split(" ");
		if(temp.length==6||temp.length==5){
			int x,y,z;
			try{
			x=Integer.parseInt(temp[2]);
			y=Integer.parseInt(temp[3]);
			z=Integer.parseInt(temp[4]);
			if(temp.length==6)
			m.m_generate(temp[1], x, y, z,temp[5]);
			if(temp.length==5)
				m.m_generate(temp[1], x, y, z,null);
			}catch(NumberFormatException  e){
				v.display_message("Wrong input- you should send numbers of the length\n");
				
			}
		}else{
			this.v.display_message("Wrong Input- you should write the command,the length\n");
		
		}
		
	}

}
