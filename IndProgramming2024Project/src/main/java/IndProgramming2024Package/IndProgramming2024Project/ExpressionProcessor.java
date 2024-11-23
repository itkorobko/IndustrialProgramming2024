package IndProgramming2024Package.IndProgramming2024Project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ExpressionProcessor {
	
	protected ArrayList<String> list_of_operands=new ArrayList<String>();
    protected String source_line;
    protected String line_in_OPZ;  
    
    
    
    
   public HashMap<String,String> processLineWithValue(String line_with_value) throws Exception {
			String temp_var="";
			String temp_value="";
			HashMap<String, String> var_and_value=new HashMap<>(1);
			boolean ravno_index=false;
			for(int i=0; i<line_with_value.length();i++) {
				if(line_with_value.charAt(i)=='=') {
					ravno_index=true;
					continue;
				}
				if(!ravno_index)
				    temp_var+=line_with_value.charAt(i);
				else temp_value+=line_with_value.charAt(i);
			}
			if(!temp_var.isEmpty() && !temp_value.isEmpty())
			    var_and_value.put(temp_var, temp_value);
			else throw new Exception("Incorrect expresion!!!!");
			return var_and_value;
	}
    
     
    public double calculateLineWithExpression(String line_with_expression, HashMap<String,String> vars_and_values)throws Exception{
    	this.source_line=line_with_expression;
    	makeListOfOperands();
    	for(int i=0;i<list_of_operands.size();i++) {
				if(vars_and_values.get(list_of_operands.get(i))!=null)
					list_of_operands.set(i, vars_and_values.get(list_of_operands.get(i)));
			
		}
    	makeOPZ();
    	return calculateOPZ();
    	
    }


    protected void makeListOfOperands() {
    	for(int i=0;i<source_line.length();i++) {
    		TemporarySymbol sym=new TemporarySymbol();
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
    
    protected String makeOPZ() throws Exception {
    	String opz_string="";
    	Stack<Character> st=new Stack<Character>();
    	int i1=0;
        for(int i=0;i<source_line.length();i++){
        	TemporarySymbol sym=new TemporarySymbol();
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
        		    TemporarySymbol stack_peek_symbol=new TemporarySymbol();
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
    
    protected double calculateOPZ() throws Exception{
		TemporarySymbol sym=new TemporarySymbol();
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
