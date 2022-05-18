package datageneratorv2.menu;

import java.util.Scanner;

import datageneratorv2.filehandling.configuration.DataOptions;

public class DataOptionsMenu {
	public static Scanner scanner = new Scanner(System.in);
	
	public DataOptions getDataOptionsMenu() {
		Integer amountOfRows = getInteger("Enter the amount of rows");
		Integer amountOfBadRows = getInteger("Enter the amount of bad rows");
		boolean stringUseEmpty = getBoolean("Use empty strings? (Use 'true')");
		boolean stringUseTooLong = getBoolean("Use too long strings? (Use 'true')");
		boolean stringUseNull = getBoolean("Use null in strings? (Use 'true')");
		DataOptions dataOptions = new DataOptions(amountOfRows, amountOfBadRows, stringUseEmpty, stringUseTooLong, stringUseNull);
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
	
	// No exception needed because everything that is not considered "true" gives the value false.
	private boolean getBoolean(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		boolean inputBoolean = false;
		inputBoolean = Boolean.parseBoolean(input);
		return inputBoolean;
	}

}
