package view;

import java.util.HashMap;

import algorithmes.mazeGenerators.Maze3d;
import controller.Command;

public interface View {
public void v_start();
public void display_message(String string);
public void v_send_commands(HashMap<String, Command>commands);
public void v_display(String maze);
public void v_dir(String path);
}
