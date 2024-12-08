package IndProgramming2024Package.IndProgramming2024Project;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.util.Base64;
public class Encryptor {
	 private static final String ALGORITHM = "AES";
	    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	    private static final String SECRET_KEY = "0123456789ABCDEF"; 
	    private static final String INIT_VECTOR = "1234567890123456"; 

	    public static void encryptFile(String inputFileName, String outputFileName) throws Exception {
	    	File inputFile=new File(inputFileName);
	    	File outputFile=new File(outputFileName);
	        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
	        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes());
	        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

	        try (FileInputStream inputStream = new FileInputStream(inputFile);
	             FileOutputStream outputStream = new FileOutputStream(outputFile)) {   
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                byte[] output = cipher.update(buffer, 0, bytesRead);
	                if (output != null) {
	                    outputStream.write(output);
	                }
	            }
	            byte[] outputBytes = cipher.doFinal();
	            if (outputBytes != null) {
	                outputStream.write(outputBytes);
	            }
	        }
	    }

	    public static void decryptFile(String inputFileName,String  outputFileName) throws Exception {
	    	File inputFile=new File(inputFileName);
	    	File outputFile=new File(outputFileName);
	        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
	        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes());
	        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

	        try (FileInputStream inputStream = new FileInputStream(inputFile);
	             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                byte[] output = cipher.update(buffer, 0, bytesRead);
	                if (output != null) {
	                    outputStream.write(output);
	                }
	            }
	            byte[] outputBytes = cipher.doFinal();
	            if (outputBytes != null) {
	                outputStream.write(outputBytes);
	            }
	        }
	    }
}
