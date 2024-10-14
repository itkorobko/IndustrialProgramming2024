package IndProgramming2024Package.IndProgramming2024Project;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TemporarySymbolTest extends TestCase {

	public void testSetSymbol() {
		TemporarySymbol sym=new TemporarySymbol();
		sym.setSymbol('j');
		Assert.assertEquals('j', sym.c);
	}

	public void testGetSymbol() {
		TemporarySymbol sym=new TemporarySymbol();
		sym.c='u';
		Assert.assertEquals('u', sym.getSymbol());
	}

	public void testIsOperator() {
	    TemporarySymbol sym=new TemporarySymbol();
	    sym.c='-';
	    Assert.assertTrue(sym.isOperator());
	    sym.c='9';
	    Assert.assertTrue(!sym.isOperator());
	}

	public void testIsOperandType() {
		  TemporarySymbol sym=new TemporarySymbol();
		    sym.c='+';
		    Assert.assertTrue(!sym.isOperandType());
		    sym.c='{';
		    Assert.assertTrue(!sym.isOperandType());
		    sym.c='a';
		    Assert.assertTrue(sym.isOperandType());
	}

}
