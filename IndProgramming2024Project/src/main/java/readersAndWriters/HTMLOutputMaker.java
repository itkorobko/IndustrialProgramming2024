package readersAndWriters;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.nodes.*;

public class HTMLOutputMaker implements OutputMaker {
	private Writer writer;
	public void setWriter(Writer writer) {
		this.writer=writer;
	}
	@Override
	public void makeOutput(HashMap<String, Double> expressions_and_results) throws Exception{
		 Document document =  Document.createShell("");
		 Element body = document.body();
		 for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			 String map_key = entry.getKey();
			 Double map_value = entry.getValue();
			 body.appendElement("p").text(map_key+"="+map_value.toString());
		 }
		 writer.write(document.outerHtml()); 
		 writer.close();
	}
}
