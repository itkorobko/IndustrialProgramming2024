package IndProgramming2024Package.IndProgramming2024Project;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
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
	private Writer writer;
	public void setWriter(Writer writer) {
		this.writer=writer;
	}
	@Override
	public void write(HashMap<String, Double> expressions_and_results) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.newDocument();
	    Element root = document.createElement("expressions_and_results");
	    document.appendChild(root);
	        for (Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
	            String mapKey = entry.getKey();
	            Double mapValue = entry.getValue();
	            Element expressionAndResult = document.createElement("expression_and_result");
	            root.appendChild(expressionAndResult);
	            Element expression = document.createElement("expression");
	            expression.appendChild(document.createTextNode(mapKey));
	            expressionAndResult.appendChild(expression);
	            Element result = document.createElement("result");
	            result.appendChild(document.createTextNode(mapValue.toString()));
	            expressionAndResult.appendChild(result);
	        }

	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    DOMSource source = new DOMSource(document);
	    StreamResult streamResult = new StreamResult(writer);
	    transformer.transform(source, streamResult);
	     
	}
}
