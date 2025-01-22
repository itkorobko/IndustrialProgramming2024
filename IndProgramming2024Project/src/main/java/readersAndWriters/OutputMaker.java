package readersAndWriters;

import java.util.HashMap;

public interface  OutputMaker {

//	protected String filename;
//	public  MyFileWriter(String future_filename) {
//		this.filename=future_filename;
//	}
//	public void setFilename(String future_filename) {
//		this.filename=future_filename;
//	}
	public abstract void makeOutput(HashMap<String, Double> expressions_and_results) throws Exception;
}
