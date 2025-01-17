package IndProgramming2024Package.IndProgramming2024Project;

public class ProtobufWriterFactory extends MyFileWriterFactory{
	public MyFileWriter createMyFileWriter(String filename) throws Exception{
		ProtobufWriter writer= new ProtobufWriter();
		writer.setFilename(filename);
		return writer;
	}
}
