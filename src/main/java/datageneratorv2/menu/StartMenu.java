package datageneratorv2.menu;

import java.util.List;
import java.util.Scanner;

import datageneratorv2.datatypes.Heading;
import datageneratorv2.datatypes.ProcessInputData;
import datageneratorv2.filehandling.CSVHandler;
import datageneratorv2.filehandling.configuration.ConfigurationReader;
import datageneratorv2.filehandling.configuration.ConfigurationWriter;
import datageneratorv2.generatedata.GenerateController;
import datageneratorv2.persistance.Column;
import datageneratorv2.persistance.ConfigurationJson;

public class StartMenu {
	public static Scanner scanner = new Scanner(System.in);
	
	public ConfigurationJson showStartMenu() {
		String explanation = "\t ---------------------- \n" + "\t --- DATA GENERATOR ---  \n" + 
				"\t ---------------------- \n" + "\n" +
				"Welcome to data generator. To start, enter the number of one of the following options: \n" + 
				"\t 1. Fresh start \n" + 
				"\t 2. Load configuration";
		System.out.println(explanation);
		Integer option = readInteger();
		ConfigurationJson config = null;
		if (option == 1) {
			// Optie om inlees bestand te kiezen
			List<String[]> csvInput = CSVHandler.readCSV("src/main/resources/accounts_to_migrate.csv");
			List<Heading> headings = ProcessInputData.process(csvInput);
			DataTypeMenu dataTypeMenu = new DataTypeMenu();
			dataTypeMenu.buildChooseDataTypeMenu(headings);
			config = dataTypeMenu.updateDataTypes(headings);
			DataParametersMenu dataOptionsMenu = new DataParametersMenu(config);
			config = dataOptionsMenu.getDataOptionsMenu();
		}
		if (option == 2) {
			config = loadConfiguration();
		}
		
		// Optie om bestandstype van uitvoer te kiezen
		GenerateController generateController = new GenerateController();
		generateController.generateDataFile("accounts_test_data", "accounts_validation_data", config);
		
		if (option == 1) {
			ConfigurationWriter configurationWriter = new ConfigurationWriter();
			configurationWriter.generateConfig(config, "configuration");
		}
		return config;
	}
	
	private Integer readInteger() {
		String input = scanner.nextLine();
		Integer inputInt = 0;
		try {
			inputInt = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Not a number");
		}
		return inputInt;
	}
	
	private ConfigurationJson loadConfiguration() {
		System.out.println("Enter the filepath of the configuration file.");
		String filePath = scanner.nextLine();
		ConfigurationReader reader = new ConfigurationReader();
		ConfigurationJson config = reader.mapTable(filePath);
		return config;
	}
}
