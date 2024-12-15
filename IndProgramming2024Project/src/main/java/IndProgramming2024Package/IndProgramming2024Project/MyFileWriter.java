package IndProgramming2024Package.IndProgramming2024Project;

import java.util.HashMap;

public abstract class MyFileWriter {

	protected String filename;
//	public  MyFileWriter(String future_filename) {
//		this.filename=future_filename;
//	}
	public void setFilename(String future_filename) {
		this.filename=future_filename;
	}
	public abstract void write(HashMap<String, Double> expressions_and_results) throws Exception;
}
