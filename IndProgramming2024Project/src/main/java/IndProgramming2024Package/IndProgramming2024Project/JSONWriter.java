package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter extends MyFileWriter {
	 @Override
	 public void write(HashMap<String, Double> expressions_and_results) throws Exception{
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
}
