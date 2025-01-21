package IndProgramming2024Package.IndProgramming2024Project;

import junit.framework.TestCase;
import org.mockito.Mockito;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PlainTextWriterTest extends TestCase {
    private PlainTextWriter plainTextWriter;
    private FileWriter mockWriter;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        plainTextWriter = new PlainTextWriter();
        mockWriter = Mockito.mock(FileWriter.class);
        plainTextWriter.setWriter(mockWriter);
    }

    public void testWriteExpressionsAndResults() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();
        expressionsAndResults.put("x", 5.0);
        expressionsAndResults.put("y", 10.0);
        plainTextWriter.write(expressionsAndResults);
        Mockito.verify(mockWriter).write("x = 5.0\n");
        Mockito.verify(mockWriter).write("y = 10.0\n");
        Mockito.verify(mockWriter).close();
    }

    public void testWriteEmptyMap() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();
        plainTextWriter.write(expressionsAndResults);
        Mockito.verify(mockWriter).close(); 
        Mockito.verify(mockWriter, Mockito.never()).write(Mockito.anyString()); 
    }

    public void testWriteWithException() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();
        expressionsAndResults.put("x+y", 5.0);
        Mockito.doThrow(new IOException("Write error")).when(mockWriter).write(Mockito.anyString());
        try {
            plainTextWriter.write(expressionsAndResults);
            fail("Expected an Exception to be thrown");
        } catch (IOException e) {
            assertEquals("Write error", e.getMessage());
        }
    }
}