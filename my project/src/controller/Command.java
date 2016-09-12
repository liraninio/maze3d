package controller;

import java.io.IOException;

public interface Command {
	public void doCommand(String command) throws IOException;
}
