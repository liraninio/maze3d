package presenter;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Command- is for the cli that
 * calls the function doCommand.
 */
public interface Command {
	
	/**
	 * Do command.
	 *
	 * @param command the command
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void doCommand(String command) throws IOException;
}
