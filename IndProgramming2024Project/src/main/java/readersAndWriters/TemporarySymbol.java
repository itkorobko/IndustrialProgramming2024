package readersAndWriters;

public class TemporarySymbol {
	
    public char c;
    
    public void setSymbol(char future_symbol) {
    	this.c=future_symbol;
    }
    public char getSymbol() {
    	return this.c;
    }
	public boolean isOperator() {
		if(c=='+' || c=='-' || c=='*' || c=='/')
		    return true;
		else return false;
	}
	public boolean isOperandType(){
		if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
			return true;
		else return false;
    }
}
