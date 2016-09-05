
package algorithmes.search;
import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * The Class BFS- BFS is an algorithm that  starts at the tree root 
 * (or some arbitrary node of a graph, sometimes referred to as a 'search key'[1])
 *  and explores the neighbor nodes first, before moving to the next level neighbors.
 *
 * @param <T> the generic type
 */
public class BFS<T> extends CommonSearcher<T>{

	/* (non-Javadoc)
	 * @see algorithmes.search.CommonSearcher#search(algorithmes.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {
		openList.add(s.getInitialState());
		ArrayList<State<T>> closedSet=new ArrayList<State<T>>();

		while(openList.size()>0){
			State<T> n=popOpenList();// dequeue
			closedSet.add(n);

			if(n.equals(s.getGoalState()))
				return backTrace(n, s.getInitialState()); 
			// private method, back traces through the parents

			ArrayList<State<T>> successors=s.getAllPossibleStates(n); //however it is implemented 
			for(State<T> state : successors){
				if(!closedSet.contains(state) && ! openListContains(state)){
					state.setCameFrom(n);
					state.setCost(n.getCost()+calCost(n,state));
					addToOpenList(state);
				} 
				else{
					if(n.getCost()+calCost(n, state)<state.getCost()){
						if(!(openListContains(state)))
							openList.add(state);
						else
						{
						openList.remove(state);
						openList.add(state);
						}
					}
				}
			}
		}
		return null;
	}


}