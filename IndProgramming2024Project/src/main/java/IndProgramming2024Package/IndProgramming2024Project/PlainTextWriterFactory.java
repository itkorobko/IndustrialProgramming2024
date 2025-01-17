package IndProgramming2024Package.IndProgramming2024Project;

public class PlainTextWriterFactory extends MyFileWriterFactory { 
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		PlainTextWriter writer= new PlainTextWriter();
		writer.setFilename(filename);
		return writer;
	}
}
