package presenter;

import java.io.Serializable;

public class Properties implements Serializable{

	/**
	 * This class is for default properties.
	 */
	private static final long serialVersionUID = 555913593004844041L;
private String generateAlg;
private String solveAlg;
private int numOfThreads;
private String ui;

public String getUi() {
	return ui;
}
public void setUi(String ui) {
	this.ui = ui;
}
public Properties(){
	this.generateAlg=null;
	this.solveAlg=null;
	this.numOfThreads=0;
}
public Properties(Properties prop){
	this.generateAlg=prop.generateAlg;
	this.solveAlg=prop.solveAlg;
	this.numOfThreads=prop.numOfThreads;
}
public String getGenerateAlg() {
	return generateAlg;
}
public void setGenerateAlg(String generateAlg) {
	this.generateAlg = generateAlg;
}
public String getSolveAlg() {
	return solveAlg;
}
public void setSolveAlg(String solveAlg) {
	this.solveAlg = solveAlg;
}
public int getNumOfThreads() {
	return numOfThreads;
}
public void setNumOfThreads(int numOfThreads) {
	this.numOfThreads = numOfThreads;
}
}
