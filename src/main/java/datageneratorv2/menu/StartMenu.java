package datageneratorv2.menu;

import java.util.Scanner;

import datageneratorv2.filehandling.configuration.ConfigurationReader;
import datageneratorv2.persistance.Column;
import datageneratorv2.persistance.ConfigurationJson;

public class StartMenu {
	public static Scanner scanner = new Scanner(System.in);
	
	public void showStartMenu() {
		String explanation = "\t ---------------------- \n" + "\t --- DATA GENERATOR ---  \n" + 
				"\t ---------------------- \n" + "\n" +
				"Welcome to data generator. To start, enter the number of one of the following options: \n" + 
				"\t 1. Fresh start \n" + 
				"\t 2. Load configuration";
		System.out.println(explanation);
		Integer option = readInteger();
		if (option == 2) {
			ConfigurationJson config = loadConfiguration();
		}
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
		for (Column column : config.getColumns()) {
			System.out.println(column.getDataTypeParameters().getClass().getSimpleName());
		}
		return config;
	}
}
