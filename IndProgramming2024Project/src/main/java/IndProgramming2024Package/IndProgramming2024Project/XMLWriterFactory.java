package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;

public class XMLWriterFactory extends MyFileWriterFactory {
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		XMLWriter writer= new XMLWriter();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
