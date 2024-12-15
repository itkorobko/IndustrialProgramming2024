package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class PlainTextWriter extends MyFileWriter {
    @Override
	public void write(HashMap<String, Double> expressions_and_results) throws Exception{
    	FileWriter writer=new FileWriter(filename);
		for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			   String key = entry.getKey();
			   Double value = entry.getValue();
			writer.write(key+" = "+value.toString()+"\n");
		}
		writer.close();
	}
}
