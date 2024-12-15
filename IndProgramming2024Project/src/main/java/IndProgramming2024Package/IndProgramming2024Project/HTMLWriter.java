package IndProgramming2024Package.IndProgramming2024Project;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.nodes.*;

public class HTMLWriter extends MyFileWriter {
	@Override
	public void write(HashMap<String, Double> expressions_and_results) throws Exception{
		 Document document =  Document.createShell("");
		 Element body = document.body();
		 for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
			 String map_key = entry.getKey();
			 Double map_value = entry.getValue();
			 body.appendElement("p").text(map_key+"="+map_value.toString());
		 }
		 File output = new File(filename);
		 FileWriter writer = new FileWriter(output);
		 writer.write(document.outerHtml()); 
		 writer.close();
	}
}
