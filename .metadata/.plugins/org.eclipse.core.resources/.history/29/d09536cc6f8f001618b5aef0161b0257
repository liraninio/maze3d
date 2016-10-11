package view;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithmes.mazeGenerators.Maze3d;
import algorithmes.mazeGenerators.Position;

public class MazeDisplay extends Canvas {
	private Image hintt;
	private Maze3d maze;
	private String mazeName;
	private Character character;
	private int[][] crossSection = {{0},{0}};
	private Image wall;
	private Position goalPosition;
	private Position hintPosition;
	private boolean finish;
	private boolean hint;
	private Image up;
	private Image down;
	private Image upDown;
	private boolean init;
	private Image characterUp;
	private boolean upchar=true;
	private Image characterDown;
	private Image ste;
	private Image characterUpDown;
	private Image goal;
	private Image beforeGoal;
	private Image temp;
	private Image win;
	public MazeDisplay(Composite parent, int style,MyView view) {
		super(parent, style);
		Position p=new Position(0,0,0);
		init=false;
		maze=new Maze3d(p);
		character = new Character();
		character.setPos(new Position(-1, -1, -1));
		wall = new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/wall.jpg"));
		hintt = new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/hint.png"));
		win=new Image(null, getClass().getClassLoader().getResourceAsStream("resources/images/win.jpg"));
		up= new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/up.png"));
		down= new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/down.png"));
		upDown= new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/upDown.jpg"));
		characterUp=new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/charcterUp.jpg"));
		characterDown=new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/charcterDown.jpg"));
		goal=new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/goal.jpg"));
		//characterDown=new Image(null,"images/characterUpDown.png");
		characterUpDown=new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/characterUpDown.jpg"));
		temp=new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/temp.png"));
		ste=new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/character.jpg"));
		beforeGoal=new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/beforeGoal.jpg"));
		finish=false;

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				String command = null;
				//	if(maze.equals(null)){
				switch (e.keyCode) {
				case SWT.ARROW_RIGHT:
					command="moveRight";
					break;

				case SWT.ARROW_LEFT:	
					command="moveLeft";
					break;

				case SWT.ARROW_UP:			
					command="moveBackWard";
					break;

				case SWT.ARROW_DOWN:			
					command="moveForward";
					break;

				case SWT.PAGE_UP:		
					command="moveUp";
					break;
				case SWT.PAGE_DOWN:		
					command="moveDown";
					break;
				default: 
					return;
				}
				view.executeCommand(command);
				if(command.equals("moveUp")||command.equals("moveDown"))
					redraw();

			}
			//	}
		});
		this.addMouseWheelListener(new MouseWheelListener() {

		    @Override
		    public void mouseScrolled(MouseEvent g) {
		        if((g.stateMask & SWT.CONTROL) == SWT.CONTROL) {
		        	if (g.count > 0)
		        		setSize(getSize().x+50, getSize().y+50);
		        	if (g.count < 0)
		        		setSize(getSize().x-50, getSize().y-50);
		        }
				redraw();
		    }
		});

		this.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				e.gc.setForeground(new Color(null,200,100,0));
				e.gc.setBackground(new Color(null,0,0,0));

				int x,y;

				int width=getSize().x;
				int height=getSize().y;
				int cellWidth=width / crossSection[0].length;
				int cellHeight= height / crossSection.length;

				for (int i = 0; i < crossSection.length; i++) {
					for (int j = 0; j < crossSection[i].length; j++) {
						x = j * cellWidth;
						y = i * cellHeight;
						if (crossSection[i][j] != 0)
							e.gc.drawImage(wall, 0, 0, wall.getBounds().width, wall.getBounds().height, x, y, cellWidth, cellHeight);
						//							Position temp=new Position(character.getPos().getX(),i,j-1);
						//							if(init){
						//								if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Up")&& Arrays.asList(maze.getPossibleMoves(temp)).contains("Down"))
						//									e.gc.drawImage(upDown, 0, 0, upDown.getBounds().width, upDown.getBounds().height, x, y, cellWidth, cellHeight);
						//							}
					}
				}
				for (int i = 0; i < crossSection.length; i++) {
					for (int j = 0; j < crossSection[i].length-1; j++) {
						x = j * cellWidth;
						y = i * cellHeight;

						Position temp=new Position(character.getPos().getX(),i,j);
						Position beforeGoal1= new Position(maze.getGoalPosition().getX()-2,maze.getGoalPosition().getY(),maze.getGoalPosition().getZ());
						if(init){
							if(character.getPos().equals(maze.getGoalPosition())){
								e.gc.drawImage(win, 0, 0, win.getBounds().width, win.getBounds().height,1, 1, 1250, 500);
							}
							else{
							if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Up")&& Arrays.asList(maze.getPossibleMoves(temp)).contains("Down"))
								e.gc.drawImage(upDown, 0, 0, upDown.getBounds().width, upDown.getBounds().height, x, y, cellWidth, cellHeight);
							else{
								//if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Up")&&character.getPos().equals(temp))
								//	e.gc.drawImage(characterUp, 0, 0, characterUp.getBounds().width, characterUp.getBounds().height, x, y, cellWidth, cellHeight);
								//else
								if(temp.equals(beforeGoal1)){
									e.gc.drawImage(beforeGoal, 0, 0, beforeGoal.getBounds().width, beforeGoal.getBounds().height, x, y, cellWidth, cellHeight);

								}
								if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Up")&&!character.getPos().equals(temp)&&!temp.equals(beforeGoal1))
									e.gc.drawImage(up, 0, 0, up.getBounds().width, up.getBounds().height, x, y, cellWidth, cellHeight);
								if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Down"))
									e.gc.drawImage(down, 0, 0, down.getBounds().width, down.getBounds().height, x, y, cellWidth, cellHeight);
								if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Up")&&character.getPos().equals(temp)){
									e.gc.drawImage(characterUp, 0, 0, characterUp.getBounds().width, characterUp.getBounds().height, x, y, cellWidth, cellHeight);
									upchar=false;
								}
								if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Down")&&character.getPos().equals(temp)){
									e.gc.drawImage(characterDown, 0, 0, characterDown.getBounds().width, characterDown.getBounds().height, x, y, cellWidth, cellHeight);
									upchar=false;
								}
								if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Up")&& Arrays.asList(maze.getPossibleMoves(temp)).contains("Down")&&character.getPos().equals(temp)){
									e.gc.drawImage(characterUpDown, 0, 0, characterUpDown.getBounds().width, characterUpDown.getBounds().height, x, y, cellWidth, cellHeight);
									upchar=false;
								}	
								if(maze.getGoalPosition().equals(temp)){
									e.gc.drawImage(goal, 0, 0, goal.getBounds().width, goal.getBounds().height, x, y, cellWidth, cellHeight);
									upchar=false;
								}
								if(hint)
								if(character.getPos().equals(hintPosition)){
									e.gc.drawImage(hintt, 0, 0, hintt.getBounds().width, hintt.getBounds().height, x, y, cellWidth, cellHeight);
								}

							}
						}
					}
				}
				if(upchar)
					character.draw(cellWidth, cellHeight, e.gc);
				upchar=true;
			}
			}
		});
	}
	public void setCharacterPosition(Position p) {
		this.character.setPos(p);
		redrawObject();
	}


	public void setCrossSection(int [][] cs){
		this.crossSection=cs;
		redrawObject();
	}
	public void setHint(Position p){
		this.hintPosition=new Position(p.getX(),p.getY(),p.getZ());
		this.hint=true;
		redrawObject();

	}
	public void setGoalPosition(Position p) {
		this.goalPosition=p;
	}

	public void setMazeName(String name) {
		this.mazeName=name;
	}
	private void redrawObject() {
		getDisplay().syncExec(new Runnable() {

			@Override
			public void run() {
				setEnabled(true);
				redraw();
			}

		});
	}
	public void setMaze(Maze3d maze) {
		this.maze=maze;

	}
	public void setBool(){
		init=true;
	}
}
