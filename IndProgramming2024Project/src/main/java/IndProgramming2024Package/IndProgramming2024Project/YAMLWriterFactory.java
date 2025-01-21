package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;

public class YAMLWriterFactory extends MyFileWriterFactory {
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		YAMLWriter writer= new YAMLWriter();
		writer.setWriter(new FileWriter(filename));
		return writer;
	}
}
