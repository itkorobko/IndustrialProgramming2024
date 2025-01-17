package IndProgramming2024Package.IndProgramming2024Project;

public class YAMLReaderFactory extends MyFileReaderFactory {
	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		YAMLReader reader=new YAMLReader();
		reader.setFilename(filename);
		return reader;
	}
}
