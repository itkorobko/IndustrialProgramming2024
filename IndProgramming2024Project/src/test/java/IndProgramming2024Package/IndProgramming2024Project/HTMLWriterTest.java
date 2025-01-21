package IndProgramming2024Package.IndProgramming2024Project;

import junit.framework.TestCase;

import java.io.StringWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class HTMLWriterTest extends TestCase {
    private HTMLWriter htmlWriter;
    private StringWriter stringWriter;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        htmlWriter = new HTMLWriter();
        stringWriter = new StringWriter();
        htmlWriter.setWriter(new PrintWriter(stringWriter));
    }

    public void testWriteSingleExpression() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();
        expressionsAndResults.put("2 + 2", 4.0);

        htmlWriter.write(expressionsAndResults);

        String expectedOutput = "<html><head></head><body><p>2+2=4.0</p></body></html>";
        String actualOutput = stringWriter.toString().replaceAll("\\s+", "").trim();

        assertEquals(expectedOutput, actualOutput);
    }

    public void testWriteMultipleExpressions() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();
        expressionsAndResults.put("2 + 2", 4.0);
        expressionsAndResults.put("3 * 3", 9.0);

        htmlWriter.write(expressionsAndResults);

        String expectedOutput = "<html><head></head><body><p>2+2=4.0</p><p>3*3=9.0</p></body></html>";
        String actualOutput = stringWriter.toString().replaceAll("\\s+", "").trim();

        assertEquals(expectedOutput, actualOutput);
    }

    public void testWriteEmptyMap() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();

        htmlWriter.write(expressionsAndResults);

        String expectedOutput = "<html><head></head><body></body></html>";
        String actualOutput = stringWriter.toString().replaceAll("\\s+", "").trim(); 
        assertEquals(expectedOutput, actualOutput);
    }

    public void testWriteMixedContent() throws Exception {
        HashMap<String, Double> expressionsAndResults = new HashMap<>();
        expressionsAndResults.put("var1+10", 10.0);
        expressionsAndResults.put("var2-20", 20.0);
        expressionsAndResults.put("var3+30", 30.0);

        htmlWriter.write(expressionsAndResults);

        String expectedOutput = "<html><head></head><body>" +
                "<p>var1+10=10.0</p>" +
                "<p>var2-20=20.0</p>" +
                "<p>var3+30=30.0</p>" +
                "</body></html>";
        String actualOutput = stringWriter.toString().replaceAll("\\s+", "").trim();

        assertEquals(expectedOutput, actualOutput);
    }
}

