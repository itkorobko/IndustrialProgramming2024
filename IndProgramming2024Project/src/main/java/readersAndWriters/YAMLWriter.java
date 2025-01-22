package readersAndWriters;

import java.io.FileWriter;

public class YAMLWriter extends MyWriter {
	public OutputMaker createMyFileWriter(String filename) throws Exception{
		YAMLOutputMaker writer= new YAMLOutputMaker();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
