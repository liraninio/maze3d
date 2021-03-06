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

public class LoadWindow extends DialogWindow {
private MyView view;
	
	

	public LoadWindow(MyView view2) {
		this.view=view2;
	}

	@Override
	protected void initWidgets() {
		shell.setText("Load maze window");
		shell.setSize(350, 125);	
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(new Image(null,getClass().getClassLoader().getResourceAsStream("resources/images/generate.jpg")));
				
		shell.setLayout(new GridLayout(2, false));
		Label file = new Label(shell, SWT.NONE);
		file.setText("Load from file name: ");
		
		Text txtName = new Text(shell, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label mazeName = new Label(shell, SWT.NONE);
		mazeName.setText("The maze name :");
		
		Text txtFileName = new Text(shell, SWT.BORDER);
		txtFileName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Button load = new Button(shell, SWT.PUSH);
		shell.setDefaultButton(load);
		load.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
		load.setText("Load maze");
		load.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox msg = new MessageBox(shell, SWT.OK);
				msg.setText("Loading...");
				String n=txtFileName.getText();
				String f=txtName.getText();	
				msg.setMessage("Loading: "+n+" as: "+f);
				String s="load_maze "+f+" "+n;
				view.executeCommand(s);
				shell.close();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
