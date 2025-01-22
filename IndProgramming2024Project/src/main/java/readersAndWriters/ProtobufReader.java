package readersAndWriters;

public class ProtobufReader extends MyReader{
	@Override
	public InputProcessor createMyFileReader(String filename) throws Exception {
		ProtobufInputProcessor reader=new ProtobufInputProcessor();
		reader.setFilename(filename);
		return reader;
	}
}
