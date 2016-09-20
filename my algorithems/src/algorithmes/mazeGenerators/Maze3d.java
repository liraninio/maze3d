 
package algorithmes.mazeGenerators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
// TODO: Auto-generated Javadoc

/**
 * The Class Maze3d- this class is defining a maze3d.
 */
public class Maze3d implements Serializable{
	private static final long serialVersionUID = 122377620547766818L;
	/** The p. */
	private Position p;
	
	/** The start. */
	private Position start;
	
	/** The goal. */
	private Position goal;
	
	/** The maze. */
	private int[][][] maze;
	
	/** The rand. */
	Random rand=new Random();


	/**
	 * Inits the maze-The default initialize is that all the positions at the maze is walls
	 */
	public void initMaze(){
		for(int i=0;i<p.getX();i++){
			for (int j=0;j<p.getY();j++){
				for(int k=0;k<p.getZ();k++){
					maze[i][j][k]=1;
				}
			}
		}
	}
	
	/**
	 * Instantiates a new maze 3 d-creating a maze3d by getting the limits(Position p).
	 *
	 * @param p1 the p 1
	 */
	public Maze3d(Position p1) {
		this.p=new Position(p1.getX(),p1.getY(),p1.getZ());
		this.maze=new int[p1.getX()][p1.getY()][p1.getZ()];
	}
	
	/**
	 * Wall-This Function is put a wall in any point we want
	 *
	 * @param p the p
	 */
	public void wall(Position p){
		maze[p.getX()][p.getY()][p.getZ()]=1;
	}
	
	/**
	 * Freewall-This Function is put a passage in any point we want.
	 *
	 * @param p the p
	 */
	public void Freewall(Position p){
		maze[p.getX()][p.getY()][p.getZ()]=0;
	}
	
	/**
	 * Gets the start position.
	 *
	 * @return the start position
	 */
	public Position getStartPosition(){
		return start;
	}
	
	/**
	 * Gets the goal position.
	 *
	 * @return the goal position
	 */
	public Position getGoalPosition(){
		return goal;	
	}
	
	/**
	 * Creates the positions randomly and puts a value at this Position.
	 *
	 * @param p1 the p 1
	 * @param a the a
	 * @return the position
	 */
	public Position createPositions(Position p1,int a){
	
				int temp1=(randomNumber(p1.getY()));
		int temp2=randomNumber(p1.getZ());
		Position p2=new Position (a,temp1,temp2);
		return p2;
		
	}
	
	/**
	 * Random number-This function is creating a random number at the range we sending.
	 *
	 * @param temp the temp
	 * @return the int
	 */
	public int randomNumber(int temp){
		Random rand=new Random();
		int rnd=0;
			rnd=rand.nextInt(temp);
	return rnd;
	}
	
	/**
	 * Gets the possible moves of Position we getting (if we can go to the position between the limits, and if there is no wall).
	 *
	 * @param p1 the p 1
	 * @return the possible moves
	 */
	public String [] getPossibleMoves(Position p1)
	{
		ArrayList<String> s=new ArrayList<String>();

		if(p1.getX()+1<this.p.getX()&&(maze[p1.getX()+1][p1.getY()][p1.getZ()]==0)){
			s.add("Up");

		}
		if(p1.getX()>0&&(maze[p1.getX()-1][p1.getY()][p1.getZ()]==0)){
			s.add("Down");

		}
		if(p1.getY()+1<this.p.getY()&&(maze[p1.getX()][p1.getY()+1][p1.getZ()]==0)){
			s.add("Forward");

		}
		if(p1.getY()>0&&(maze[p1.getX()][p1.getY()-1][p1.getZ()]==0)){
			s.add("BackWard");

		}
		if(p1.getZ()<this.p.getZ()&&(maze[p1.getX()][p1.getY()][p1.getZ()+1]==0)){
			s.add("Right");

		}
		if(p1.getZ()>0&&(maze[p1.getX()][p1.getY()][p1.getZ()-1]==0)){
			s.add("Left");

		}
		String [] tempS=new String[s.size()];
		s.toArray(tempS);
		return tempS;
	}
	
	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/**
	 * This is overriding toString is for printing the maze3d.
	 */
	@Override
	public String toString() {
		String s1 = new String();

		for (int i = 0; i < p.getX(); i++) {
			for (int j = 0; j < p.getY() ; j++) {
				for (int k = 0; k< p.getZ() ; k++) {
					s1 += maze[i][j][k]+ " ";
				}

				s1 += "\n";
			}

			s1 += "\n";
		}
		return s1;
	}


	/**
	 * Gets the cross section by X.
	 *
	 * @param n the n
	 * @return the cross section by X
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int [][] getCrossSectionByX(int n)throws IndexOutOfBoundsException{
		if(n<0||n>=maze.length)
			throw new IndexOutOfBoundsException("Out of bounds");
		else
		{
			int[][]arr=new int [maze[0].length][maze[0][0].length];
			for(int i=0;i<maze[0].length;i++)
			{
				for(int j=0;j<maze[0][0].length;j++)
				{
					arr[i][j]=maze[n][i][j];
				}
			}
			return arr;
		}
	}

	/**
	 * Gets the cross section by Y.
	 *
	 * @param n the n
	 * @return the cross section by Y
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int[][] getCrossSectionByY(int n) throws IndexOutOfBoundsException{
		if((n<0)||(n>=maze[0].length))
			throw new IndexOutOfBoundsException("Out of bounds");
		else
		{
			int[][]arr=new int[maze.length][maze[0][0].length];
			for(int i=0;i<maze.length;i++)
				for(int j=0;j<maze[0][0].length;j++)
					arr[i][j]=maze[i][n][j];
			return arr;
		}
	}

	/**
	 * Gets the cross section by Z.
	 *
	 * @param n the n
	 * @return the cross section by Z
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int[][] getCrossSectionByZ(int n) throws IndexOutOfBoundsException{
		if((n<0)||(n>=maze[0][0].length))
			throw new IndexOutOfBoundsException("Out of bounds");
		int[][]arr=new int[maze.length][maze[0].length];
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze[0].length;j++)
				arr[i][j]=maze[i][j][n];
		return arr;
	}
	
	/**
	 * Gets the p.
	 *
	 * @return the p
	 */
	public Position getP() {
		return p;
	}
	
	/**
	 * Sets the p.
	 *
	 * @param p the new p
	 */
	public void setP(Position p) {
		this.p = p;
	}
	
	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public Position getStart() {
		return start;
	}
	
	/**
	 * Sets the start.
	 *
	 * @param start the new start
	 */
	public void setStart(Position start) {
		this.start = start;
	}
	
	/**
	 * Gets the goal.
	 *
	 * @return the goal
	 */
	public Position getGoal() {
		return goal;
	}
	
	/**
	 * Sets the goal.
	 *
	 * @param goal the new goal
	 */
	public void setGoal(Position goal) {
     this.goal=goal;
		
		
	}
	
	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public int[][][] getMaze() {
		return maze;
	}
	
	/**
	 * Sets the maze.
	 *
	 * @param maze the new maze
	 */
	public void setMaze(int[][][] maze) {
		for(int i=0;i<p.getX();i++)
			for(int j=0;j<p.getY();j++)
				for(int k=0;k<p.getZ();k++)
					this.maze[i][j][k]=maze[i][j][k];
	}
	
	/**
	 * Prints the maze 3 d.
	 */
	public void printMaze3d(){
		for(int i=0;i<p.getX();i++){
			for (int j=0;j<p.getY();j++){
				for(int k=0;k<p.getZ();k++)
				{
					System.out.print(maze[i][j][k]+ " ");
				}
				System.out.println();
			}
			System.out.println();

		}
		
	}
	
	/**
	 * Creates the start Position.
	 */
	public void createStart(){
		
		int temp=0;
		do{
		temp=rand.nextInt(p.getZ()-2);
		}while(temp%2==0);
		start=new Position(0,0,temp+1);
	}
	
	/**
	 * Creates the limits.
	 */
	public void createLimits(){
		for (int i=0;i<p.getY();i++){
			for(int j=0;j<p.getZ();j++){
				maze[i][0][j]=1;
				maze[i][j][0]=1;
				maze[i][j][p.getZ()-1]=1;
				maze[i][p.getY()-1][j]=1;
				maze[0][i][j]=1;
				maze[1][i][j]=1;
				maze[p.getX()-2][i][j]=1;
				maze[p.getX()-1][i][j]=1;
			}
		}
	}
	
	/**
	 * Creates the goal Position.
	 */
	public void createGoal(){
		
		int temp=0;
		do{
		temp=rand.nextInt(p.getZ()-1);
		}while(temp%2!=0||temp==0);
		goal=new Position(p.getX()-1,p.getY()-1,temp);
	}
	
	/**
	 * Sets the cell as specific Position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param temp the temp
	 */
	public void setCell(int x,int y,int z,int temp){
		this.maze[x][y][z]=temp;
	}
	
	/**
	 * Gets the cell.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @return the cell
	 */
	public int getCell(int x,int y,int z){
		return maze[x][y][z];
	}
	

	
	/**
	 * Prints the 2 d maze.
	 *
	 * @param arr the arr
	 */
	public void print2dMaze(int [][] arr){
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j][i]+" ");
			}
			System.out.println();
		}
		
	}
	/**
	 * This function is compressing the maze to byte array.
	 *
	 * 
	 */
//	public byte[] toByteArray(){
//		byte[]arr=new byte[9+p.getX()*p.getY()*p.getZ()];
//		arr[0]=(byte)p.getX();
//		arr[1]=(byte)p.getY();
//		arr[2]=(byte)p.getZ();
//		arr[3]=(byte)start.getX();
//		arr[4]=(byte)start.getY();
//		arr[5]=(byte)start.getZ();
//		arr[6]=(byte)goal.getX();
//		arr[7]=(byte)goal.getY();
//		arr[8]=(byte)goal.getZ();
//		int r=9;
//		for (int i=0;i<p.getX();i++){
//			for (int j=0;j<p.getY();j++){
//				for(int k=0;k<p.getZ();k++){
//					arr[r]=(byte)maze[i][j][k];
//					r++;
//				}
//			}
//		}
//		return arr;
//		
//	}
	public byte[] toByteArray() {
		byte[] b = new byte[p.getX() * p.getY()* p.getZ() + 9];

		// maze dimensions
		b[0] = (byte) p.getX();
		b[1] = (byte) p.getY();
		b[2] = (byte) p.getZ();

		// start position
		b[3] = (byte) getStartPosition().getX();
		b[4] = (byte) getStartPosition().getY();
		b[5] = (byte) getStartPosition().getZ();

		// end position
		b[6] = (byte) getGoalPosition().getX();
		b[7] = (byte) getGoalPosition().getY();
		b[8] = (byte) getGoalPosition().getZ();

		// maze
		int i = 9;
		for (int x = 0; x < p.getX(); x++) {
			for (int y = 0; y < p.getY(); y++) {
				for (int z = 0; z < p.getZ(); z++) {
					b[i] = (byte) maze[x][y][z];
					i++;
				}
			}
		}
		return b;
	}
	/**
	 * This constructor is extract the maze from byte array.
	 */
//	public Maze3d(byte[]arr){
//		this.p=new Position(arr[0],arr[1],arr[2]);
//		this.start=new Position(arr[3],arr[4],arr[5]);
//		this.goal=new Position(arr[6],arr[7],arr[8]);
//		this.maze=new int[p.getX()][p.getY()][p.getZ()];
//		int num=9;
//		for(int j=0;j<this.p.getX();j++){
//			for(int k=0;k<this.p.getY();k++){
//				for(int l=0;l<this.p.getZ();l++){
//					
//					this.maze[j][k][l]=arr[num];
//					num++;
//				}
//			}
//		}
//	}
	public Maze3d(byte[] b){
		this.p=new Position(b[0],b[1],b[2]);
		this.maze=new int [p.getX()][p.getY()][p.getZ()];
		Position start=new Position(b[3],b[4],b[5]);
		Position goal=new Position(b[6],b[7],b[8]);
		int n=9;
		for (int i = 0; i < p.getX(); i++) {
			for (int j = 0; j < p.getY(); j++) {
				for (int k = 0; k < p.getZ(); k++) {
					
					this.maze[i][j][k]=b[n];
					n++;
				}
			}
		}
		
		setStart(start);
		setGoal(goal);
	

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goal == null) ? 0 : goal.hashCode());
		result = prime * result + Arrays.deepHashCode(maze);
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((rand == null) ? 0 : rand.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maze3d other = (Maze3d) obj;
		if (goal == null) {
			if (other.goal != null)
				return false;
		} else if (!goal.equals(other.goal))
			return false;
		if (!Arrays.deepEquals(maze, other.maze))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;

		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}


}
