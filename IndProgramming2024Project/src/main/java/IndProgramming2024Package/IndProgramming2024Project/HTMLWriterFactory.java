package IndProgramming2024Package.IndProgramming2024Project;

public class HTMLWriterFactory extends MyFileWriterFactory {
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		HTMLWriter writer= new HTMLWriter();
		writer.setFilename(filename);
		return writer;
	}
}
