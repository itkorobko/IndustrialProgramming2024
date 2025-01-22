package IndProgramming2024Package.IndProgramming2024Project;

import junit.framework.TestCase;
import org.mockito.Mockito;

import java.io.StringWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import readersAndWriters.YAMLOutputMaker;
public class YAMLWriterTest extends TestCase {
    private YAMLOutputMaker yamlWriter;
    private StringWriter stringWriter;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        yamlWriter = new YAMLOutputMaker();
        stringWriter = new StringWriter(); 
        yamlWriter.setWriter(new PrintWriter(stringWriter)); 
    }

    public void testWriteSingleEntry() throws Exception {
        LinkedHashMap<String, Double> expressionsAndResults = new LinkedHashMap<>();
        expressionsAndResults.put("expression1", 1.0);
      
        yamlWriter.makeOutput(expressionsAndResults);

        String expectedOutput = "!!readersAndWriters.ResultPairForYAMLWriter"
                + " {expression: expression1,\n"
                + " result: 1.0}\n";

        assertEquals(expectedOutput.replaceAll("\\s+", "").trim(), stringWriter.toString().replaceAll("\\s+", "").trim());
    }

    public void testWriteMultipleEntries() throws Exception {
        LinkedHashMap<String, Double> expressionsAndResults = new LinkedHashMap<>();
        expressionsAndResults.put("expression1", 1.0);
        expressionsAndResults.put("expression2", 2.0);

        yamlWriter.makeOutput(expressionsAndResults);
        
        String expectedOutput = "!!readersAndWriters.ResultPairForYAMLWriter"
                + " {expression: expression1,\n"
                + " result: 1.0}\n"
                + "!!readersAndWriters.ResultPairForYAMLWriter"
                + " {expression: expression2,\n"
                + " result: 2.0}\n";

        assertEquals(expectedOutput.replaceAll("\\s+", "").trim(), stringWriter.toString().replaceAll("\\s+", "").trim());
    }

    public void testWriteEmptyMap() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();

        yamlWriter.makeOutput(expressionsAndResults);
        assertEquals("", stringWriter.toString()); 
    }

    public void testWriteNull() {
        try {
            yamlWriter.makeOutput(null);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
