package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yaml.snakeyaml.Yaml;

public class YAMLReader implements MyFileReader {

	private String content;
	public void setContent(String content) {
		this.content=content;
	}
	  @Override
    public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
	    Yaml yaml = new Yaml();
	    HashMap<String, Object> yaml_map = yaml.load(content); 
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
