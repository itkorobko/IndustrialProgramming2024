package readersAndWriters;

import java.io.FileWriter;

public class PlainTextWriter extends MyWriter { 
	public OutputMaker createMyFileWriter(String filename) throws Exception{
		PlainTextOutputMaker writer= new PlainTextOutputMaker();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
