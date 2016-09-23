package utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import presenter.Properties;

public class PropertiesXml {
private static Properties properties=new Properties();
public static void  writeToXml(){
	try {
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream("properties.xml"));
		properties.setGenerateAlg("lastCell");
		properties.setSolveAlg("DFS");
		properties.setNumOfThreads(5);
		encoder.writeObject(properties);
		encoder.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void readXml(){
XMLDecoder decoder;
try {
	decoder= new XMLDecoder(new FileInputStream("properties.xml"));
	properties=(Properties) (decoder.readObject());
	decoder.close();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}
public static Properties getProperties(){
	return properties;
}
}