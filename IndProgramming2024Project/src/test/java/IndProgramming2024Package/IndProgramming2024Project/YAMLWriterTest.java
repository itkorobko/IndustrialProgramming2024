package IndProgramming2024Package.IndProgramming2024Project;

import junit.framework.TestCase;
import org.mockito.Mockito;

import java.io.StringWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class YAMLWriterTest extends TestCase {
    private YAMLWriter yamlWriter;
    private StringWriter stringWriter;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        yamlWriter = new YAMLWriter();
        stringWriter = new StringWriter(); 
        yamlWriter.setWriter(new PrintWriter(stringWriter)); 
    }

    public void testWriteSingleEntry() throws Exception {
        LinkedHashMap<String, Double> expressionsAndResults = new LinkedHashMap<>();
        expressionsAndResults.put("expression1", 1.0);
      
        yamlWriter.write(expressionsAndResults);

        String expectedOutput = "!!IndProgramming2024Package.IndProgramming2024Project.ResultPairForYAMLWriter"
                + " {expression: expression1,\n"
                + " result: 1.0}\n";

        assertEquals(expectedOutput.replaceAll("\\s+", "").trim(), stringWriter.toString().replaceAll("\\s+", "").trim());
    }

    public void testWriteMultipleEntries() throws Exception {
        LinkedHashMap<String, Double> expressionsAndResults = new LinkedHashMap<>();
        expressionsAndResults.put("expression1", 1.0);
        expressionsAndResults.put("expression2", 2.0);

        yamlWriter.write(expressionsAndResults);
        
        String expectedOutput = "!!IndProgramming2024Package.IndProgramming2024Project.ResultPairForYAMLWriter"
                + " {expression: expression1,\n"
                + " result: 1.0}\n"
                + "!!IndProgramming2024Package.IndProgramming2024Project.ResultPairForYAMLWriter"
                + " {expression: expression2,\n"
                + " result: 2.0}\n";

        assertEquals(expectedOutput.replaceAll("\\s+", "").trim(), stringWriter.toString().replaceAll("\\s+", "").trim());
    }

    public void testWriteEmptyMap() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();

        yamlWriter.write(expressionsAndResults);
        assertEquals("", stringWriter.toString()); 
    }

    public void testWriteNull() {
        try {
            yamlWriter.write(null);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
