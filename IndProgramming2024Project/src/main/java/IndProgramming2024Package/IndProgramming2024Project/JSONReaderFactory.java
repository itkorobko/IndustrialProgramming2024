package IndProgramming2024Package.IndProgramming2024Project;

import java.io.BufferedReader;
import java.io.FileReader;

public class JSONReaderFactory extends MyFileReaderFactory {
	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		JSONReader reader=new JSONReader();
		reader.setFilename(filename);
		return reader;
	}
}
