package IndProgramming2024Package.IndProgramming2024Project;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class HTMLReader extends MyFileReader {
	
	 @Override
	 public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
		 File input = new File(filename);
		 Document document = Jsoup.parse(input,"UTF-8");
		 for (Element paragraph : document.select("p")) {
			 Pattern pattern = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*)=(\\d+)");
			 String paragraph_text=paragraph.text();
			 Matcher matcher = pattern.matcher(paragraph_text);
			 if (matcher.find()) {
	                String variableName = matcher.group(1);
	                String variableValue = (matcher.group(2));
	                vars_and_values.put(variableName, variableValue);
	         }
			 else lines_with_expression.add(paragraph_text);
		 }
		 
	 }
}
