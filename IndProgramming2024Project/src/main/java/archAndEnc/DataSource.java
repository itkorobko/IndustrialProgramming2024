package archAndEnc;
import java.util.ArrayList;
import java.util.HashMap;
public interface DataSource {
	public abstract void read(ArrayList<String> lines_with_expression, HashMap<String, String> vars_and_values) throws Exception;
	public abstract void write(HashMap<String, Double> expressions_and_results) throws Exception;
}
