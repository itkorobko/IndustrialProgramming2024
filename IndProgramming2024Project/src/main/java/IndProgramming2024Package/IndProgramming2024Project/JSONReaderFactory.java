package IndProgramming2024Package.IndProgramming2024Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONReaderFactory extends MyFileReaderFactory {
	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		JSONReader reader=new JSONReader();
		//reader.setFilename(filename);
		reader.setContent(new String(Files.readAllBytes(Paths.get(filename))));
		return reader;
	}
}
