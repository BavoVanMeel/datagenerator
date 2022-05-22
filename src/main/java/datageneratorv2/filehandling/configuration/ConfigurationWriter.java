package datageneratorv2.filehandling.configuration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import datageneratorv2.persistance.Column;
import datageneratorv2.persistance.IDParameters;
import datageneratorv2.persistance.IntegerParameters;
import datageneratorv2.persistance.StringParameters;
import datageneratorv2.persistance.Table;

public class ConfigurationWriter {
	
	public void generateConfig(Table table, String fileName) {
		JSONObject configuration = new JSONObject();
        try {
			configuration.put("name", "Configuration test");
			
			// Table
			JSONObject tableConfig = new JSONObject();
			tableConfig.put("amount_of_rows", table.getAmountOfRows());
			tableConfig.put("amount_of_bad_rows", table.getAmountOfBadRows());
			
			// Column
			List<JSONObject> columnList = new ArrayList<JSONObject>();
			List<Column> columns = table.getColumns();
			for (int i = 0; i < table.getColumns().size(); i++) {
				Column column = columns.get(i);
				JSONObject columnConfig = new JSONObject();
				columnConfig.put("columnName", column.getColumnName());
				columnConfig.put("dataTypeName", column.getDataTypeName());
				
				JSONObject params = new JSONObject();
				switch (column.getDataTypeName()) {
				case "ID":
					IDParameters idParams = (IDParameters) column.getDataTypeDetail();
					params.put("idUseDuplicates", idParams.isIdUseDuplicates());
					params.put("idUseBelowStartingPoint", idParams.isIdUseBelowStartingPoint());
					break;
				case "Integer":
					IntegerParameters integerParams = (IntegerParameters) column.getDataTypeDetail();
					params.put("minIntegerAmount", integerParams.getMinIntegerAmount());
					params.put("maxIntegerAmount", integerParams.getMaxIntegerAmount());
					params.put("integerUseOutOfBounds", integerParams.isIntegerUseOutOfBounds());
					params.put("integerUseWrongDataType", integerParams.isIntegerUseWrongDataType());
					params.put("integerUseNull", integerParams.isIntegerUseNull());
					break;
				case "String":
					StringParameters stringParams = (StringParameters) column.getDataTypeDetail();
					params.put("maxStringLength", stringParams.getMaxStringLength());
					params.put("stringUseEmpty", stringParams.isStringUseEmpty());
					params.put("stringUseTooLong", stringParams.isStringUseTooLong());
					params.put("stringUseNull", stringParams.isStringUseNull());
					break;
				}
				
				columnConfig.put("params", params);
				columnConfig.put("generateWrong", column.isGenerateWrong());
				columnList.add(columnConfig);
			}
			tableConfig.put("columns", columnList);
			configuration.put("table", tableConfig);
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
