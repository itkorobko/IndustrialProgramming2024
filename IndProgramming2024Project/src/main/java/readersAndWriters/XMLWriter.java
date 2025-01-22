package readersAndWriters;

import java.io.FileWriter;

public class XMLWriter extends MyWriter {
	public OutputMaker createMyFileWriter(String filename) throws Exception{
		XMLOutputMaker writer= new XMLOutputMaker();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
