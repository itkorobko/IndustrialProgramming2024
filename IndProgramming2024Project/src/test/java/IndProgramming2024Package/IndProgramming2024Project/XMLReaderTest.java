package IndProgramming2024Package.IndProgramming2024Project;

import junit.framework.TestCase;
import readersAndWriters.XMLInputProcessor;
import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.SAXException;
public class XMLReaderTest extends TestCase {
	private XMLInputProcessor xmlReader;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        xmlReader = new XMLInputProcessor();
    }

    public void testReadExpressionsAndVariables() throws Exception {
        String xmlContent = "<root>" +
                "<expressions>" +
                "<expression>2 + 2</expression>" +
                "<expression>3 * 3</expression>" +
                "</expressions>" +
                "<vars_and_values>" +
                "<var_and_value><var>x</var><value>10</value></var_and_value>" +
                "<var_and_value><var>y</var><value>20</value></var_and_value>" +
                "</vars_and_values>" +
                "</root>";

        xmlReader.setContent(xmlContent);

        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();
        xmlReader.processInput(linesWithExpression, varsAndValues);
        assertEquals(2, linesWithExpression.size());
        assertEquals("2 + 2", linesWithExpression.get(0));
        assertEquals("3 * 3", linesWithExpression.get(1));
        assertEquals(2, varsAndValues.size());
        assertEquals("10", varsAndValues.get("x"));
        assertEquals("20", varsAndValues.get("y"));
    }

    public void testReadEmptyXML() throws Exception {
        String xmlContent = "<root></root>";
        xmlReader.setContent(xmlContent);
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();
        xmlReader.processInput(linesWithExpression, varsAndValues);
        assertTrue(linesWithExpression.isEmpty());
        assertTrue(varsAndValues.isEmpty());
    }
   
}

