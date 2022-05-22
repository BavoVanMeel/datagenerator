package datageneratorv2;

import java.util.List;

import datageneratorv2.datatypes.Heading;
import datageneratorv2.datatypes.ProcessInputData;
import datageneratorv2.filehandling.CSVHandler;
import datageneratorv2.filehandling.configuration.ConfigurationWriter;
import datageneratorv2.generatedata.GenerateController;
import datageneratorv2.menu.DataParametersMenu;
import datageneratorv2.menu.DataTypeMenu;
import datageneratorv2.menu.StartMenu;
import datageneratorv2.persistance.ConfigurationJson;
import datageneratorv2.persistance.Table;

public class DataGenerator {

	public static void main(String[] args) {
//		StartMenu startMenu = new StartMenu();
//		startMenu.showStartMenu();
		List<String[]> csvInput = CSVHandler.readCSV("src/main/resources/accounts_to_migrate.csv");
		List<Heading> headings = ProcessInputData.process(csvInput);
		// headings.forEach(h -> System.out.println(h));
		
		DataTypeMenu.buildChooseDataTypeMenu(headings);
		ConfigurationJson config = DataTypeMenu.updateDataTypes(headings);
		System.out.println(config.getColumns().get(0).getColumnName());
		
		DataParametersMenu dataOptionsMenu = new DataParametersMenu(config);
		config = dataOptionsMenu.getDataOptionsMenu();
		
		GenerateController generateController = new GenerateController(headings);
		generateController.generateDataFile("accounts_test_data", "accounts_validation_data", config);
		
		// ConfigurationWriter configurationWriter = new ConfigurationWriter();
//		configurationWriter.generateConfig(config, "configuration");
	}
}
