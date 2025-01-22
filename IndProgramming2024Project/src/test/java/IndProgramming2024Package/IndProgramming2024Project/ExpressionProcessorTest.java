package IndProgramming2024Package.IndProgramming2024Project;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.Assert;
import junit.framework.TestCase;
import readersAndWriters.ExpressionProcessor;

public class ExpressionProcessorTest extends TestCase {

	public void testProcessLineWithValue() throws Exception {
		String line1="a=8";
		ExpressionProcessor tester=new ExpressionProcessor();
		HashMap<String,String> hm1=new HashMap<>(1);
		hm1.put("a", "8");
		Assert.assertEquals(tester.processLineWithValue(line1), hm1);
	}

	public void testCalculateLineWithExpression() throws Exception {
		String line1="ab-34+c*(d-8)";
		HashMap<String,String> hm1=new HashMap<>(3);
		hm1.put("ab", "35");
		hm1.put("c", "2");
		hm1.put("d", "4");
		ExpressionProcessor tester=new ExpressionProcessor();
		double res1=tester.calculateLineWithExpression(line1, hm1);
		Assert.assertEquals(res1, -7.0);
	}

	public void testMakeListOfOperands() {
		String line1="a+b";
		ArrayList<String> ar1=new ArrayList<>();
		ar1.add("a");
		ar1.add("b");
		ExpressionProcessor tester=new ExpressionProcessor();
		tester.source_line=line1;
		tester.makeListOfOperands();
		Assert.assertEquals(ar1, tester.list_of_operands);
		
	}

	public void testMakeOPZ() throws Exception {
		String line1="a+b";
		ExpressionProcessor tester=new ExpressionProcessor();
		tester.source_line=line1;
		tester.list_of_operands.add("a");
		tester.list_of_operands.add("b");
		Assert.assertTrue(tester.makeOPZ().equals("a b + "));
	}

	public void testCalculateOPZ() throws Exception {
		String line1="5 18 + 10 4 9 + * 5 / - 3 - ";
		ExpressionProcessor tester=new ExpressionProcessor();
		tester.line_in_OPZ=line1;
		double res1=tester.calculateOPZ();
		System.out.println(res1);
		Assert.assertEquals(res1,-6.0 );
		
	}

}
