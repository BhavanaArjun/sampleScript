package qaframework.lib.UserDefinedFunctions;

import java.io.File;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;



public class ReadDataFromXMLfile {
	
	
		 
		 public String read(String tagName, String filePath) throws Exception {
		  String tagValue = "";
		  try {
		  String fXmlFile = getFilePath(filePath);
		  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		  Document doc = dBuilder.parse(fXmlFile);
		  doc.getDocumentElement().normalize();
		  tagValue = doc.getElementsByTagName(tagName).item(0)
		    .getTextContent();
		  } 
		  catch (Exception e) {
		   
		  }
		  return tagValue;
		 }
		 
		 public String getFilePath(String strPath) throws Exception {
		  PathsProperties objAP = new PathsProperties();
		  Properties pathProps = objAP.Read_FilePath();
		  String FILE_PATH = pathProps.getProperty(strPath);
		  String[] fileName = FILE_PATH.split("/");
		  File file = new File(fileName[fileName.length - 1]);
		  String path = file.getAbsolutePath();
		  FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		  return FILE_PATH;
		 }

}