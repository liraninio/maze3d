
package algorithmes.mazeGenerators;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class lastCellTree- is for pop from arrayList the last value that inserted.
 */
public class lastCellTree extends GrowingTreeGenerator {

	/* (non-Javadoc)
	 * @see algorithmes.mazeGenerators.MyMaze3dGenerator#pop1(java.util.ArrayList)
	 */
	@Override
	public Position pop1 (ArrayList<Position>arr){
		return arr.get(arr.size()-1);
		
	}

}
