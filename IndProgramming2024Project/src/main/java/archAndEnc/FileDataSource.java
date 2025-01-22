package archAndEnc;

import java.util.ArrayList;
import java.util.HashMap;

import readersAndWriters.HTMLReader;
import readersAndWriters.HTMLWriter;
import readersAndWriters.JSONReader;
import readersAndWriters.JSONWriter;
import readersAndWriters.MyReader;
import readersAndWriters.MyWriter;
import readersAndWriters.PlainTextReader;
import readersAndWriters.PlainTextWriter;
import readersAndWriters.ProtobufReader;
import readersAndWriters.ProtobufWriter;
import readersAndWriters.XMLReader;
import readersAndWriters.XMLWriter;
import readersAndWriters.YAMLReader;
import readersAndWriters.YAMLWriter;

public class FileDataSource implements DataSource {
	protected String filename;
	public  void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
		MyReader reader;
		StringBuilder filetype_builder=new StringBuilder();
		for(int i=filename.indexOf('.')+1;i<filename.length();i++) {
			filetype_builder.append(filename.charAt(i));
		}
		String filetype=new String(filetype_builder);
		switch(filetype) {
		case "txt":{
			reader=new PlainTextReader();
			break;
		}
		case "json":{
			reader=new JSONReader();
			break;
		}
		case "xml":{
			reader=new XMLReader();
			break;
		}
		case "html":{
			reader=new HTMLReader();
			break;
		}
		case "yml":{
			reader=new YAMLReader();
			break;
		}
		case "proto":{
			reader=new ProtobufReader();
			break;
		}
		default: throw new Exception("Incorrect file type :"+filetype);
		}
        reader.readFromFile(filename, lines_with_expression, vars_and_values);
	}
	public void write(HashMap<String, Double> expressions_and_results) throws Exception{
		MyWriter writer;
		StringBuilder filetype_builder=new StringBuilder();
		for(int i=filename.indexOf('.')+1;i<filename.length();i++) {
			filetype_builder.append(filename.charAt(i));
		}
		String filetype=new String(filetype_builder);
		switch(filetype) {
		case "txt":{
			writer=new PlainTextWriter();
			break;
		}
		case "json":{
			writer=new JSONWriter();
			break;
		}
		case "xml":{
			writer=new XMLWriter();
			break;
		}
		case "html":{
			writer=new HTMLWriter();
			break;
		}
		case "yml":{
			writer=new YAMLWriter();
			break;
		}
		case "proto":{
			writer=new ProtobufWriter();
			break;
		}
		default: throw new Exception("Incorrect file type :"+filetype);
		}
		writer.writeInFile(filename, expressions_and_results);
	}
}
