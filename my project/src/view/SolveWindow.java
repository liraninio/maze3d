package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

public class SolveWindow extends DialogWindow {
private MyView view;
private String name;

public SolveWindow(MyView view,String name){
	this.view=view;
	this.name=name;
}
@Override
protected void initWidgets() {
	shell.setText("Solve maze window");
	shell.setSize(300, 170);
	shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
	shell.setBackgroundImage(new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/generate.jpg")));
	shell.setLayout(new GridLayout(2, false));
	Label lblAlgorithm = new Label(shell, SWT.NONE);
	lblAlgorithm.setText("Algorithm (optional): ");
	
	Composite buttons = new Composite(shell, SWT.NONE);
	buttons.setLayout(new GridLayout(1, false));
	
	Composite cmpSolve = new Composite(buttons, SWT.NONE);
	cmpSolve.setLayout(new GridLayout(1, false));
	cmpSolve.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 13));
	
	Combo cmbSolveAlgo = new Combo(cmpSolve, SWT.READ_ONLY | SWT.FILL);
	String algorithms[] = {"","BFS", "DFS"};
	cmbSolveAlgo.setItems(algorithms);
	cmbSolveAlgo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));	

	Button btnSolveMaze = new Button(shell, SWT.PUSH);
	shell.setDefaultButton(btnSolveMaze);
	btnSolveMaze.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
	btnSolveMaze.setText("Solve maze");
	btnSolveMaze.addSelectionListener(new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent arg0) {
			MessageBox msg = new MessageBox(shell, SWT.OK);
			msg.setText("Solving...");
			String alg=cmbSolveAlgo.getText();
			if(alg.isEmpty()){
				msg.setMessage("Solving the maze "+name);
				msg.open();
				String s="solve_maze "+name;
				view.executeCommand(s);
			}else{
//				MessageBox msg1 = new MessageBox(shell, SWT.OK);
//				msg.setText("Solving...");
//				String alg1=cmbSolveAlgo.getText();
				msg.setMessage("Solving the maze "+name);
				msg.open();
				String s="solve_maze "+name+" "+alg;
				view.executeCommand(s);
			}
			shell.close();
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
}
}
