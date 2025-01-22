package readersAndWriters;

import java.io.FileWriter;

public class HTMLWriter extends MyWriter {
	public OutputMaker createMyFileWriter(String filename) throws Exception{
		HTMLOutputMaker writer= new HTMLOutputMaker();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
