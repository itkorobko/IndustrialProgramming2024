package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class PlainTextWriter implements MyFileWriter {
	private FileWriter writer;
	public void setWriter(FileWriter writer) {
		this.writer=writer;
	}
    @Override
	public void write(HashMap<String, Double> expressions_and_results) throws Exception{
		for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			   String key = entry.getKey();
			   Double value = entry.getValue();
			writer.write(key+" = "+value.toString()+"\n");
		}
		writer.close();
    	 
		
	}
}
