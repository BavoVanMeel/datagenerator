package datageneratorv2.filehandling.configuration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import datageneratorv2.datatypes.Heading;

public class ConfigurationWriter {
	
	public void generateConfig(List<Heading> headings) {
		JSONObject configuration = new JSONObject();
        try {
			configuration.put("name", "Configuration test");
			
			JSONObject columns = new JSONObject();
			for (int i = 0; i < headings.size(); i++) {
				Heading heading = headings.get(i);
				String key = heading.getHeadingName();
				String value = heading.getHighestHeadingDataType().getName();
				columns.put(key, value);
			}
			configuration.put("columns", columns);
		} catch (JSONException e) {
			e.printStackTrace();
		}
        writeConfiguration(configuration);
	}
	
	private void writeConfiguration(JSONObject jsonObject) {
		try (FileWriter file = new FileWriter("src/main/resources/configuration.json")) {
			file.write(jsonObject.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
