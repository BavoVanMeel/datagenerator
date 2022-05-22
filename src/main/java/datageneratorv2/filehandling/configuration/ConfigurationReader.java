package datageneratorv2.filehandling.configuration;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import datageneratorv2.persistance.ConfigurationJson;
import datageneratorv2.persistance.IDParameters;
import datageneratorv2.persistance.IntegerParameters;
import datageneratorv2.persistance.StringParameters;
import datageneratorv2.persistance.Table;

public class ConfigurationReader {
	ObjectMapper mapper = new ObjectMapper();
	
	public ConfigurationJson mapTable(String jsonFilePath) {
		File file = new File(jsonFilePath);
		// Table table = new Table();
		ConfigurationJson config = new ConfigurationJson();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			// objectMapper.registerSubtypes(StringParameters.class, IntegerParameters.class, IDParameters.class);
			// objectMapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
			config = objectMapper.readerFor(ConfigurationJson.class).readValue(file);
			// table = objectMapper.readValue(file, Table.class);
			System.out.println(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Table table = new Table();
		return config;
	}
}
