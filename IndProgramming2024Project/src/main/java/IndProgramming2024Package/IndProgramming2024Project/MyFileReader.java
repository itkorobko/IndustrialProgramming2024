package IndProgramming2024Package.IndProgramming2024Project;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;

public interface MyFileReader {

//	protected String filename;
//	protected BufferedReader reader;
	

//	public void setFilename(String future_filename) {
//		this.filename=future_filename;
//	}
//	public void setReader(BufferedReader reader) {
//		this.reader=reader;
//	}
	public abstract void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception;
}

