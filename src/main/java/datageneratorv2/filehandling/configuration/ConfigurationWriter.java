package datageneratorv2.filehandling.configuration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import datageneratorv2.datatypes.Heading;

public class ConfigurationWriter {
	
	public void generateConfig(List<Heading> headings, DataOptions dataOptions, String fileName) {
		JSONObject configuration = new JSONObject();
        try {
			configuration.put("name", "Configuration test");
			
			// Rows
			JSONObject rows = new JSONObject();
			rows.put("amount_of_rows", dataOptions.getAmountOfRows());
			rows.put("amount_of_bad_rows", dataOptions.getAmountOfBadRows());
			configuration.put("rows", rows);
			
			// Datatype: string
			JSONObject string = new JSONObject();
			string.put("string_use_empty", dataOptions.isStringUseEmpty());
			string.put("string_use_too_long", dataOptions.isStringUseTooLong());
			string.put("string_use_null", dataOptions.isStringUseNull());
			
			// Datatypes
			JSONObject datatypes = new JSONObject();
			datatypes.put("string", string);
			configuration.put("datatypes", datatypes);
			
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
        writeConfiguration(configuration, fileName);
	}
	
	private void writeConfiguration(JSONObject jsonObject, String fileName) {
		try (FileWriter file = new FileWriter("src/main/resources/" + fileName + ".json")) {
			file.write(jsonObject.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
