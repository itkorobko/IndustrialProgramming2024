package IndProgramming2024Package.IndProgramming2024Project;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class MyFileWriterFactory {
	public abstract MyFileWriter createMyFileWriter(String filename) throws Exception;
	public void write(String filename,HashMap<String, Double> expressions_and_results) throws Exception{
		MyFileWriter writer=createMyFileWriter(filename);
		writer.write(expressions_and_results);
	}
}
