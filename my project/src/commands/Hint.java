package commands;

import java.io.IOException;

import model.Model;
import presenter.Command;
import view.View;

public class Hint implements Command{
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
@Override
public void doCommand(String command) throws IOException {
	if(command.equals("hint"))
		m.m_hint();
	else{
		v.display_message("Wrong command\n");
	}
}

}
