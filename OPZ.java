package lab1pack.Lab1_project;
import java.util.Stack;
import java.util.ArrayList;
public class OPZ {
	
	public ArrayList<String> list_of_operands=new ArrayList<String>();
    private String source_line;
    private String line_in_OPZ;  
    
    
    void setSourceLine(String future_source_line) {
    	this.source_line=future_source_line;
    }
    
    void makeListOfOperands() {
    	for(int i=0;i<source_line.length();i++) {
    		Temporary_Symbol sym=new Temporary_Symbol();
    		sym.setSymbol(source_line.charAt(i));
        	if(sym.isOperandType()){
        		String temp_operand="";
        		while(sym.isOperandType()|| sym.getSymbol()=='.'){
        			
        			temp_operand+=source_line.charAt(i);
        	        i++;
        	        if(i==source_line.length())
        	        	break;
        	        else sym.setSymbol(source_line.charAt(i));
        		
        		}
        		i--;
        		list_of_operands.add(temp_operand);
        	}
    	}
    }
    
    String makeOPZ() throws Exception {
    	String opz_string="";
    	Stack<Character> st=new Stack<Character>();
    	int i1=0;
        for(int i=0;i<source_line.length();i++){
        	Temporary_Symbol sym=new Temporary_Symbol();
    		sym.setSymbol(source_line.charAt(i));
        	if(sym.isOperandType()){
        		while(sym.isOperandType() || sym.getSymbol()=='.' ){
        	        i++;
        	        if(i==source_line.length())
        	        	break;
        	        else sym.setSymbol(source_line.charAt(i));       		
        		}
        		i--;
        		opz_string+=list_of_operands.get(i1)+" ";
        		i1++;
        	}
        	else if(sym.getSymbol()=='+' || sym.getSymbol()=='-') {
        		while(!st.isEmpty()) {
        		    Temporary_Symbol stack_peek_symbol=new Temporary_Symbol();
        		    stack_peek_symbol.setSymbol(st.peek());
        		    if(stack_peek_symbol.isOperator()) {
        		    	opz_string+=st.peek();
        		    	st.pop();
        		    }
        		    else break;
        		}
        		st.push(sym.getSymbol());
        	}
        	else if(sym.getSymbol()=='*' || sym.getSymbol()=='/') {
        		while(!st.isEmpty()) {
        		    if(st.peek()=='*' || st.peek()=='/') {
        		    	opz_string+=st.peek()+" ";
        		    	st.pop();
        		    }
        		    else break;
        		}
        		st.push(sym.getSymbol());
        	}
        	else if(sym.getSymbol()=='(')
        		st.push(sym.getSymbol());
        	else if(sym.getSymbol()==')') {
        		if(st.isEmpty()) throw new Exception("Disbalance of staples!!!");
        		while(st.peek()!='(') {
        			opz_string+=st.peek()+" ";
    		    	st.pop();
    		    	if(st.isEmpty()) throw new Exception("Disbalance of staples!!!");
        		}
        		st.pop();
        	}
        }
        while(!st.isEmpty()) {
        	if(st.peek()=='(') throw new Exception("Disbalance of staples!!!");
        	opz_string+=st.peek()+" ";
        	st.pop();
        }
        line_in_OPZ=opz_string;
    	return opz_string;
    }
    
    double calculateOPZ() throws Exception{
		Temporary_Symbol sym=new Temporary_Symbol();
		Stack<Double> st= new Stack<Double>();
		for(int i=0; i<line_in_OPZ.length(); i++) {
			sym.setSymbol(line_in_OPZ.charAt(i));
			if(line_in_OPZ.charAt(i)==' ')
				continue;
			else if(sym.isOperandType()) {
				String potential_argument="";
				while(sym.isOperandType() || sym.getSymbol()=='.') {
					potential_argument+=sym.getSymbol();
					i++;
					if(i!=line_in_OPZ.length())
					    sym.setSymbol(line_in_OPZ.charAt(i));
					
				}
				st.push(Double.parseDouble(potential_argument));
			}
			else if(sym.getSymbol()=='+') {
				if(st.isEmpty()) throw new Exception("Incorrect expresion!!!!");
				double new_element= st.peek();
				st.pop();
				if(st.isEmpty()) throw new Exception("Incorrect expresion!!!!");
				new_element+=st.peek();
				st.pop();
				st.push(new_element);
			}
            else if(sym.getSymbol()=='-') {
            	if(st.isEmpty()) throw new Exception("Incorrect expresion!!!!");
            	double new_element= st.peek();
				st.pop();
				if(st.isEmpty()) throw new Exception("Incorrect expresion!!!!");
				new_element-=st.peek();
				st.pop();
				st.push(-new_element);
			}
            else if(sym.getSymbol()=='*') {
            	if(st.isEmpty()) throw new Exception("Incorrect expresion!!!!");
            	double new_element= st.peek();
				st.pop();
				if(st.isEmpty()) throw new Exception("Incorrect expresion!!!!");
				new_element*=st.peek();
				st.pop();
				st.push(new_element);
			}
            else if(sym.getSymbol()=='/') {
            	if(st.isEmpty()) throw new Exception("Incorrect expresion!!!!");
            	double delitel= st.peek();
				st.pop();
				if(st.isEmpty()) throw new Exception("Incorrect expresion!!!!");
				double delimoe=st.peek();
				st.pop();
				st.push(delimoe/delitel);
			}				
		}	
		return st.peek();
	}
}
