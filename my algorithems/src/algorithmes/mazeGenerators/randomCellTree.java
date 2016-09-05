
package algorithmes.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class randomCellTree is for pop from arrayList randomly.
 */
public class randomCellTree extends GrowingTreeGenerator {

	/* (non-Javadoc)
	 * @see algorithmes.mazeGenerators.MyMaze3dGenerator#pop1(java.util.ArrayList)
	 */
	@Override
	public Position pop1 (ArrayList<Position> arr){
		Random rand=new Random();
		int rnd=0;
			rnd=rand.nextInt(arr.size());
	return arr.get(rnd);
	}

}
