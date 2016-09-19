package commands;



import model.Model;
import presenter.Command;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Display_cross_section-is for printing the user the maze2d by the index and the pivot we asked for.
 */
public class Display_cross_section implements Command {
	
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
	 * Instantiates a new display cross section.
	 *
	 * @param c the c
	 */
	public Display_cross_section(Model m,View v){
		this.m=m;
		this.v=v;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String [] temp=command.split(" ");
		try{
			if (temp.length==4){

				int num=Integer.parseInt(temp[1]);
				String index=temp[2];
				String name=temp[3];
				if(index.equals("x")||index.equals("y")||index.equals("z"))
					m.m_display_cross_section(num,index, name);
				else
					v.display_message("you should choose x or y or z\n");

			}else
			{
				v.display_message("Wrong input");
			}
		}catch(NumberFormatException  e){
			v.display_message("Wrong input- you should send a number of the index\n");


		}
	}
}
