package readersAndWriters;

import java.nio.file.Files;
import java.nio.file.Paths;

public class HTMLReader extends MyReader {

	@Override
	public InputProcessor createMyFileReader(String filename) throws Exception {
		HTMLInputProcessor reader=new HTMLInputProcessor();
		reader.setContent(new String(Files.readAllBytes(Paths.get(filename))));
		return reader;
	}
}
