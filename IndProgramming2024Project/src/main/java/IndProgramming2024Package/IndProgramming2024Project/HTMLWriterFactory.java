package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;

public class HTMLWriterFactory extends MyFileWriterFactory {
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		HTMLWriter writer= new HTMLWriter();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
