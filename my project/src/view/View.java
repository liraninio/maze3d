package view;

import java.util.HashMap;

import algorithmes.mazeGenerators.Maze3d;
import presenter.Command;

// TODO: Auto-generated Javadoc
/**
 * The Interface View- this class is for the controller/
 * the controller use this functions when needs.
 */
public interface View {

/**
 * V start.
 */
public void v_start();

/**
 * Display message.
 *
 * @param string the string
 */
public void display_message(String string);

/**
 * V send commands.
 *
 * @param commands the commands
 */
public void v_send_commands(HashMap<String, Command>commands);

/**
 * V display.
 *
 * @param maze the maze
 */
public void v_display(String maze);

/**
 * V dir.
 *
 * @param path the path
 */
public void v_dir(String path);
public void setCommand(HashMap<String,Command> commands);
}
