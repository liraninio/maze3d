package algorithmes.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public abstract class CommonSearcher<T> implements Searcher<T> {

	 protected PriorityQueue<State<T>> openList;
	 private int evaluatedNodes;
	
public boolean openListContains(State<T>temp){
	if (openList.contains(temp)) return true;
	return false;
	
}
	 public CommonSearcher() {
	  openList=new PriorityQueue<State<T>>();
	  evaluatedNodes=0;
	 }

	 protected State<T> popOpenList() {
	  evaluatedNodes++;
	  return openList.poll();
	 }
	 @Override
	 public abstract Solution<T> search(Searchable<T> s);

	 @Override
	 public int getNumberOfNodesEvaluated() {
	  return evaluatedNodes;
	 }
	 public int getEvaluatedNodes() {
		return evaluatedNodes;
	}
	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}
	public Solution<T> backTrace(State<T>goal,State<T>start){
		 State <T>temp=goal;
		 ArrayList<State<T>>arr=new ArrayList<State<T>>();
		 while(temp.getCameFrom()!=null){
			 arr.add(temp);
			 temp=temp.getCameFrom(); 
		 }
		 arr.add(temp);
		 Collections.reverse(arr);
		 Solution<T> sol=new Solution<T>(arr);
		return sol;
		 
	 }
	 public ArrayList<State <T>> reverse(ArrayList<State<T>> list) {
		    for(int i = 0, j = list.size() - 1; i < j; i++) {
		        list.add(i, list.remove(j));
		    }
		    return list;
		}
	
		public void addToOpenList(State<T>temp){
			openList.add(temp);
		}
		public double calCost(State<T> temp1,State<T> temp2){
			return 1;
		}
	 

}