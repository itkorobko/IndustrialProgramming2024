package readersAndWriters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONReader extends MyReader {
	@Override
	public InputProcessor createMyFileReader(String filename) throws Exception {
		JSONInputProcessor reader=new JSONInputProcessor();
		//reader.setFilename(filename);
		reader.setContent(new String(Files.readAllBytes(Paths.get(filename))));
		return reader;
	}
}
