package datageneratorv2;

import java.util.List;

import datageneratorv2.datatypes.Heading;
import datageneratorv2.datatypes.ProcessInputData;
import datageneratorv2.filehandling.CSVHandler;
import datageneratorv2.generatedata.GenerateController;
import datageneratorv2.menu.DataParametersMenu;
import datageneratorv2.menu.DataTypeMenu;
import datageneratorv2.persistance.Table;

public class DataGenerator {

	public static void main(String[] args) {
		List<String[]> csvInput = CSVHandler.readCSV("src/main/resources/accounts_to_migrate.csv");
		List<Heading> headings = ProcessInputData.process(csvInput);
		// headings.forEach(h -> System.out.println(h));
		
		DataTypeMenu.buildChooseDataTypeMenu(headings);
		Table table = DataTypeMenu.updateDataTypes(headings);
		
		DataParametersMenu dataOptionsMenu = new DataParametersMenu(table);
		table = dataOptionsMenu.getDataOptionsMenu();
		
		GenerateController generateController = new GenerateController(headings);
		generateController.generateDataFile("accounts_test_data", table);
		
//		ConfigurationWriter configurationWriter = new ConfigurationWriter();
//		configurationWriter.generateConfig(headings, "configuration");
	}
}
