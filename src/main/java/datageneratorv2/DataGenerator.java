package datageneratorv2;

import java.util.List;

import datageneratorv2.datatypes.Heading;
import datageneratorv2.datatypes.ProcessInputData;
import datageneratorv2.filehandling.CSVHandler;
import datageneratorv2.filehandling.configuration.ConfigurationWriter;
import datageneratorv2.filehandling.configuration.DataOptions;
import datageneratorv2.generatedata.GenerateController;
import datageneratorv2.menu.DataOptionsMenu;
import datageneratorv2.menu.DataTypeMenu;

public class DataGenerator {

	public static void main(String[] args) {
		List<String[]> csvInput = CSVHandler.readCSV("src/main/resources/accounts_to_migrate.csv");
		List<Heading> headings = ProcessInputData.process(csvInput);
		// headings.forEach(h -> System.out.println(h));
		
		DataTypeMenu.buildChooseDataTypeMenu(headings);
		DataTypeMenu.updateDataTypes(headings);
		
		DataOptionsMenu dataOptionsMenu = new DataOptionsMenu();
		DataOptions dataOptions = dataOptionsMenu.getDataOptionsMenu();
		
		GenerateController generateController = new GenerateController(headings);
		generateController.generateDataFile("accounts_test_data", dataOptions);
		
		ConfigurationWriter configurationWriter = new ConfigurationWriter();
		configurationWriter.generateConfig(headings, dataOptions, "configuration");
	}
}
