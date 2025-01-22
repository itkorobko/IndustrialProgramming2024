package readersAndWriters;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class PlainTextOutputMaker implements OutputMaker {
	private FileWriter writer;
	public void setWriter(FileWriter writer) {
		this.writer=writer;
	}
    @Override
	public void makeOutput(HashMap<String, Double> expressions_and_results) throws Exception{
		for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			   String key = entry.getKey();
			   Double value = entry.getValue();
			writer.write(key+" = "+value.toString()+"\n");
		}
		writer.close();
    	 
		
	}
}
