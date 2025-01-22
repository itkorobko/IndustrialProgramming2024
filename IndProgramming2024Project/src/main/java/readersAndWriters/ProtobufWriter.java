package readersAndWriters;

public class ProtobufWriter extends MyWriter{
	public OutputMaker createMyFileWriter(String filename) throws Exception{
		ProtobufOutputMaker writer= new ProtobufOutputMaker();
		writer.setFilename(filename);
		return writer;
	}
}
