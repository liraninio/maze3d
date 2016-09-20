
package algorithmes.search;

import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Solution has the datamember
 * states that include the solution (the path 
 * from the start to the goal)
 *
 * @param <T> the generic type
 */
public class Solution<T> implements Serializable {
	private static final long serialVersionUID = 4146867362919689897L;
	
	/** The states. */
	ArrayList<State<T>> states;

	/**
	 * Gets the states.
	 *
	 * @return the states
	 */
	public ArrayList<State<T>> getStates() {
		return states;
	}

	/**
	 * Sets the states.
	 *
	 * @param states the new states
	 */
	public void setStates(ArrayList<State<T>> states) {
		this.states = states;
	}
	
	/**
	 * Instantiates a new solution.
	 *
	 * @param states the states
	 */
	public Solution(ArrayList<State<T>>states){
		this.states=states;
	}
	

}
