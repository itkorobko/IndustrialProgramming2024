package lab1pack.Lab1_project;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class App
{
	public static void main(String[] args) {
		ArrayList<String> strings_of_file= new ArrayList<String>();
		HashMap<String, String> hm=new HashMap<String, String>();
		try (BufferedReader reader=new BufferedReader(new FileReader("hehe.txt"));){
			String r_line=reader.readLine();
			while(r_line!=null) {
				boolean ravno_indicator=false;
				for(int i=0;i<r_line.length();i++) {
					if(r_line.charAt(i)=='=')
						ravno_indicator=true;
				}
				if(!ravno_indicator)
	                strings_of_file.add(r_line);
				else {
					String temp_var="";
					String temp_value="";
					boolean ravno_index=false;
					for(int i=0; i<r_line.length();i++) {
						if(r_line.charAt(i)=='=') {
							ravno_index=true;
							continue;
						}
						if(!ravno_index)
						    temp_var+=r_line.charAt(i);
						else temp_value+=r_line.charAt(i);
					}
					if(!temp_var.isEmpty() && !temp_value.isEmpty())
					    hm.put(temp_var, temp_value);
					else throw new Exception("Incorrect expresion!!!!");
				}
				r_line=reader.readLine();
			}
				
				for(int i=0;i<strings_of_file.size();i++) {
					OPZ expression=new OPZ();
					expression.setSourceLine(strings_of_file.get(i));
					expression.makeListOfOperands();
					for(int j=0;j<expression.list_of_operands.size();j++) {
						for(int k=0;k<hm.size();k++) {
							if(hm.get(expression.list_of_operands.get(j))!=null)
								expression.list_of_operands.set(j, hm.get(expression.list_of_operands.get(j)));
						}
					}
					expression.makeOPZ();
					double result=expression.calculateOPZ();
					System.out.println(strings_of_file.get(i));
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