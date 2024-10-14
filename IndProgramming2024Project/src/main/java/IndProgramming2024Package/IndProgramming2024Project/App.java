package IndProgramming2024Package.IndProgramming2024Project;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class App
{
	public static void main(String[] args) {
		ArrayList<String> lines_with_expression= new ArrayList<String>();
		HashMap<String, String> vars_and_values=new HashMap<String, String>();
		
		try (BufferedReader reader=new BufferedReader(new FileReader("hehe.txt"));){
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
					ExpressionProcesser expression=new ExpressionProcesser();
					vars_and_values.putAll(expression.processLineWithValue(r_line));
				}
				r_line=reader.readLine();
			}		
				for(int i=0;i<lines_with_expression.size();i++) {
					ExpressionProcesser expression=new ExpressionProcesser();
					double result=expression.calculateLineWithExpression(lines_with_expression.get(i), vars_and_values);
					System.out.println(lines_with_expression.get(i));
					System.out.println("Result = "+result);
				}
	    } 	
   	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    catch(Exception ex) {
		System.out.println(ex.getMessage());
	    }
	}
	
}