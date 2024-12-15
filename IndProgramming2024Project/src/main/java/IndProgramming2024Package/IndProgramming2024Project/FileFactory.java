package IndProgramming2024Package.IndProgramming2024Project;

public class FileFactory {

	public MyFileReader createMyFileReader(String filename) throws Exception {
		StringBuilder filetype_builder=new StringBuilder();
		for(int i=filename.indexOf('.')+1;i<filename.length();i++) {
			filetype_builder.append(filename.charAt(i));
		}
		String filetype=new String(filetype_builder);
		switch(filetype) {
		case "txt":{
			PlainTextReader created= new PlainTextReader();
			created.setFilename(filename);
			return created;
		}
		case "json":{
			JSONReader created= new JSONReader();
			created.setFilename(filename);
			return created;
		}
		case "xml":{
			XMLReader created=new XMLReader();
			created.setFilename(filename);
			return created;
		}
		case "html":{
			HTMLReader created= new HTMLReader();
			created.setFilename(filename);
			return created;
		}
		case "yml":{
			YAMLReader created= new YAMLReader();
			created.setFilename(filename);
			return created;
		}
		case "proto":{
			ProtobufReader created= new ProtobufReader();
			created.setFilename(filename);
			return created;
		}
			default: throw new Exception("Incorrect file type :"+filetype);
		}
			
	}
	public MyFileWriter createMyFileWriter(String filename) throws Exception {
		StringBuilder filetype_builder=new StringBuilder();
		for(int i=filename.indexOf('.')+1;i<filename.length();i++) {
			filetype_builder.append(filename.charAt(i));
		}
		String filetype=new String(filetype_builder);
		switch(filetype) {
		case "txt":{
			PlainTextWriter created= new PlainTextWriter();
			created.setFilename(filename);
			return created;
		}
		case "json":{
			JSONWriter created= new JSONWriter();
			created.setFilename(filename);
			return created;
		}
		case "xml":{
			XMLWriter created=new XMLWriter();
			created.setFilename(filename);
			return created;
		}
		case "html":{
			HTMLWriter created= new HTMLWriter();
			created.setFilename(filename);
			return created;
		}
		case "yml":{
			YAMLWriter created= new YAMLWriter();
			created.setFilename(filename);
			return created;
		}
		case "proto":{
			ProtobufWriter created= new ProtobufWriter();
			created.setFilename(filename);
			return created;
		}
			default: throw new Exception("Incorrect file type :"+filetype);
		}
			
	}
}
