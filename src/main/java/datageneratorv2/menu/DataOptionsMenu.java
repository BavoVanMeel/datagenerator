package datageneratorv2.menu;

import java.util.Scanner;

import datageneratorv2.filehandling.configuration.DataOptions;

public class DataOptionsMenu {
	public static Scanner scanner = new Scanner(System.in);
	
	public DataOptions getDataOptionsMenu() {
		Integer amountOfRows = getInteger("Enter the amount of rows");
		Integer amountOfBadRows = getInteger("Enter the amount of bad rows");
		DataOptions dataOptions = new DataOptions(amountOfRows, amountOfBadRows);
		return dataOptions;
	}
	
	private Integer getInteger(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		Integer inputInt = 0;
		try {
			inputInt = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Not a number");
		}
		return inputInt;
	}

}
