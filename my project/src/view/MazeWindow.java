package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class MazeWindow extends BasicWindow {

	private MyView view;
	public MazeWindow(MyView view){
		this.view=view;
	}

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
		
		
		
		
	}

}
