package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yaml.snakeyaml.Yaml;

public class YAMLReader extends MyFileReader {

	  @Override
      public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
		  Yaml yaml = new Yaml();
			FileReader reader=new FileReader(filename);
	        if (reader != null) {
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
}
