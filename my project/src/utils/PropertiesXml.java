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
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream("resources/properties.xml"));
		properties.setGenerateAlg("randomCell");
		properties.setSolveAlg("BFS");
		properties.setNumOfThreads(5);
		properties.setUi("gui");
		encoder.writeObject(properties);
		encoder.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void readXml(){
XMLDecoder decoder;
decoder= new XMLDecoder(PropertiesXml.class.getClassLoader().getResourceAsStream("resources/properties.xml"));
properties=(Properties) (decoder.readObject());
decoder.close();


}
public static Properties getProperties(){
	return properties;
}
}
