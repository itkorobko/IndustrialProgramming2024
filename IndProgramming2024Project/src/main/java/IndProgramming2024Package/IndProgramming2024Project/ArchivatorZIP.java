package IndProgramming2024Package.IndProgramming2024Project;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
public class ArchivatorZIP {
	public static void archivate(String zipFilePath, String[] filesToZip) throws Exception {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (String filePath : filesToZip) {
                Path sourceFilePath = Path.of(filePath);
                ZipEntry zipEntry = new ZipEntry(sourceFilePath.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry);

                
                try (FileInputStream fileInputStream = new FileInputStream(sourceFilePath.toFile())) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fileInputStream.read(buffer)) >= 0) {
                        zipOutputStream.write(buffer, 0, length);
                    }
                }
                zipOutputStream.closeEntry();
            }
        }
    }
	
	public static void dearchivate(String zipFilePath, String outputDir) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                Path outputPath = Path.of(outputDir, zipEntry.getName());

                // Создание необходимых директорий
                if (zipEntry.isDirectory()) {
                    Files.createDirectories(outputPath);
                } else {
                    // Запись файла
                    try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath.toFile())) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = zipInputStream.read(buffer)) >= 0) {
                            fileOutputStream.write(buffer, 0, length);
                        }
                    }
                }
                zipInputStream.closeEntry();
            }
        }
    }
}

