package readersAndWriters;

import java.nio.file.Files;
import java.nio.file.Paths;

public class YAMLReader extends MyReader {
	@Override
	public InputProcessor createMyFileReader(String filename) throws Exception {
		YAMLInputProcessor reader=new YAMLInputProcessor();
		reader.setContent(new String(Files.readAllBytes(Paths.get(filename))));
		return reader;
	}
}
