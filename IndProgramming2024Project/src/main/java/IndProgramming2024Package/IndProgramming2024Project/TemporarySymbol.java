package IndProgramming2024Package.IndProgramming2024Project;

public class TemporarySymbol {
	
    protected char c;
    
    protected void setSymbol(char future_symbol) {
    	this.c=future_symbol;
    }
    protected char getSymbol() {
    	return this.c;
    }
	protected boolean isOperator() {
		if(c=='+' || c=='-' || c=='*' || c=='/')
		    return true;
		else return false;
	}
	protected boolean isOperandType(){
		if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
			return true;
		else return false;
    }
}
