package readersAndWriters;

import java.io.FileWriter;

public class JSONWriter extends MyWriter {
	public OutputMaker createMyFileWriter(String filename) throws Exception{
		JSONOutputMaker writer= new JSONOutputMaker();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
