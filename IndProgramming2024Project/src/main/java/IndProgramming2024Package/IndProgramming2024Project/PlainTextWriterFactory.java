package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;

public class PlainTextWriterFactory extends MyFileWriterFactory { 
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		PlainTextWriter writer= new PlainTextWriter();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
