package IndProgramming2024Package.IndProgramming2024Project;

public class JSONWriterFactory extends MyFileWriterFactory {
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		JSONWriter writer= new JSONWriter();
		writer.setFilename(filename);
		return writer;
	}
}
