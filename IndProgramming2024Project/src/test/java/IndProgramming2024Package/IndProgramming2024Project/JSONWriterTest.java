package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;

import static org.mockito.Mockito.*;
import junit.framework.TestCase;
import readersAndWriters.JSONOutputMaker;
public class JSONWriterTest extends TestCase {
	private JSONOutputMaker jsonWriter;
    private FileWriter mockWriter;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        jsonWriter = new JSONOutputMaker();
        mockWriter = mock(FileWriter.class);
        jsonWriter.setWriter(mockWriter);
    }

    public void testWriteWithMultipleEntries() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();
        expressionsAndResults.put("2 + 2", 4.0);
        expressionsAndResults.put("3 * 3", 9.0);
        jsonWriter.makeOutput(expressionsAndResults);
        String expectedJson = new JSONArray()
                .put(new JSONObject().put("Expression", "2 + 2").put("Result", 4.0))
                .put(new JSONObject().put("Expression", "3 * 3").put("Result", 9.0))
                .toString(4);

        verify(mockWriter).write(expectedJson);
        verify(mockWriter).close();
    }

    public void testWriteWithEmptyMap() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();
        jsonWriter.makeOutput(expressionsAndResults);
        String expectedJson = new JSONArray().toString(4);
        verify(mockWriter).write(expectedJson);
        verify(mockWriter).close();
    }


    public void testWriteHandlesIOException() throws Exception {
        try {
            doThrow(new IOException()).when(mockWriter).write(anyString());
            HashMap<String, Double> expressionsAndResults = new HashMap<>();
            expressionsAndResults.put("1 + 1", 2.0);
            jsonWriter.makeOutput(expressionsAndResults);
            fail("Expected an IOException to be thrown");
        } 
        catch (IOException e) {
        } 
           
    }
}
