
package algorithmes.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * The Interface Maze3dGenerator- This interface is to make a contract between the different algorithms.
 */
public interface Maze3dGenerator {
	
	/**
	 * Generate.
	 *
	 * @param p the p
	 * @return the maze 3 d
	 */
	public Maze3d generate(Position p);
	
	/**
	 * Measure algorithm time.
	 *
	 * @param p the p
	 * @return the string
	 */
	public String measureAlgorithmTime(Position p);
	

}
