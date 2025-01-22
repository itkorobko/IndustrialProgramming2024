package archAndEnc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ArchivatorRARDecorator extends DataSourceDecorator {
	//protected String rarFilePath = "C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\hehe.txt.rar";
   // protected String outputDir="C:\\Users\\HP\\git\\IndustrialProgramming2024\\IndProgramming2024Project\\dearchivated files";
	ArchivatorRARDecorator(DataSource source) {
		super(source);
		
	}
	public static void archivate(String rarFilePath,String filesToArchive ) throws Exception{
		 ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "rar a " + rarFilePath + " " + filesToArchive);
	     processBuilder.redirectErrorStream(true); 
	     Process process = processBuilder.start();
	     process.waitFor();
	    // System.out.println("Archiving completed!");
	}
	public static void dearchivate(String rarFilePath,String outputPath ) throws Exception{
		ProcessBuilder processBuilder = new ProcessBuilder
				("C:\\Program Files (x86)\\WinRAR\\WinRAR.exe", "x", "-y", rarFilePath, outputPath);
            processBuilder.redirectErrorStream(true); 
            processBuilder.directory(new File(outputPath));
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
        
	}
	
	@Override
    public void write(HashMap<String, Double> expressions_and_results) throws Exception {
        super.write(expressions_and_results);
    //    archivate();
    }

    @Override
    public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
    //	 dearchivate();
         super.read(lines_with_expression, vars_and_values);
    }
}
