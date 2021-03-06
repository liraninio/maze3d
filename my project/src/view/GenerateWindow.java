package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

public class GenerateWindow extends DialogWindow {

	private MyView view;

	public GenerateWindow(MyView view) {
		this.view=view;
	}

	@Override
	protected void initWidgets() {
		shell.setText("Generate maze window");
		shell.setSize(350, 250);	//350 250 	

		shell.setLayout(new GridLayout(2, false));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/generate.jpg")));

		Label lblName = new Label(shell, SWT.NONE);
		lblName.setText("Maze name: ");

		Text txtName = new Text(shell, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label lblFloors = new Label(shell, SWT.NONE);
		lblFloors.setText("Floors: ");

		Text txtFloors = new Text(shell, SWT.BORDER);
		txtFloors.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label lblRows = new Label(shell, SWT.NONE);
		lblRows.setText("Rows: ");

		Text txtRows = new Text(shell, SWT.BORDER);
		txtRows.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label lblColumns = new Label(shell, SWT.NONE);
		lblColumns.setText("Columns: ");

		Text txtColumns = new Text(shell, SWT.BORDER);
		txtColumns.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label lblAlgorithm = new Label(shell, SWT.NONE);
		lblAlgorithm.setText("Algorithm (optional-loastCell/random_cell): ");

		Text txtAlgorithm = new Text(shell, SWT.BORDER);
		txtAlgorithm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));



		Button btnGenerateMaze = new Button(shell, SWT.PUSH);
		shell.setDefaultButton(btnGenerateMaze);
		btnGenerateMaze.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
		btnGenerateMaze.setText("Generate maze!");

		btnGenerateMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {				
				MessageBox msg = new MessageBox(shell, SWT.OK);
				msg.setText("Generating...");
				try{
				String name=txtName.getText();
				
				int floors=Integer.parseInt(txtFloors.getText());
				int rows = Integer.parseInt(txtRows.getText());
				int cols = Integer.parseInt(txtColumns.getText());
				
				String algorithm=txtAlgorithm.getText();
				
					
				if(algorithm==null){
					msg.setMessage("Generating maze "+name+ " with "+floors+" floors "+rows+" rows and "+cols+" columns");
					msg.open();
					String s="generate_maze "+name+" "+floors+" "+rows+" "+cols;
					view.executeCommand(s);	
				}
				
				else{
					msg.setMessage("Generating maze "+name+ " with "+floors+" floors, "+rows+" rows and "+cols+" columns with "+algorithm+" algorithm");
					msg.open();
					String s="generate_maze "+name+" "+floors+" "+rows+" "+cols+" "+algorithm;			
					view.executeCommand(s);	
				}
				}
				catch(NumberFormatException e){
					view.display_message("Wrong Input");
				}
				shell.close();
			}
			

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {			

			}
		});	

	}

}
