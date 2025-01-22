package readersAndWriters;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import  readersAndWriters.Hoho.ExpressionsAndResults;

public class ProtobufOutputMaker implements OutputMaker{
	private String filename;
	public void setFilename(String filename) {
		this.filename=filename;
	}
	@Override
	public void makeOutput(HashMap<String, Double> expressions_and_results) throws Exception{
		FileOutputStream output_stream = new FileOutputStream("expressions_and_results.bin");
		ByteArrayOutputStream byte_expressions_and_results_stream = new ByteArrayOutputStream();
		ExpressionsAndResults.Builder expressions_and_results_builder=ExpressionsAndResults.newBuilder();
		expressions_and_results_builder.putAllVarsAndValues(expressions_and_results);
	
		ExpressionsAndResults expressions_and_results_message=expressions_and_results_builder.build();
		expressions_and_results_message.writeTo(byte_expressions_and_results_stream);
		byte_expressions_and_results_stream.writeTo(output_stream);
	}
}
