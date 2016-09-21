package algorithmes.mazeGenerators;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Position.
 */
public class Position implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6270031879184641305L;

	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The z. */
	private int z;
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * Gets the z.
	 *
	 * @return the z
	 */
	public int getZ() {
		return z;
	}
	
	/**
	 * Sets the z.
	 *
	 * @param z the new z
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * Instantiates a new position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public Position(int x,int y,int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "{" +x+ ","+ y + "," + z+ "}";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 *
	 */
	/**
	 * This function checks if one position equals to another position.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Position))
			throw new IllegalArgumentException("The object is not Position ");
		Position temp=(Position)obj;
		if ((temp.getX()==this.getX())&&(temp.getY()==this.getY())&&(temp.getZ()==this.getZ()))
			return true;
		return false;
	}
	
	/**
	 * Instantiates a new position.
	 *
	 * @param p1 the p 1
	 */
	Position(Position p1){
		this.x=p1.getX();
		this.y=p1.getY();
		this.z=p1.getZ();
	}
	
	/**
	 * Sets the position.
	 *
	 * @param p1 the new position
	 */
	public void setPosition(Position p1){
		this.x=p1.getX();
		this.y=p1.getY();
		this.z=p1.getZ();
	}
	
	/**
	 * Sets the position.
	 *
	 * @param x2 the x 2
	 * @param y2 the y 2
	 * @param z2 the z 2
	 */
	public void setPosition(int x2, int y2, int z2) {
		this.x=x2;
		this.y=y2;
		this.z=z2;

	}


}
