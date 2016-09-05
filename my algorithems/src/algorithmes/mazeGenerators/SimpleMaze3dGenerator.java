
package algorithmes.mazeGenerators;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleMaze3dGenerator- is creating a simple maze3d at the function generate.
 */
public class SimpleMaze3dGenerator extends Generator {
	
	/** The arr. */
	private Maze3d arr;
	
	/** The rnd. */
	Random rnd=new Random();

	/* (non-Javadoc)
	 * @see algorithmes.mazeGenerators.Generator#generate(algorithmes.mazeGenerators.Position)
	 */
	@Override
	public Maze3d generate(Position p1){
		Position newp1=new Position(p1.getX()*2+1, p1.getY()*2+1, p1.getZ()*2+1);
		Maze3d arr=new Maze3d(newp1);
		arr.createStart();
		arr.createGoal();
		arr.createLimits();
		createMaze(arr);
		return arr;
	}
	
	/**
	 * Creates the maze-every cell in the maze is choosing randomly except for the limits cells.
	 *
	 * @param maze the maze
	 */
	public void createMaze(Maze3d maze){
		int temp;
		for(int i=2;i<maze.getP().getX()-2;i++){
			for(int j=1;j<maze.getP().getY()-1;j++){
				for(int k=1;k<maze.getP().getZ()-1;k++){
					temp=rnd.nextInt(2);
					maze.setCell(i,j,k, temp);
				}
			}
		}
		if(maze.getStartPosition().getZ()<maze.getGoalPosition().getZ())
		{
		for(int i=maze.getStartPosition().getZ();i<maze.getGoalPosition().getZ()+1;i++){
				
					maze.setCell(2, 0, i, 0);
		}
		
			if(maze.getStartPosition().getZ()>maze.getGoalPosition().getZ()){
				for(int i=maze.getGoalPosition().getZ();i<maze.getStartPosition().getZ()+1;i++)
				{
					maze.setCell(2, 0, i, 0);
				}
			}
		}
		for(int i=2;i<maze.getGoalPosition().getX();i++)
		{
			for(int j=0;j<maze.getP().getY();j++)
			maze.setCell(i,j,maze.getGoalPosition().getZ(),0);
		}
		maze.setCell(maze.getStartPosition().getX(),maze.getStartPosition().getY(),maze.getStartPosition().getZ(),0);
		maze.setCell(maze.getStartPosition().getX()+1,maze.getStartPosition().getY(),maze.getStartPosition().getZ(),0);
		maze.setCell(maze.getGoalPosition().getX(),maze.getGoalPosition().getY(),maze.getGoalPosition().getZ(),0);
	}
	
	/**
	 * Prints the simple maze.
	 */
	public void printSimpleMaze(){
		arr.printMaze3d();
	}
	
	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public Maze3d getMaze(){
		return arr;
	}
	
	/**
	 * Sets the maze.
	 *
	 * @param maze the new maze
	 */
	public void setMaze(Maze3d maze){
		arr=maze;
		
	}
}

