
package algorithmes.search;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DFS-DFS One starts at the root 
 * (selecting some arbitrary node as the root in the case of a graph) 
 * and explores as far as possible along each branch before backtracking.
 *
 * @param <T> the generic type
 */
public class DFS<T> extends CommonSearcher<T>{
	
	/** The solution. */
	private Solution<T> solution;
	
	/** The visit. */
	private ArrayList<State<T>> visit=new ArrayList<State<T>>();
	
	/** The counter. */
	private int counter=0;
	
	/* (non-Javadoc)
	 * @see algorithmes.search.CommonSearcher#search(algorithmes.search.Searchable)
	 */
	@Override

	public Solution<T> search(Searchable<T> s) {
		dfs(s,s.getInitialState());
		return solution;

	}
	
	/**
	 * Recursive Dfs.
	 *
	 * @param s the s
	 * @param state the state
	 */
	public void dfs(Searchable<T>s,State<T>state){
		if (state.equals(s.getGoalState())){
			solution=backTrace(state,s.getInitialState());
			setEvaluatedNodes(counter);
			return;
		}


		visit.add(state);
		ArrayList<State<T>>successors=s.getAllPossibleStates(state);
		for(State<T> successor:successors){
			counter++;
			if(!visit.contains(successor)){

				successor.setCameFrom(state);
				dfs(s,successor);
			}
		}
		return;


	}

}
