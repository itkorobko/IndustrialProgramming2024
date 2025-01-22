package readersAndWriters;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONOutputMaker implements OutputMaker {
	private Writer writer;
	public void setWriter(Writer writer) {
		this.writer=writer;
	}
	 @Override
	 public void makeOutput(HashMap<String, Double> expressions_and_results) throws Exception{
		
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
