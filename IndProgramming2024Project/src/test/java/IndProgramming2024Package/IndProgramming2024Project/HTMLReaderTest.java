package IndProgramming2024Package.IndProgramming2024Project;

import junit.framework.TestCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.HashMap;
import readersAndWriters.HTMLInputProcessor;
public class HTMLReaderTest extends TestCase {
    private HTMLInputProcessor htmlReader;
    private HashMap<String, String> varsAndValues;
    private ArrayList<String> linesWithExpression;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        htmlReader = new HTMLInputProcessor();
        varsAndValues = new HashMap<>();
        linesWithExpression = new ArrayList<>();
    }

    public void testReadSingleVariable() throws Exception {
        String content = "<html><body><p>var1=10</p><p>This is an expression.</p></body></html>";
        htmlReader.setContent(content);
        
        htmlReader.processInput(linesWithExpression, varsAndValues);
        
        assertEquals(1, varsAndValues.size());
        assertTrue(varsAndValues.containsKey("var1"));
        assertEquals("10", varsAndValues.get("var1"));
        assertEquals(1, linesWithExpression.size());
        assertEquals("This is an expression.", linesWithExpression.get(0));
    }

    public void testReadMultipleVariables() throws Exception {
        String content = "<html><body><p>var1=10</p><p>var2=20</p><p>This is an expression.</p></body></html>";
        htmlReader.setContent(content);
        
        htmlReader.processInput(linesWithExpression, varsAndValues);
        
        assertEquals(2, varsAndValues.size());
        assertTrue(varsAndValues.containsKey("var1"));
        assertTrue(varsAndValues.containsKey("var2"));
        assertEquals("10", varsAndValues.get("var1"));
        assertEquals("20", varsAndValues.get("var2"));
        assertEquals(1, linesWithExpression.size());
        assertEquals("This is an expression.", linesWithExpression.get(0));
    }

    public void testReadNoVariables() throws Exception {
        String content = "<html><body><p>This is an expression.</p><p>Another expression.</p></body></html>";
        htmlReader.setContent(content);
        
        htmlReader.processInput(linesWithExpression, varsAndValues);
        
        assertEquals(0, varsAndValues.size());
        assertEquals(2, linesWithExpression.size());
        assertEquals("This is an expression.", linesWithExpression.get(0));
        assertEquals("Another expression.", linesWithExpression.get(1));
    }

    public void testReadMixedContent() throws Exception {
        String content = "<html><body><p>var1=10</p><p>This is an expression.</p><p>var2=20</p></body></html>";
        htmlReader.setContent(content);
        
        htmlReader.processInput(linesWithExpression, varsAndValues);
        
        assertEquals(2, varsAndValues.size());
        assertTrue(varsAndValues.containsKey("var1"));
        assertTrue(varsAndValues.containsKey("var2"));
        assertEquals("10", varsAndValues.get("var1"));
        assertEquals("20", varsAndValues.get("var2"));
        assertEquals(1, linesWithExpression.size());
        assertEquals("This is an expression.", linesWithExpression.get(0));
    }

    public void testReadInvalidVariableFormat() throws Exception {
        String content = "<html><body><p>invalidVariable10</p><p>This is another expression.</p></body></html>";
        htmlReader.setContent(content);
        
        htmlReader.processInput(linesWithExpression, varsAndValues);
        
        assertEquals(0, varsAndValues.size());
        assertEquals(2, linesWithExpression.size());
        assertEquals("invalidVariable10", linesWithExpression.get(0));
        assertEquals("This is another expression.", linesWithExpression.get(1));
    }
}

