package IndProgramming2024Package.IndProgramming2024Project;

public class ProtobufReaderFactory extends MyFileReaderFactory{
	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		ProtobufReader reader=new ProtobufReader();
		reader.setFilename(filename);
		return reader;
	}
}
