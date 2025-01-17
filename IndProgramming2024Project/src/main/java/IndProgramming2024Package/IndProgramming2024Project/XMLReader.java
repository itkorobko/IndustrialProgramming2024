package IndProgramming2024Package.IndProgramming2024Project;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLReader implements MyFileReader {
	private String filename;
	public void setFilename(String filename) {
		this.filename=filename;
	}
	public String readContent() throws Exception {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    @Override
	public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
    	String content = readContent();
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(inputStream);
		document.getDocumentElement().normalize();
		NodeList node_list_of_expressions = document.getElementsByTagName("expression");
		NodeList node_list_of_vars_and_values=document.getElementsByTagName("var_and_value");
		for (int i = 0; i < node_list_of_expressions.getLength(); i++) {
			//Element expression = (Element) node_list_of_expressions.item(i);
			lines_with_expression.add(node_list_of_expressions.item(i).getTextContent());
			
		}
		for(int i=0;i<node_list_of_vars_and_values.getLength();i++) {
			Element var_and_value=(Element)node_list_of_vars_and_values.item(i);
            String var = var_and_value.getElementsByTagName("var").item(0).getTextContent();
            String value = var_and_value.getElementsByTagName("value").item(0).getTextContent();
            vars_and_values.put(var, value);
		}

    }
}
