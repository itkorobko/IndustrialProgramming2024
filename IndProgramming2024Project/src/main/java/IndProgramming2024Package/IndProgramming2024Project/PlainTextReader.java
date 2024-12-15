package IndProgramming2024Package.IndProgramming2024Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class PlainTextReader extends MyFileReader {
    @Override
	public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception {
		BufferedReader reader=new BufferedReader(new FileReader(filename));
		String r_line=reader.readLine();			
		while(r_line!=null) {
			boolean ravno_indicator=false;
			for(int i=0;i<r_line.length();i++) {
				if(r_line.charAt(i)=='=')
					ravno_indicator=true;
			}
			if(!ravno_indicator)
                lines_with_expression.add(r_line);
			else {
				ExpressionProcessor expression=new ExpressionProcessor();
				vars_and_values.putAll(expression.processLineWithValue(r_line));
			}
			r_line=reader.readLine();
		}	
		reader.close();
	}
}
