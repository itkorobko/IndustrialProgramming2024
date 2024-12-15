package IndProgramming2024Package.IndProgramming2024Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class App
{
	public static void main(String[] args) {
		ArrayList<String> lines_with_expression= new ArrayList<String>();
     	HashMap<String, String> vars_and_values=new HashMap<String, String>();
   	
     	try{
     		System.out.println("Enter filename for reading");
     		Scanner in = new Scanner(System.in);
     		String in_filename=new String();
     		in_filename=in.next();
     		FileFactory file_fabric=new FileFactory();
     		MyFileReader in_file=file_fabric.createMyFileReader(in_filename);
     		in_file.read(lines_with_expression, vars_and_values);
     	
     		
     		
     		
//     		FileProcessor protobuf_input=new FileProcessor("hehe.proto");
//     		protobuf_input.readProtobuf(lines_with_expression,vars_and_values);
//     		FileProcessor yaml_input=new FileProcessor("hehe.yml");
//         	yaml_input.readYAML(lines_with_expression,vars_and_values);
//    		FileProcessor html_input=new FileProcessor("hehe.html");
//     		html_input.readHTML(lines_with_expression, vars_and_values);
//     		FileProcessor xml_input=new FileProcessor("hehe.xml");
//     		xml_input.readXML(lines_with_expression, vars_and_values);
//     		FileProcessor json_input=new FileProcessor("hehe.json");
//     		json_input.readJSON(lines_with_expression, vars_and_values);
//     		FileProcessor plain_text_input=new FileProcessor("hehe.txt");
//         	plain_text_input.readPlainText(lines_with_expression,vars_and_values);
//         	
     		
//         	Encryptor.decryptFile("hehe.txt.enc", "hehe_decrypted.txt");
      	    
         	
     		HashMap<String,Double> expressions_and_results=new HashMap<>();
     		for(int i=0;i<lines_with_expression.size();i++) {
		    	ExpressionProcessor expression=new ExpressionProcessor();
				double result=expression.calculateLineWithExpression(lines_with_expression.get(i), vars_and_values);
				expressions_and_results.put(lines_with_expression.get(i), result);
			}
     		
     		
     		
     		System.out.println("Enter filename for writing");
     		String out_filename=new String();
     		out_filename=in.next();
     		MyFileWriter out_file=file_fabric.createMyFileWriter(out_filename);
     		out_file.write(expressions_and_results);
     		in.close();
     		
     		
//     		FileProcessor plain_text_output=new FileProcessor("hoho.txt");
//     		plain_text_output.writePlainText(expressions_and_results);
//     		FileProcessor json_output=new FileProcessor("hoho.json");
//     		json_output.writeJSON(expressions_and_results);
//     		FileProcessor xml_output=new FileProcessor("hoho.xml");
//     		xml_output.writeXML(expressions_and_results);
//     		FileProcessor html_output=new FileProcessor("hoho.html");
//     		html_output.writeHTML(expressions_and_results);
//    		FileProcessor yaml_output=new FileProcessor("hoho.yml");
//     		yaml_output.writeYAML(expressions_and_results);
//     		FileProcessor protobuf_output=new FileProcessor("hoho.proto");
//     		protobuf_output.writeProtobuf(expressions_and_results);
//     		
//     		
//     		
//     		
//     		Encryptor.encryptFile("hoho.txt", "hoho.txt.enc");
//     		
//     		
//     		
//     		
//     		String rarFilePath = "C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\hehe.txt.rar"; 
//    		String filesToArchive = "C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\hehe.txt";
//     		ArchivatorRAR.archivate(rarFilePath, filesToArchive);
//     		   		
//     		String outputPath="C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\dearchivated files";
//    		ArchivatorRAR.dearchivate(rarFilePath, outputPath);
//    		
//    		
//    		
//    		
//    		
//    		String zipFilePath = "C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\ZIPArchive.zip"; 
//    		   String[] filesToZip = {
//    		            "C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\hehe.txt",
//    		            "C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\hoho.txt"
//    		        };
//    		   ArchivatorZIP.archivate(zipFilePath, filesToZip);
//    		   
//    		   
//    		   String outputDir ="C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\dearchivatedZIP";
//    		   ArchivatorZIP.dearchivate(zipFilePath, outputDir);
//    		   
//    		   
    		   
    		   
    		   
     	}
     	catch (Exception ex) {
		// TODO Auto-generated catch block
	     	System.out.println("Exception: "+ex.getMessage());
        }
     	System.out.println("Have been done successfully");
	}
	
}