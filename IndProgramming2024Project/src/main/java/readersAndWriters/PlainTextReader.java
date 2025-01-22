package readersAndWriters;

import java.io.BufferedReader;
import java.io.FileReader;

public class PlainTextReader extends MyReader{
//	public static MyFileReader createPlainTextReader(String filename) throws Exception {
//		PlainTextReader reader=new PlainTextReader();
//		reader.setBufferedReader(new BufferedReader(new FileReader(filename)));
//		return reader;
//	}
	@Override
	public InputProcessor createMyFileReader(String filename) throws Exception {
		PlainTextInputProcessor reader=new PlainTextInputProcessor();
		reader.setBufferedReader(new BufferedReader(new FileReader(filename)));
		return reader;
	}
}
