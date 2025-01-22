package readersAndWriters;

import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLReader extends MyReader {

	@Override
	public InputProcessor createMyFileReader(String filename) throws Exception {
		XMLInputProcessor reader=new XMLInputProcessor();
		reader.setContent(new String(Files.readAllBytes(Paths.get(filename))));
		return reader;
	}
}
