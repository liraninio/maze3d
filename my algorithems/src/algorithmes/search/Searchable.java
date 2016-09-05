
package algorithmes.search;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Searchable is defining a classes that
 * will support on the search algorithms(DFS,BFS).
 *
 * @param <T> the generic type
 */
public interface Searchable <T> {
	
	/**
	 * Gets the initial state.
	 *
	 * @return the initial state
	 */
	public State<T> getInitialState();
	
	/**
	 * Gets the goal state.
	 *
	 * @return the goal state
	 */
	public State<T> getGoalState();
	
	/**
	 * Gets the all possible states.
	 *
	 * @param s the s
	 * @return the all possible states
	 */
	public ArrayList<State<T>> getAllPossibleStates(State<T> s);
	
	

}