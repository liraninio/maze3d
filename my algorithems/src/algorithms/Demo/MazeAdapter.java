
package algorithms.Demo;

import java.util.ArrayList;

import algorithmes.mazeGenerators.Maze3d;
import algorithmes.mazeGenerators.Position;
import algorithmes.search.Searchable;
import algorithmes.search.State;


/**
 * The Class MazeAdapter-is class 
 * that supporting on searchable and
 * with all the functions of maze3d.
 */
public class MazeAdapter implements Searchable<Position> {
	
	/** The maze. */
	private Maze3d maze;
	
	/* (non-Javadoc)
	 * @see algorithmes.search.Searchable#getInitialState()
	 */
	//private ArrayList<State<Position>> sol;
	@Override
	public State<Position> getInitialState() {
		State<Position>temp=new State<Position>(maze.getStartPosition());
		return temp;
	}

	/* (non-Javadoc)
	 * @see algorithmes.search.Searchable#getGoalState()
	 */
	@Override
	public State<Position> getGoalState() {
		State<Position>temp=new State<Position>(maze.getGoalPosition());
		return temp;
	}
	
/**
 * Instantiates a new maze adapter.
 *
 * @param maze the maze
 */
public MazeAdapter(Maze3d maze){
	super();
	this.maze=maze;
}
	
	/* (non-Javadoc)
	 * @see algorithmes.search.Searchable#getAllPossibleStates(algorithmes.search.State)
	 */
/**
 * This function is getting a state of position
 * and returns the possible state we can pass.
 */
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		ArrayList<State<Position>> sol=new ArrayList<State<Position>>();
		Position p=new Position(s.getState().getX(),s.getState().getY(),s.getState().getZ());
		String[] arr=maze.getPossibleMoves(p);
		for(int i=0;i<arr.length;i++){
			switch(arr[i]){
			case "Up":
				Position up=new Position(p.getX()+2,p.getY(),p.getZ());
				State<Position> sup=new State<Position>(up);
				sol.add(sup);
				break;
			case "Down":
				Position down=new Position(p.getX()-2,p.getY(),p.getZ());
				State<Position> sdown=new State<Position>(down);
				sol.add(sdown);
			break;
			case "Forward":
				Position forw=new Position(p.getX(),p.getY()+1,p.getZ());
				State<Position> sfor=new State<Position>(forw);
				sol.add(sfor);
			break;
			case "Backward":
				Position back=new Position(p.getX(),p.getY()-1,p.getZ());
				State<Position> sback=new State<Position>(back);
				sol.add(sback);
			break;
			case "Right":
				Position right=new Position(p.getX(),p.getY(),p.getZ()+1);
				State<Position> sright=new State<Position>(right);
				sol.add(sright);
			break;
			case "Left":
				Position left=new Position(p.getX(),p.getY(),p.getZ()-1);
				State<Position> sleft=new State<Position>(left);
				sol.add(sleft);
			break;

		}

	}
	return sol;
}

}
