package IndProgramming2024Package.IndProgramming2024Project;

import java.nio.file.Files;
import java.nio.file.Paths;

public class YAMLReaderFactory extends MyFileReaderFactory {
	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		YAMLReader reader=new YAMLReader();
		reader.setContent(new String(Files.readAllBytes(Paths.get(filename))));
		return reader;
	}
}
