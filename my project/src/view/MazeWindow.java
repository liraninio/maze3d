package view;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;

import org.eclipse.swt.graphics.Image;

import algorithmes.mazeGenerators.Position;
import algorithmes.search.Solution;
import model.CurrentMaze;

public class MazeWindow extends BasicWindow {
	private int[][]crossSection;
private MazeDisplay mazeDisplay1;
	private MyView view;
	private TimerTask animation;
	private Timer timing;
	public MazeWindow(MyView view){
		this.view=view;
	}
	private String mazeName;
private MazeDisplay mazeDisplay;
private CurrentMaze currentmaze;
	@Override
	protected
	void initWidgets() {
		GridLayout grid =new GridLayout(2,false);
		shell.setLayout(grid);
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(new Image(null, "images/backround.png"));
		Composite buttons = new Composite(shell, SWT.FILL);//none
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		buttons.setLayout(rowLayout);
		Button generate=new Button(buttons,SWT.PUSH);
		//generate.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		generate.setText("Generate");
		generate.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateWindow win=new GenerateWindow(view);
				win.start(display);
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Button hint=new Button(buttons,SWT.PUSH);
		hint.setText("Hint");
		hint.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if(currentmaze.getName()==null){
					view.display_message("First generate a maze\n");
				}else{
					int floor=currentmaze.getCurrentMaze().getGoalPosition().getX();
					int currentFloor=currentmaze.getCurrentPosition().getX();
					if(floor-currentFloor>0){
						int tempfloor=floor/2-currentFloor/2;
						view.display_message("You have to go up more "+tempfloor+" floors");
					}
					else{
						int tempfloor=currentFloor/2-floor/2;
						view.display_message("You have to go down more "+tempfloor+" floors");
					}
					
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Button save=new Button(buttons,SWT.PUSH);
		//save.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		save.setText("Save");
	save.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				SaveWindow win = new SaveWindow(view);				
				win.start(display);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		Button load=new Button(buttons,SWT.PUSH);
		//load.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		load.setText("Load");
		load.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				LoadWindow win= new LoadWindow(view);
				win.start(display);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		shell.addListener(SWT.Close, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				view.executeCommand("exit");
				
			}
		});
		Button exit=new Button(buttons,SWT.PUSH);
		//exit.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		exit.setText("Exit");
		exit.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				view.executeCommand("exit");
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Button solve=new Button(buttons,SWT.PUSH);
		//solve.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		solve.setText("Solve");
		solve.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				SolveWindow sol=new SolveWindow(view,currentmaze.getName());
				sol.start(display);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		mazeDisplay1=new MazeDisplay(shell,SWT.BORDER,view);
		mazeDisplay1.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		mazeDisplay1.setFocus();
		
	}
	public void displayMessage(String temp){
		MessageBox msg= new MessageBox(shell,SWT.OK);
		msg.setMessage(temp);
		msg.open();
	}
	public void move(Position p){
		this.crossSection = this.currentmaze.getCurrentMaze().getCrossSectionByX(p.getX());
		this.mazeDisplay1.setCrossSection(this.crossSection);
		this.mazeDisplay1.setCharacterPosition(p);
		this.mazeDisplay1.setCharacterPosition(p);
//		if(p.equals(currentmaze.getCurrentMaze().getGoalPosition())){
//			MessageBox msg = new MessageBox(shell, SWT.OK);
//			msg.setText("Message");
//	     	msg.setMessage("You Won!!!");
//			msg.open();
//		}
			
	}
	public void solutionAnimation(Solution<Position> solution){
		animation = new TimerTask() {
			int i = 0;
			
			@Override
			public void run() {
				if (i < solution.getStates().size()-1)
					move(solution.getStates().get(i).getState());
				else {
					display.syncExec(new Runnable() {

						@Override
						public void run() {
							move(solution.getStates().get(i).getState());
						}
						
					});
					cancel();
			}
				i++;
			}
		};
		timing = new Timer();
		timing.scheduleAtFixedRate(animation, 0, 800);
	}
	public void setCurrentPos(Position p){
		this.mazeDisplay1.setCharacterPosition(p);
		
	}
	public CurrentMaze getCurrentmaze() {
		return currentmaze;
	}
	public void setNewCurrentmaze(CurrentMaze currentmaze) {
		this.mazeName=this.view.getMazeName();
		this.currentmaze = currentmaze;
		this.mazeDisplay1.setCharacterPosition(currentmaze.getCurrentMaze().getStartPosition());
		this.mazeDisplay1.setMaze(currentmaze.getCurrentMaze());
		this.mazeDisplay1.setCrossSection(currentmaze.getCurrentMaze().getCrossSectionByX(0));
		this.mazeDisplay1.setGoalPosition(currentmaze.getCurrentMaze().getGoalPosition());
		this.mazeDisplay1.setBool();
		
	}
	public void setPosCurrentmaze(CurrentMaze currentmaze){
		this.mazeDisplay1.setCrossSection(currentmaze.getCurrentMaze().getCrossSectionByX(currentmaze.getCurrentPosition().getX()));
		this.mazeDisplay1.setCharacterPosition(currentmaze.getCurrentPosition());
	}
	public void setMazeName(String name){
		this.mazeName=name;
	}
	
	
}
//package view;
//
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.layout.GridData;
//import org.eclipse.swt.layout.GridLayout;
//import org.eclipse.swt.widgets.Button;
//
//import haganaBk15.SnakesBoard;
//
//public class SnakeWindow extends BasicWindow{
//	//private View view;
//	private SnakesBoard s;
//	@Override
//	protected void initWidgets() {
//		shell.setLayout(new GridLayout(1, false));
//		s=new SnakesBoard(shell,SWT.FILL,30,30);
//		s.setLayoutData(new GridData(SWT.FILL,SWT.FILL, true,true,30,30));
//		Button run=new Button(shell,SWT.PUSH);
//		run.setText("RUN");
//		run.setLayoutData(new GridData(SWT.FILL,SWT.NONE,true, false, 30,1));
//	}
//
//}
