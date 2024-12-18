package IndProgramming2024Package.IndProgramming2024Project;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import IndProgramming2024Package.IndProgramming2024Project.FileProcessor.ResultPairForYAML;

public class YAMLWriter extends MyFileWriter {
	@Override
	public void write(HashMap<String, Double> expressions_and_results) throws Exception{
		Yaml yaml = new Yaml();
	    FileWriter writer = new FileWriter(filename);
	    for(Map.Entry<String, Double> entry : expressions_and_results.entrySet()) {
	    	    ResultPairForYAMLWriter pair_for_writing=new ResultPairForYAMLWriter();
	    	    pair_for_writing.setExpression(entry.getKey());
	    	    pair_for_writing.setResult(entry.getValue());
	            yaml.dump(pair_for_writing, writer);
	    }   
	}

}
