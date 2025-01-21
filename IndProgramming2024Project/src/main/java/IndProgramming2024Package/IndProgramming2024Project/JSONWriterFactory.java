package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;

public class JSONWriterFactory extends MyFileWriterFactory {
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		JSONWriter writer= new JSONWriter();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
