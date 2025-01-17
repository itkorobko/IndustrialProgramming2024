package IndProgramming2024Package.IndProgramming2024Project;

public class XMLWriterFactory extends MyFileWriterFactory {
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		XMLWriter writer= new XMLWriter();
		writer.setFilename(filename);
		return writer;
	}
}
