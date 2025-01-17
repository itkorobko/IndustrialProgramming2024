package IndProgramming2024Package.IndProgramming2024Project;

public class HTMLReaderFactory extends MyFileReaderFactory {

	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		HTMLReader reader=new HTMLReader();
		reader.setFilename(filename);
		return reader;
	}
}
