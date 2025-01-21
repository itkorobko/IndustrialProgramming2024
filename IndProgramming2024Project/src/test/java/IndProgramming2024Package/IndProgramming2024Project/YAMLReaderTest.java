package IndProgramming2024Package.IndProgramming2024Project;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.HashMap;

public class YAMLReaderTest extends TestCase {
    private YAMLReader yamlReader;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        yamlReader = new YAMLReader();
    }

    public void testReadSingleVariable() throws Exception {
        String yamlContent = "var1: 10";
        yamlReader.setContent(yamlContent);
        
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();

        yamlReader.read(linesWithExpression, varsAndValues);

        assertEquals(1, varsAndValues.size());
        assertEquals("10", varsAndValues.get("var1"));
        assertTrue(linesWithExpression.isEmpty());
    }

    public void testReadMultipleVariables() throws Exception {
        String yamlContent = "var1: 10\nvar2: 20.5\nvar3: someValue";
        yamlReader.setContent(yamlContent);
        
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();

        yamlReader.read(linesWithExpression, varsAndValues);

        assertEquals(2, varsAndValues.size());
        assertEquals("10", varsAndValues.get("var1"));
        assertEquals("20.5", varsAndValues.get("var2"));
        assertTrue(linesWithExpression.contains("someValue"));
    }

    public void testReadNoVariables() throws Exception {
        String yamlContent = "expression1: someExpression\nexpression2: anotherExpression";
        yamlReader.setContent(yamlContent);
        
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();

        yamlReader.read(linesWithExpression, varsAndValues);

        assertTrue(varsAndValues.isEmpty());
        assertTrue(linesWithExpression.contains("someExpression"));
        assertTrue(linesWithExpression.contains("anotherExpression"));
    }

    public void testReadInvalidVariableName() throws Exception {
        String yamlContent = "1invalidVar: 1t0\nvalidVar: 20";
        yamlReader.setContent(yamlContent);
        
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();

        yamlReader.read(linesWithExpression, varsAndValues);

        assertEquals(1, varsAndValues.size());
        assertEquals("20", varsAndValues.get("validVar"));
     
    }

    public void testReadMixedContent() throws Exception {
        String yamlContent = "var1: 100\nvar2: 200.5\nexpression: someExpression";
        yamlReader.setContent(yamlContent);
        
        ArrayList<String> linesWithExpression = new ArrayList<>();
        HashMap<String, String> varsAndValues = new HashMap<>();

        yamlReader.read(linesWithExpression, varsAndValues);

        assertEquals(2, varsAndValues.size());
        assertEquals("100", varsAndValues.get("var1"));
        assertEquals("200.5", varsAndValues.get("var2"));
        assertTrue(linesWithExpression.contains("someExpression"));
    }
}

