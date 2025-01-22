package readersAndWriters;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class MyWriter {
	public abstract OutputMaker createMyFileWriter(String filename) throws Exception;
	public void writeInFile(String filename,HashMap<String, Double> expressions_and_results) throws Exception{
		OutputMaker writer=createMyFileWriter(filename);
		writer.makeOutput(expressions_and_results);
	}
}
