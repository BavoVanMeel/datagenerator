package datageneratorv2;

import datageneratorv2.filehandling.configuration.ConfigurationWriter;
import datageneratorv2.generatedata.GenerateController;
import datageneratorv2.menu.StartMenu;
import datageneratorv2.persistance.ConfigurationJson;

public class DataGenerator {

	public static void main(String[] args) {		
		StartMenu startMenu = new StartMenu();
		ConfigurationJson config = startMenu.showStartMenu();
		
		GenerateController generateController = new GenerateController();
		generateController.generateDataFile("accounts_test_data", "accounts_validation_data", config);
		
		ConfigurationWriter configurationWriter = new ConfigurationWriter();
		configurationWriter.generateConfig(config, "configuration");
	}
}
