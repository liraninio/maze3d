package view;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithmes.mazeGenerators.Maze3d;
import algorithmes.mazeGenerators.Position;

public class MazeDisplay extends Canvas {
		
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

		public MazeDisplay(Composite parent, int style,MyView view) {
			super(parent, style);
			Position p=new Position(0,0,0);
			init=false;
			maze=new Maze3d(p);
			character = new Character();
			character.setPos(new Position(-1, -1, -1));
			wall = new Image(null,"images/wall.jpg");
			up= new Image(null,"images/up.png");
			down= new Image(null,"images/down.png");
			upDown= new Image(null,"images/upDown.jpg");
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
							break;
						}
					view.executeCommand(command);
					redraw();
					}
			//	}
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
							if(init){
								if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Up")&& Arrays.asList(maze.getPossibleMoves(temp)).contains("Down"))
									e.gc.drawImage(upDown, 0, 0, upDown.getBounds().width, upDown.getBounds().height, x, y, cellWidth, cellHeight);
								else{
									if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Up"))
											e.gc.drawImage(up, 0, 0, up.getBounds().width, up.getBounds().height, x, y, cellWidth, cellHeight);
									if(Arrays.asList(maze.getPossibleMoves(temp)).contains("Down"))
										e.gc.drawImage(down, 0, 0, down.getBounds().width, down.getBounds().height, x, y, cellWidth, cellHeight);
								}
							}
						}
					}
					character.draw(cellWidth, cellHeight, e.gc);
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
