package IndProgramming2024Package.IndProgramming2024Project;

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import org.mockito.Mockito;
public class XMLWriterTest extends TestCase {
	 private XMLWriter xmlWriter;
	    private StringWriter stringWriter;

	    @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        xmlWriter = new XMLWriter();
	        stringWriter = new StringWriter();
	        xmlWriter.setWriter(new PrintWriter(stringWriter));
	    }

	    public void testWriteSingleExpression() throws Exception {
	        HashMap<String, Double> expressionsAndResults = new HashMap<>();
	        expressionsAndResults.put("2 + 2", 4.0);

	        xmlWriter.write(expressionsAndResults);

	        String expectedOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
	                "<expressions_and_results>\n" +
	                "    <expression_and_result>\n" +
	                "        <expression>2 + 2</expression>\n" +
	                "        <result>4.0</result>\n" +
	                "    </expression_and_result>\n" +
	                "</expressions_and_results>\n";

	        String actualOutput = stringWriter.toString().replace("\r", "").trim();
	        assertEquals(expectedOutput.trim(), actualOutput);
	    }

	    public void testWriteMultipleExpressions() throws Exception {
	        HashMap<String, Double> expressionsAndResults = new HashMap<>();
	        expressionsAndResults.put("2 + 2", 4.0);
	        expressionsAndResults.put("3 * 3", 9.0);

	        xmlWriter.write(expressionsAndResults);

	        String expectedOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
	                "<expressions_and_results>\n" +
	                "    <expression_and_result>\n" +
	                "        <expression>2 + 2</expression>\n" +
	                "        <result>4.0</result>\n" +
	                "    </expression_and_result>\n" +
	                "    <expression_and_result>\n" +
	                "        <expression>3 * 3</expression>\n" +
	                "        <result>9.0</result>\n" +
	                "    </expression_and_result>\n" +
	                "</expressions_and_results>\n";
	        String actualOutput = stringWriter.toString().replace("\r", "").trim();
	        assertEquals(expectedOutput.trim(), actualOutput);
	    }

	    public void testWriteEmptyMap() throws Exception {
	        HashMap<String, Double> expressionsAndResults = new HashMap<>();

	        xmlWriter.write(expressionsAndResults);

	        String expectedOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
	                "<expressions_and_results/>";
	        String actualOutput = stringWriter.toString().replace("\r", "").trim();
	        assertEquals(expectedOutput.trim(), actualOutput);
	    }
	}