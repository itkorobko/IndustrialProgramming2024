package IndProgramming2024Package.IndProgramming2024Project;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
import org.yaml.snakeyaml.Yaml;

import IndProgramming2024Package.IndProgramming2024Project.Hehe.Expressions;
import IndProgramming2024Package.IndProgramming2024Project.Hehe.VarsAndValues;
import IndProgramming2024Package.IndProgramming2024Project.Hoho.ExpressionsAndResults;

public class FileProcessor{
	protected String filename;
		
	FileProcessor(String future_file_name){
		this.filename=future_file_name;	
		}
	
	
	void readPlainText(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception {
		BufferedReader reader=new BufferedReader(new FileReader(filename));
			String r_line=reader.readLine();			
			while(r_line!=null) {
				boolean ravno_indicator=false;
				for(int i=0;i<r_line.length();i++) {
					if(r_line.charAt(i)=='=')
						ravno_indicator=true;
				}
				if(!ravno_indicator)
	                lines_with_expression.add(r_line);
				else {
					ExpressionProcessor expression=new ExpressionProcessor();
					vars_and_values.putAll(expression.processLineWithValue(r_line));
				}
				r_line=reader.readLine();
			}	
			reader.close();

	}	
	
	
	void readJSON(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception {
		 String content = new String(Files.readAllBytes(Paths.get(filename)));
         JSONObject json_object = new JSONObject(content);
		  Iterator<String> keys = json_object.keys();
          while (keys.hasNext()) {
              String key = keys.next(); 
              Object value = json_object.get(key);
              if(value instanceof String) {
            	  lines_with_expression.add(value.toString());
              }
              else if(value instanceof Double || value instanceof Integer) {
            	  vars_and_values.put(key, value.toString());
              }           
          }
	}
	
	void readXML(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(filename));
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
	
	void readHTML(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
		 File input = new File(filename);
		 org.jsoup.nodes.Document document = Jsoup.parse(input,"UTF-8");
		 for (org.jsoup.nodes.Element paragraph : document.select("p")) {
			 Pattern pattern = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*)=(\\d+)");
			 String paragraph_text=paragraph.text();
			 Matcher matcher = pattern.matcher(paragraph_text);
			 if (matcher.find()) {
	                String variableName = matcher.group(1);
	                String variableValue = (matcher.group(2));
	                vars_and_values.put(variableName, variableValue);
	         }
			 else lines_with_expression.add(paragraph_text);
		 }
		 
	}
	
	void readYAML(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
		Yaml yaml = new Yaml();
		FileReader reader=new FileReader(filename);
      //  InputStream inputStream = FileProcessor.class.getClassLoader().getResourceAsStream(filename);
        if (reader != null) {
        	 //HashMap<String, Object> yaml_map = yaml.load(inputStream); 
        	HashMap<String, Object> yaml_map = yaml.load(reader); 
        	 for(Map.Entry<String,Object> entry : yaml_map.entrySet()) {
        		 Pattern pattern_of_var = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*)");
    			 Matcher matcher_of_var = pattern_of_var.matcher(entry.getKey());
    			 if (matcher_of_var.find() && (entry.getValue() instanceof Integer || (entry.getValue() instanceof Double))) {
    	                String variableName = entry.getKey();
    	                String variableValue = entry.getValue().toString();
    	                vars_and_values.put(variableName, variableValue);
    	         }
    			 else lines_with_expression.add(entry.getValue().toString());
        	 }
        }
	}
	
	void readProtobuf(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{ 
		
		if(true) {
     		makeBinProtobuf();
		}
		FileInputStream expressions_stream = new FileInputStream("expressions.bin"); 
		
		if(expressions_stream!=null) {
			Expressions expressions_message =Expressions.parseFrom(expressions_stream);
			
			for(int i=0;i<expressions_message.getExpressionCount();i++) {
				lines_with_expression.add(expressions_message.getExpression(i));
			}
		}
        FileInputStream vars_and_values_stream = new FileInputStream("vars_and_values.bin"); 
		
		if(vars_and_values_stream!=null) {
			
			VarsAndValues vars_and_values_message= VarsAndValues.parseFrom(vars_and_values_stream);
			
			
			//vars_and_values.putAll(vars_and_values_message.getVarsAndValuesMap());
			for(Map.Entry<String,Double> entry : vars_and_values_message.getVarsAndValuesMap().entrySet()) {
				vars_and_values.put(entry.getKey(), entry.getValue().toString());
			}
		}
	}
	
	void makeBinProtobuf() throws Exception {
		FileOutputStream expressions_stream = new FileOutputStream("expressions.bin");
		FileOutputStream vars_and_values_stream = new FileOutputStream("vars_and_values.bin");
		ByteArrayOutputStream byte_expressions_stream = new ByteArrayOutputStream();
		ByteArrayOutputStream byte_vars_and_values_stream = new ByteArrayOutputStream();
		Expressions.Builder expressions_builder=Expressions.newBuilder();
		VarsAndValues.Builder vars_and_values_builder=VarsAndValues.newBuilder();
		expressions_builder.addExpression("be+ba-8");
		expressions_builder.addExpression("(goga+boba)/12");
		vars_and_values_builder.putVarsAndValues("be",15);
		vars_and_values_builder.putVarsAndValues("ba",18);
		vars_and_values_builder.putVarsAndValues("goga",4);
		vars_and_values_builder.putVarsAndValues("boba",16);
		
		VarsAndValues vars_and_values_message=vars_and_values_builder.build();
		vars_and_values_message.writeTo(byte_vars_and_values_stream);
	
		Expressions expressions_message=expressions_builder.build();
		expressions_message.writeTo(byte_expressions_stream);
		byte_vars_and_values_stream.writeTo(vars_and_values_stream);
		byte_expressions_stream.writeTo(expressions_stream);
	}
	
	
	
	
	
	void writePlainText(HashMap<String, Double> expressions_and_results) throws Exception{
		FileWriter writer=new FileWriter(filename);
		for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			   String key = entry.getKey();
			   Double value = entry.getValue();
			writer.write(key+" = "+value.toString()+"\n");
		}
		writer.close();
	}
	
	void writeJSON(HashMap<String, Double> expressions_and_results) throws Exception {
		FileWriter writer=new FileWriter(filename);
		JSONArray json_array=new JSONArray();
		
		for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			   String map_key = entry.getKey();
			   Double map_value = entry.getValue();
			   JSONObject json_object=new JSONObject();
			   json_object.put("Expression", map_key);
			   json_object.put("Result", map_value);
			   json_array.put(json_object);
		}
		writer.write(json_array.toString(4));
		writer.close();

	}
	
	void writeXML(HashMap<String, Double> expressions_and_results) throws Exception {
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
        StreamResult file_result = new StreamResult(new File(filename));
        transformer.transform(source, file_result);
     
	}

	void writeHTML(HashMap<String, Double> expressions_and_results) throws Exception{
		 org.jsoup.nodes.Document document =  org.jsoup.nodes.Document.createShell("");
		 org.jsoup.nodes.Element body = document.body();
		 for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			 String map_key = entry.getKey();
			 Double map_value = entry.getValue();
			 body.appendElement("p").text(map_key+"="+map_value.toString());
		 }
		 File output = new File(filename);
		 FileWriter writer = new FileWriter(output);
		 writer.write(document.outerHtml()); 
		 writer.close();
	}
	
	
	
	public class ResultPairForYAML{
		private String expression;
		private Double result;
		public String getExpression() {
			return expression;
		}
		public Double getResult() {
			return result;
		}
		public void setExpression(String other_expression) {
			this.expression=other_expression;
		}
		public void setResult(Double other_result) {
			this.result=other_result;
		}
	}
	void writeYAML(HashMap<String, Double> expressions_and_results) throws Exception{
		
		Yaml yaml = new Yaml();
	    FileWriter writer = new FileWriter("hoho.yml");
	    for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
	    	    ResultPairForYAML pair_for_writing=new ResultPairForYAML();
	    	    pair_for_writing.setExpression(entry.getKey());
	    	    pair_for_writing.setResult(entry.getValue());
	            yaml.dump(pair_for_writing, writer);
	    }     
	      
	}
	
	void writeProtobuf(HashMap<String, Double> expressions_and_results) throws Exception{
		
		FileOutputStream output_stream = new FileOutputStream("expressions_and_results.bin");
		ByteArrayOutputStream byte_expressions_and_results_stream = new ByteArrayOutputStream();
		ExpressionsAndResults.Builder expressions_and_results_builder=ExpressionsAndResults.newBuilder();
		expressions_and_results_builder.putAllVarsAndValues(expressions_and_results);
	
		ExpressionsAndResults expressions_and_results_message=expressions_and_results_builder.build();
		expressions_and_results_message.writeTo(byte_expressions_and_results_stream);
		byte_expressions_and_results_stream.writeTo(output_stream);
	}
}
