package readersAndWriters;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class HTMLInputProcessor implements InputProcessor {
	private String content;
	public void setContent(String content) {
		this.content=content;
	}
	 @Override
	 public void processInput(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
	     Document document = Jsoup.parse(content);
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
