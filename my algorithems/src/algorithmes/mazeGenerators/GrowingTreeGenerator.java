package algorithmes.mazeGenerators;

import java.util.ArrayList;
import java.util.Collections;


//package algorithmes.mazeGenerators;

//import java.util.ArrayList;
//import java.util.Collections;


// TODO: Auto-generated Javadoc
/**
 * The Class GrowingTreeGenerator-this class is algorithm for creating a maze3d
 */
public abstract class GrowingTreeGenerator extends MyMaze3dGenerator {
	
	/** The maze. */
	Maze3d maze;
	
	/** The visit. */
	Maze3d visit;



	/* (non-Javadoc)
	 * @see algorithmes.mazeGenerators.Generator#generate(algorithmes.mazeGenerators.Position)
	 */
	//this is the function that creating the maze3d according to the algorithm.
	@Override
	public Maze3d generate(Position p1) {
		int check=0;
		Position newp1=new Position(p1.getX()*2+1, p1.getY()*2+1, p1.getZ()*2+1);
		Maze3d maze=new Maze3d(newp1);
		maze.initMaze();
		maze.createStart();
		Position start=maze.getStartPosition();
		maze.setStart(start);
		maze.createGoal();
		Position goal=maze.getGoalPosition();
	
		ArrayList<Position> c =new ArrayList<Position>();
		c.add(start);
		maze.setCell(start.getX(),start.getY(),start.getZ(),0);
		Position x=new Position(maze.getStartPosition());
		do {
			x=new Position (pop1(c));
			Integer [] rnd= RandomDirections();
			boolean breakLoop = false;

			for (int i = 0; i < rnd.length; i++){
				if(breakLoop==true)
					break;

				check=0;
				switch(rnd[i]){
				case 1:
			
					if(x.getX()==newp1.getX()-1) continue;
					if(x.getX()==0)continue;
					if(x.getZ()==0||x.getZ()==newp1.getZ()-1) continue;
					if(x.getY()-2>=0&&((maze.getCell(x.getX(),x.getY()-2,x.getZ())==1))){
						maze.setCell(x.getX(),x.getY()-2,x.getZ(),0);
						maze.setCell(x.getX(),x.getY()-1,x.getZ(),0);
						x=new Position(x.getX(),x.getY()-2,x.getZ());
						c.add(x);
						check++;
						breakLoop=true;
					}

					break;
				case 2:
					
					if(x.getX()==newp1.getX()-1) continue;
					if(x.getX()==0)continue;
					if(x.getZ()-2==0) continue;
					if(x.getZ()-2>=0&&((maze.getCell(x.getX(),x.getY(),x.getZ()-2)==1))){
						maze.setCell(x.getX(),x.getY(),x.getZ()-2,0);
						maze.setCell(x.getX(),x.getY(),x.getZ()-1,0);
						x=new Position(x.getX(),x.getY(),x.getZ()-2);
						c.add(x);
						check++;
						breakLoop=true;
					}

					break;
				case 3:

					if(x.getX()==newp1.getX()-1||x.getX()-2==0) continue;
					if(x.getZ()==0||x.getZ()==newp1.getZ()-1) continue;
					if(x.getX()-2>=0&&((maze.getCell(x.getX()-2,x.getY(),x.getZ())==1))){
						maze.setCell(x.getX()-1,x.getY(),x.getZ(),0);
						maze.setCell(x.getX()-2,x.getY(),x.getZ(),0);
						x=new Position(x.getX()-2,x.getY(),x.getZ());
						c.add(x);
						check++;
						breakLoop=true;
					}

					break;
				case 4:
					
					if(x.getX()==newp1.getX()-1) continue;
					if(x.getX()==0)continue;
					if(x.getZ()==0||x.getZ()==newp1.getZ()-1) continue;
					if(x.getY()+2<=maze.getP().getY()&&((maze.getCell(x.getX(),x.getY()+2,x.getZ())==1))){
						maze.setCell(x.getX(),x.getY()+2,x.getZ(),0);
						maze.setCell(x.getX(),x.getY()+1,x.getZ(),0);
						x=new Position(x.getX(),x.getY()+2,x.getZ());
						c.add(x);
						check++;
						breakLoop=true;
					}

					break;

				case 5:

					if(x.getX()==newp1.getX()-1) continue;
					if(x.getX()==0||x.getX()==newp1.getX())continue;
					if(x.getZ()+2==newp1.getZ()-1) continue;
					if(x.getZ()+2<=maze.getP().getZ()&&((maze.getCell(x.getX(),x.getY(),x.getZ()+2)==1))){
						maze.setCell(x.getX(),x.getY(),x.getZ()+1,0);
						maze.setCell(x.getX(),x.getY(),x.getZ()+2,0);
						x=new Position(x.getX(),x.getY(),x.getZ()+2);
						c.add(x);
						check++;
						breakLoop=true;
					}


					break;
				case 6:
				if(x.getX()==newp1.getX()-1) continue;

					if(x.getZ()==0||x.getZ()==newp1.getZ()-1) continue;
					Position g=new Position(x);
					g.setX(x.getX()+2);
					if((x.getX()+2==newp1.getX()-1)&&!(g.equals(goal))) continue;
					if(x.getX()+2<=maze.getP().getX()&&((maze.getCell(x.getX()+2,x.getY(),x.getZ())==1))){
						maze.setCell(x.getX()+1,x.getY(),x.getZ(),0);
						maze.setCell(x.getX()+2,x.getY(),x.getZ(),0);
						x=new Position(x.getX()+2,x.getY(),x.getZ());
						c.add(x);
						check++;
						breakLoop=true;
					}

					break;


				default:

					break;

				}

			}

			if(check==0)
				c.remove(c.indexOf(x));

		}while(!c.isEmpty());

		return maze;
	}


	/**
	 * Prints the simple maze.
	 */
	public void printSimpleMaze(){
		maze.printMaze3d();
	}

	/**
	 * Random directions.
	 *
	 * @return the integer[]
	 */
	public Integer[] RandomDirections() {//This is a function that random a number between 1-7, and put it on array.
		ArrayList<Integer> randoms = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++)
			randoms.add(i + 1);
		Collections.shuffle(randoms);

		return randoms.toArray(new Integer[6]);
	}
}
