package IndProgramming2024Package.IndProgramming2024Project;

public class YAMLWriterFactory extends MyFileWriterFactory {
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		YAMLWriter writer= new YAMLWriter();
		writer.setFilename(filename);
		return writer;
	}
}
