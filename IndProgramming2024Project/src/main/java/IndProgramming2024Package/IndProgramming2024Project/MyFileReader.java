package IndProgramming2024Package.IndProgramming2024Project;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class MyFileReader {

	protected String filename;
//	public MyFileReader(String future_filename) {
//		this.filename=future_filename;
//	}
	public void setFilename(String future_filename) {
		this.filename=future_filename;
	}
	public abstract void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception;
}

