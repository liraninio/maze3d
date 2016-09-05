
package algorithmes.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * The Class Generator-This is an abstract class that realize the function meassureAlgorithmTime.
 */
public abstract class Generator implements Maze3dGenerator {
	
	/* (non-Javadoc)
	 * @see algorithmes.mazeGenerators.Maze3dGenerator#generate(algorithmes.mazeGenerators.Position)
	 */
	public abstract Maze3d generate(Position p);
	

	
	/* (non-Javadoc)
	 * @see algorithmes.mazeGenerators.Maze3dGenerator#measureAlgorithmTime(algorithmes.mazeGenerators.Position)
	 */
	//This function checking the time (at mill seconds) of creating a maze3d.
	public String measureAlgorithmTime(Position p){
		long s;
		long t;
		long sum;
	s=System.currentTimeMillis();
	generate(p);
	t=System.currentTimeMillis();
	sum=t-s;
	return String.valueOf(sum/1000);
		
	}
}
