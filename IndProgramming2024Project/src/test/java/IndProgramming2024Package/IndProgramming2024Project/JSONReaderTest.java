package IndProgramming2024Package.IndProgramming2024Project;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.TestCase;
import readersAndWriters.JSONInputProcessor;
public class JSONReaderTest extends TestCase {
 private JSONInputProcessor jsonReader;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        jsonReader = new JSONInputProcessor();
    }

    public void testReadWithStringValues() throws Exception {
        String jsonContent = "{\"key1\":\"value1\", \"key2\":\"value2\"}";
        jsonReader.setContent(jsonContent);
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();
        jsonReader.processInput(linesWithExpression, varsAndValues);
        assertEquals(2, linesWithExpression.size());
        assertEquals("value1", linesWithExpression.get(0));
        assertEquals("value2", linesWithExpression.get(1));
        assertEquals(0, varsAndValues.size());
    }

  
    public void testReadWithEmptyJSON() throws Exception {
        String jsonContent = "{}";
        jsonReader.setContent(jsonContent);
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();
        jsonReader.processInput(linesWithExpression, varsAndValues);
        assertEquals(0, linesWithExpression.size());
        assertEquals(0, varsAndValues.size());
    }

    public void testReadWithInvalidDataTypes() throws Exception {
        String jsonContent = "{\"key1\":[1, 2, 3], \"key2\":{\"nestedKey\":\"value\"}}";
        jsonReader.setContent(jsonContent);
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();
        jsonReader.processInput(linesWithExpression, varsAndValues);
        assertEquals(0, linesWithExpression.size());
        assertEquals(0, varsAndValues.size());
    }
	
}
