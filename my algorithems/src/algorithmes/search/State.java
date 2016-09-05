
package algorithmes.search;

// TODO: Auto-generated Javadoc
/**
 * The Class State- is defining the architecture 
 * that the searchable classes should 
 * support on.
 *
 * @param <T> the generic type
 */
public class State<T> implements Comparable <State <T>> {
	
	/** The state. */
	private T state;
	
	/** The came from. */
	private State<T> cameFrom;
	
	/** The cost. */
	private double cost;
	
	/** The visited. */
	private boolean visited;
	
	/**
	 * Instantiates a new state.
	 *
	 * @param temp the temp
	 */
	public State(T temp) {
		this.cost=0;
		this.state=temp;
	}




	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public T getState() {
		return state;
	}




	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(T state) {
		this.state = state;
		this.visited=false;
	}




	/**
	 * Gets the came from.
	 *
	 * @return the came from
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}




	/**
	 * Sets the came from.
	 *
	 * @param cameFrom the new came from
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom =cameFrom;
	}




	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}




	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}




	/**
	 * Checks if is visited.
	 *
	 * @return true, if is visited
	 */
	public boolean isVisited() {
		return visited;
	}




	/**
	 * Sets the visited.
	 *
	 * @param visited the new visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(State<T> arg0) {
		return(int)(this.cost-arg0.cost);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object arg0) {

	//	State<T>temp=(State<T>)arg0;
	//	return this.state.equals(temp);
		if(!(arg0 instanceof State<?>))
			return false;
		if(arg0==this)
			return true;
		return this.state.equals(((State<T>) arg0).state);
	}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Node: "+ this.state;
}

}
