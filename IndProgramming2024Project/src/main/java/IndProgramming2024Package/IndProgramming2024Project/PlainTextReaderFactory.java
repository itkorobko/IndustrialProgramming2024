package IndProgramming2024Package.IndProgramming2024Project;

import java.io.BufferedReader;
import java.io.FileReader;

public class PlainTextReaderFactory extends MyFileReaderFactory{
//	public static MyFileReader createPlainTextReader(String filename) throws Exception {
//		PlainTextReader reader=new PlainTextReader();
//		reader.setBufferedReader(new BufferedReader(new FileReader(filename)));
//		return reader;
//	}
	@Override
	public MyFileReader createMyFileReader(String filename) throws Exception {
		PlainTextReader reader=new PlainTextReader();
		reader.setBufferedReader(new BufferedReader(new FileReader(filename)));
		return reader;
	}
}
