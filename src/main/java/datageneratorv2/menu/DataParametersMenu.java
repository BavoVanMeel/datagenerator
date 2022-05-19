package datageneratorv2.menu;
import java.util.List;
import java.util.Scanner;

import datageneratorv2.filehandling.configuration.DataOptions;
import datageneratorv2.persistance.Column;
import datageneratorv2.persistance.StringParameters;
import datageneratorv2.persistance.Table;

public class DataParametersMenu {
	private Table table;
	public static Scanner scanner = new Scanner(System.in);
	
	public DataParametersMenu(Table table) {
		this.table = table;
	}

	public DataOptions getDataOptionsMenu() {
		Integer amountOfRows = getInteger("Enter the amount of rows");
		Integer amountOfBadRows = getInteger("Enter the amount of bad rows");
		table.setAmountOfRows(amountOfRows);
		table.setAmountOfBadRows(amountOfBadRows);
		
		List<Column> columns = table.getColumns();
		for (int i = 0; i < columns.size(); i++) {
			Column column = table.getColumns().get(i);
			switch (column.getDataTypeName()) {
			case "String":
				Integer maxStringLength = getInteger("Enter the maximum length of a string");
				boolean stringUseEmpty = getBoolean("Use empty strings? (Use 'true')");
				boolean stringUseTooLong = getBoolean("Use too long strings? (Use 'true')");
				boolean stringUseNull = getBoolean("Use null in strings? (Use 'true')");
				StringParameters stringParams = new StringParameters(maxStringLength, stringUseEmpty, stringUseTooLong, stringUseNull);
				column.setDataTypeDetail(stringParams);
				break;
			}
			boolean generateWrong = getBoolean("Should wrong data be generated for this column? (Use 'true')");
			column.setGenerateWrong(generateWrong);
		}
		
		// DataOptions dataOptions = new DataOptions(amountOfRows, amountOfBadRows, null, stringUseEmpty, stringUseTooLong, stringUseNull);
		return null;
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
