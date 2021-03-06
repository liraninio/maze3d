package model;

import algorithmes.mazeGenerators.Maze3d;
import algorithmes.mazeGenerators.Position;
import algorithmes.search.Solution;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrentMaze-
 * this class is for saving all the data of the played maze.
 */
public class CurrentMaze {

/** The current maze. */
private Maze3d currentMaze;

/** The current position. */
private Position currentPosition;

/** The current solution. */
private Solution<Position> currentSolution;
private Position hint;
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

/**
 * Instantiates a new current maze.
 */
public CurrentMaze() {
	this.currentMaze=null;
	this.currentPosition=null;
	this.currentSolution=null;
}

public Position getHint() {
	return hint;
}

public void setHint(Position hint) {
	this.hint = hint;
}

/**
 * Instantiates a new current maze.
 *
 * @param maze the maze
 */
public CurrentMaze(Maze3d maze){
	this.currentMaze=maze;
	this.currentPosition=maze.getStartPosition();
	this.currentSolution=null;
}
public CurrentMaze(CurrentMaze c){
	this.currentMaze=c.currentMaze;
	this.currentPosition=c.currentPosition;
	this.currentSolution=c.currentSolution;
}

/**
 * Gets the current maze.
 *
 * @return the current maze
 */
public Maze3d getCurrentMaze() {
	return currentMaze;
}

/**
 * Sets the current maze.
 *
 * @param currentMaze the new current maze
 */
public void setCurrentMaze(Maze3d currentMaze) {
	this.currentMaze = currentMaze;
}

/**
 * Gets the current position.
 *
 * @return the current position
 */
public Position getCurrentPosition() {
	return currentPosition;
}

/**
 * Sets the current position.
 *
 * @param currentPosition the new current position
 */
public void setCurrentPosition(Position currentPosition) {
	this.currentPosition = currentPosition;
}

/**
 * Gets the current solution.
 *
 * @return the current solution
 */
public Solution<Position> getCurrentSolution() {
	return currentSolution;
}

/**
 * Sets the current solution.
 *
 * @param currentSolution the new current solution
 */
public void setCurrentSolution(Solution<Position> currentSolution) {
	this.currentSolution = currentSolution;
}

}
