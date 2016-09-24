package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

import algorithmes.mazeGenerators.Position;
import model.CurrentMaze;

public class MazeWindow extends BasicWindow {

	private MyView view;
	public MazeWindow(MyView view){
		this.view=view;
	}
private MazeDisplay mazeDisplay;
private CurrentMaze currentmaze;
	@Override
	protected
	void initWidgets() {
		GridLayout grid =new GridLayout(2,true);
		shell.setLayout(grid);
		Composite buttons = new Composite(shell, SWT.NONE);
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
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
		Button save=new Button(buttons,SWT.PUSH);
		//save.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		save.setText("Save");
		Button load=new Button(buttons,SWT.PUSH);
		//load.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		load.setText("Load");
		Button exit=new Button(buttons,SWT.PUSH);
		//exit.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		exit.setText("Exit");
		Button solve=new Button(buttons,SWT.PUSH);
		//solve.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		solve.setText("Solve");
		Button display=new Button(buttons,SWT.PUSH);
		//display.setLayoutData(new GridData(SWT.FILL,SWT.NONE, false, false, 1,1));
		display.setText("Display");
		
		mazeDisplay=new MazeDisplay(shell,SWT.BORDER,view);
		mazeDisplay.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		mazeDisplay.setFocus();
		
	}
	public void displayMessage(String temp){
		MessageBox msg= new MessageBox(shell,SWT.OK);
		msg.setMessage(temp);
		msg.open();
	}
	public void setCurrentPos(Position p){
		this.mazeDisplay.setCharacterPosition(p);
	}
	public CurrentMaze getCurrentmaze() {
		return currentmaze;
	}
	public void setNewCurrentmaze(CurrentMaze currentmaze) {
		this.currentmaze = currentmaze;
		this.mazeDisplay.setCharacterPosition(currentmaze.getCurrentMaze().getStartPosition());
		this.mazeDisplay.setMaze(currentmaze.getCurrentMaze());
		this.mazeDisplay.setCrossSection(currentmaze.getCurrentMaze().getCrossSectionByX(0));
		this.mazeDisplay.setGoalPosition(currentmaze.getCurrentMaze().getGoalPosition());
		this.mazeDisplay.setBool();
		
	}
	public void setPosCurrentmaze(CurrentMaze currentmaze){
		this.mazeDisplay.setCrossSection(currentmaze.getCurrentMaze().getCrossSectionByX(currentmaze.getCurrentPosition().getX()));
		this.mazeDisplay.setCharacterPosition(currentmaze.getCurrentPosition());
	}
	
}
