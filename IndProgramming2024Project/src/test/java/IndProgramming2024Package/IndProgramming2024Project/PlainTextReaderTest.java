package IndProgramming2024Package.IndProgramming2024Project;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.TestCase;
import org.mockito.Mockito;


public class PlainTextReaderTest extends TestCase {

	    private PlainTextReader plainTextReader;
	    private BufferedReader mockReader;

	    @Override
	    public void setUp() throws Exception {
	    	super.setUp();
	        plainTextReader = new PlainTextReader();
	        mockReader = Mockito.mock(BufferedReader.class);
	        plainTextReader.setBufferedReader(mockReader);
	    }

	    public void testReadWithExpressions() throws Exception {
	        ArrayList<String> linesWithExpression = new ArrayList<>();
	        HashMap<String, String> varsAndValues = new HashMap<>();
	        Mockito.when(mockReader.readLine()).thenReturn("x=5", "y=10", "z", null);
	        plainTextReader.read(linesWithExpression, varsAndValues);
	        assertEquals(1, linesWithExpression.size());
	        assertEquals("z", linesWithExpression.get(0));
	        assertEquals(2, varsAndValues.size());
	        assertEquals("5", varsAndValues.get("x"));
	        assertEquals("10", varsAndValues.get("y"));
	    }
	    
	    public void testReadWithNoExpressions() throws Exception {
	        ArrayList<String> linesWithExpression = new ArrayList<>();
	        HashMap<String, String> varsAndValues = new HashMap<>();
	        Mockito.when(mockReader.readLine()).thenReturn("just a line", "another line", null);
	        plainTextReader.read(linesWithExpression, varsAndValues);
	        assertEquals(2, linesWithExpression.size());
	        assertEquals("just a line", linesWithExpression.get(0));
	        assertEquals("another line", linesWithExpression.get(1));
	        assertEquals(0, varsAndValues.size());
	    }

}
