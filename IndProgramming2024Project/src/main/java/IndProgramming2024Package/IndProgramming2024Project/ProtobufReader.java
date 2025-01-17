package IndProgramming2024Package.IndProgramming2024Project;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import IndProgramming2024Package.IndProgramming2024Project.Hehe.Expressions;
import IndProgramming2024Package.IndProgramming2024Project.Hehe.VarsAndValues;

public class ProtobufReader implements MyFileReader {

	private String filename;
	public void setFilename(String filename) {
		this.filename=filename;
	}
	 @Override
     public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception {
		 if(true) {
	     		//makeBinProtobuf();  Here is just an example of function, should be the other realization
			    FileOutputStream expressions_stream = new FileOutputStream("expressions.bin");
				FileOutputStream vars_and_values_stream = new FileOutputStream("vars_and_values.bin");
				ByteArrayOutputStream byte_expressions_stream = new ByteArrayOutputStream();
				ByteArrayOutputStream byte_vars_and_values_stream = new ByteArrayOutputStream();
				Expressions.Builder expressions_builder=Expressions.newBuilder();
				VarsAndValues.Builder vars_and_values_builder=VarsAndValues.newBuilder();
				expressions_builder.addExpression("be+ba-8");
				expressions_builder.addExpression("(goga+boba)/12");
				vars_and_values_builder.putVarsAndValues("be",15);
				vars_and_values_builder.putVarsAndValues("ba",18);
				vars_and_values_builder.putVarsAndValues("goga",4);
				vars_and_values_builder.putVarsAndValues("boba",16);
				
				VarsAndValues vars_and_values_message=vars_and_values_builder.build();
				vars_and_values_message.writeTo(byte_vars_and_values_stream);
			
				Expressions expressions_message=expressions_builder.build();
				expressions_message.writeTo(byte_expressions_stream);
				byte_vars_and_values_stream.writeTo(vars_and_values_stream);
				byte_expressions_stream.writeTo(expressions_stream);
				//////the end of function
			}
			FileInputStream expressions_stream = new FileInputStream("expressions.bin"); 
			if(expressions_stream!=null) {
				Expressions expressions_message =Expressions.parseFrom(expressions_stream);
				
				for(int i=0;i<expressions_message.getExpressionCount();i++) {
					lines_with_expression.add(expressions_message.getExpression(i));
				}
			}
	        FileInputStream vars_and_values_stream = new FileInputStream("vars_and_values.bin"); 	
			if(vars_and_values_stream!=null) {
				VarsAndValues vars_and_values_message= VarsAndValues.parseFrom(vars_and_values_stream);
				
				for(Map.Entry<String,Double> entry : vars_and_values_message.getVarsAndValuesMap().entrySet()) {
					vars_and_values.put(entry.getKey(), entry.getValue().toString());
				}
			}
	 }

	 
}
 