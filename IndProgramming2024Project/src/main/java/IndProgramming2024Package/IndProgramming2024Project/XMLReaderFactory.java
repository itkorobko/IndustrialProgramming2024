package IndProgramming2024Package.IndProgramming2024Project;

public class XMLReaderFactory extends MyFileReaderFactory {

	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		XMLReader reader=new XMLReader();
		reader.setFilename(filename);
		return reader;
	}
}
