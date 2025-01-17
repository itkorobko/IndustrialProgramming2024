package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class PlainTextWriter implements MyFileWriter {
	private String filename;
	public void setFilename(String filename) {
		this.filename=filename;
	}
    public FileWriter getWriter(String fileName) throws Exception {
        return new FileWriter(fileName);
    }
    @Override
	public void write(HashMap<String, Double> expressions_and_results) throws Exception{
    	FileWriter writer=getWriter(filename);
		for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			   String key = entry.getKey();
			   Double value = entry.getValue();
			writer.write(key+" = "+value.toString()+"\n");
		}
		writer.close();
	}
}
