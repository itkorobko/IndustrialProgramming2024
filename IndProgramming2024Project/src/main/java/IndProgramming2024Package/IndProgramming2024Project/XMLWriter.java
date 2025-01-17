package IndProgramming2024Package.IndProgramming2024Project;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter implements MyFileWriter{
	private String filename;
	public void setFilename(String filename) {
		this.filename=filename;
	}
    public FileWriter getWriter(String fileName) throws Exception {
        return new FileWriter(fileName);
    }
	@Override
	public void write(HashMap<String, Double> expressions_and_results) throws Exception{
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    Document document = builder.newDocument();
		    Element root = document.createElement("expressions_and_results");
	        document.appendChild(root);

			for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
				   String map_key = entry.getKey();
				   Double map_value = entry.getValue();
				   Element expression_and_result=document.createElement("expresssion_and_result");
				   root.appendChild(expression_and_result);
				   Element expression=document.createElement("expression");
				   expression.appendChild(document.createTextNode(map_key));
				   expression_and_result.appendChild(expression);
				   Element result=document.createElement("result");
				   result.appendChild(document.createTextNode(map_value.toString()));
				   expression_and_result.appendChild(result);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(document);
	        StreamResult file_result = new StreamResult(getWriter(filename));
	        transformer.transform(source, file_result);
	     
	}
}
