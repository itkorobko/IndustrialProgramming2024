package IndProgramming2024Package.IndProgramming2024Project;

import java.nio.file.Files;
import java.nio.file.Paths;

public class HTMLReaderFactory extends MyFileReaderFactory {

	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		HTMLReader reader=new HTMLReader();
		reader.setContent(new String(Files.readAllBytes(Paths.get(filename))));
		return reader;
	}
}
