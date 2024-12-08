package IndProgramming2024Package.IndProgramming2024Project;

import java.io.File;

public class ArchivatorRAR {
	
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
//
//            if (exitCode == 0) {
//                System.out.println("Дехаривирование завершено успешно.");
//            } 
//            else {
//                System.out.println("Ошибка при деархивации. Код завершения: " + exitCode);
//	        }
	}
}
