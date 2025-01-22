package readersAndWriters;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;



public class YAMLOutputMaker implements OutputMaker {
	private Writer writer;
	public void setWriter(Writer writer) {
		this.writer=writer;
	}
	@Override
	public void makeOutput(HashMap<String, Double> expressions_and_results) throws Exception{
		Yaml yaml = new Yaml();
	    for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
	    	    ResultPairForYAMLWriter pair_for_writing=new ResultPairForYAMLWriter();
	    	    pair_for_writing.setExpression(entry.getKey());
	    	    pair_for_writing.setResult(entry.getValue());
	            yaml.dump(pair_for_writing, writer);
	    }   
	}

}
