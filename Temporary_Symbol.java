package lab1pack.Lab1_project;

public class Temporary_Symbol {
	
    private char c;
    
    void setSymbol(char future_symbol) {
    	this.c=future_symbol;
    }
    char getSymbol() {
    	return this.c;
    }
	boolean isOperator() {
		if(c=='+' || c=='-' || c=='*' || c=='/')
		    return true;
		else return false;
	}
	boolean isOperandType(){
		if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
			return true;
		else return false;
    }
}