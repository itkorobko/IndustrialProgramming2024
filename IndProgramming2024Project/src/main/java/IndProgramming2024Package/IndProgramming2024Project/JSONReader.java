package IndProgramming2024Package.IndProgramming2024Project;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONObject;

public class JSONReader extends MyFileReader  {
    @Override
	public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
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
}
