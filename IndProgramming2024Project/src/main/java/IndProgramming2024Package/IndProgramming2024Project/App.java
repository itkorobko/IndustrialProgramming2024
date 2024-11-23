package IndProgramming2024Package.IndProgramming2024Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class App
{
	public static void main(String[] args) {
		ArrayList<String> lines_with_expression= new ArrayList<String>();
     	HashMap<String, String> vars_and_values=new HashMap<String, String>();
       //     	
     	try{
     		FileProcessor protobuf_input=new FileProcessor("hehe.proto");
     		protobuf_input.readProtobuf(lines_with_expression,vars_and_values);
     		FileProcessor yaml_input=new FileProcessor("hehe.yml");
         	yaml_input.readYAML(lines_with_expression,vars_and_values);
    		FileProcessor html_input=new FileProcessor("hehe.html");
     		html_input.readHTML(lines_with_expression, vars_and_values);
     		FileProcessor xml_input=new FileProcessor("hehe.xml");
     		xml_input.readXML(lines_with_expression, vars_and_values);
     		FileProcessor json_input=new FileProcessor("hehe.json");
     		json_input.readJSON(lines_with_expression, vars_and_values);
     		FileProcessor plain_text_input=new FileProcessor("hehe.txt");
         	plain_text_input.readPlainText(lines_with_expression,vars_and_values);
         	
 		
      	
         	
     		HashMap<String,Double> expressions_and_results=new HashMap<>();
     		for(int i=0;i<lines_with_expression.size();i++) {
		    	ExpressionProcessor expression=new ExpressionProcessor();
				double result=expression.calculateLineWithExpression(lines_with_expression.get(i), vars_and_values);
				expressions_and_results.put(lines_with_expression.get(i), result);
			}
     		
     		
     		
     		FileProcessor plain_text_output=new FileProcessor("hoho.txt");
     		plain_text_output.writePlainText(expressions_and_results);
     		FileProcessor json_output=new FileProcessor("hoho.json");
     		json_output.writeJSON(expressions_and_results);
     		FileProcessor xml_output=new FileProcessor("hoho.xml");
     		xml_output.writeXML(expressions_and_results);
     		FileProcessor html_output=new FileProcessor("hoho.html");
     		html_output.writeHTML(expressions_and_results);
    		FileProcessor yaml_output=new FileProcessor("hoho.yml");
     		yaml_output.writeYAML(expressions_and_results);
     		FileProcessor protobuf_output=new FileProcessor("hoho.proto");
     		protobuf_output.writeProtobuf(expressions_and_results);
     	}
     	catch (Exception ex) {
		// TODO Auto-generated catch block
	     	System.out.println("Exception: "+ex.getMessage());
        }
     	
//		try (BufferedReader reader=new BufferedReader(new FileReader("hehe.txt"))){
//			String r_line=reader.readLine();			
//			while(r_line!=null) {
//				boolean ravno_indicator=false;
//				for(int i=0;i<r_line.length();i++) {
//					if(r_line.charAt(i)=='=')
//						ravno_indicator=true;
//				}
//				if(!ravno_indicator)
//	                lines_with_expression.add(r_line);
//				else {
//					ExpressionProcessor expression=new ExpressionProcessor();
//					vars_and_values.putAll(expression.processLineWithValue(r_line));
//				}
//				r_line=reader.readLine();
//			}		
//		
//				for(int i=0;i<lines_with_expression.size();i++) {
//					ExpressionProcessor expression=new ExpressionProcessor();
//					double result=expression.calculateLineWithExpression(lines_with_expression.get(i), vars_and_values);
//					System.out.println(lines_with_expression.get(i));
//					System.out.println("Result = "+result);
//				}
//	    } 	
//   	    catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    catch(Exception ex) {
//		System.out.println(ex.getMessage());
//	    }
	}
	
}