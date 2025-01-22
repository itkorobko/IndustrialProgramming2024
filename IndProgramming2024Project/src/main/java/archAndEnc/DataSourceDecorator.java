package archAndEnc;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class DataSourceDecorator implements DataSource {
	protected DataSource wrappee;

    DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void write(HashMap<String, Double> expressions_and_results) throws Exception {
        wrappee.write(expressions_and_results);
    }

    @Override
    public void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception{
         wrappee.read(lines_with_expression, vars_and_values);
    }
}
