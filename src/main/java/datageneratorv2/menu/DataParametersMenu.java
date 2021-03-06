package datageneratorv2.menu;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import datageneratorv2.persistance.Column;
import datageneratorv2.persistance.ConfigurationJson;
import datageneratorv2.persistance.DateParameters;
import datageneratorv2.persistance.IDParameters;
import datageneratorv2.persistance.IntegerParameters;
import datageneratorv2.persistance.StringParameters;

public class DataParametersMenu {
	private ConfigurationJson config;
	public static Scanner scanner = new Scanner(System.in);
	
	public DataParametersMenu(ConfigurationJson config) {
		this.config = config;
	}

	public ConfigurationJson getDataOptionsMenu() {
		Integer amountOfRows = getInteger("Enter the amount of rows");
		Integer amountOfBadRows = getInteger("Enter the amount of bad rows");
		config.setAmountOfRows(amountOfRows);
		config.setAmountOfBadRows(amountOfBadRows);
		
		List<Column> columns = config.getColumns();
		for (int i = 0; i < columns.size(); i++) {
			Column column = config.getColumns().get(i);
			System.out.println("--- " + column.getColumnName() + " --- " + column.getDataTypeName() + " ---");
			switch (column.getDataTypeName()) {
			case "String":
				StringParameters stringParams = createStringParameters();
				column.setDataTypeParameters(stringParams);
				break;
			case "Integer":
				IntegerParameters integerParams = createIntegerParameters();
				column.setDataTypeParameters(integerParams);
				break;
			case "Date":
				DateParameters dateParameters = createDateParameters();
				column.setDataTypeParameters(dateParameters);
				break;
			case "ID":
				IDParameters idParameters = createIDParameters();
				column.setDataTypeParameters(idParameters);
			}
			boolean generateWrong = getBoolean("Should wrong data be generated for this column? (Use 'true')");
			column.setGenerateWrong(generateWrong);
		}
		
		// DataOptions dataOptions = new DataOptions(amountOfRows, amountOfBadRows, null, stringUseEmpty, stringUseTooLong, stringUseNull);
		return config;
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
		boolean inputBoolean = Boolean.parseBoolean(input);
		return inputBoolean;
	}
	
	private String getDateFormat(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		return input;
	}
	
	private LocalDate getDate(String message, String dateFormat) {
		System.out.println(message);
		String input = scanner.nextLine();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate date = LocalDate.parse(input, format);
		return date;
	}
	
	private StringParameters createStringParameters() {
		Integer maxStringLength = getInteger("Enter the maximum length of a string");
		boolean stringUseEmpty = getBoolean("Use empty strings? (Use 'true')");
		boolean stringUseTooLong = getBoolean("Use too long strings? (Use 'true')");
		boolean stringUseNull = getBoolean("Use null? (Use 'true')");
		StringParameters stringParams = new StringParameters("String", maxStringLength, stringUseEmpty, stringUseTooLong, stringUseNull);
		return stringParams;
	}
	
	private IntegerParameters createIntegerParameters() {
		Integer minIntegerAmount = getInteger("Enter the minimum length of an integer");
		Integer maxIntegerAmount = getInteger("Enter the maximum length of an integer");
		boolean integerUseOutOfBounds = getBoolean("Use out of bounds? (Use 'true')");
		boolean integerUseWrongDataType = getBoolean("Use wrong data type? (Use 'true')");
		boolean integerUseNull = getBoolean("Use null? (Use 'true')");
		IntegerParameters integerParams = new IntegerParameters("Integer", minIntegerAmount, maxIntegerAmount, integerUseOutOfBounds, 
				integerUseWrongDataType, integerUseNull);
		return integerParams;
	}
	
	private DateParameters createDateParameters() {
		String dateFormat = getDateFormat("Enter a valid date format.");
		LocalDate minDate = getDate("Enter a valid minimum date (based on the format!)", dateFormat);
		LocalDate maxDate = getDate("Enter a valid maximum date (based on the format!)", dateFormat);;
		boolean dateUseWrongFormat = getBoolean("Use wrong date format? (Use 'true')");
		boolean dateUseTooEarly = getBoolean("Use out too early? (Use 'true')");
		boolean dateUseTooLate = getBoolean("Use out too late? (Use 'true')");
		DateParameters dateParams = new DateParameters(dateFormat, minDate, maxDate, dateUseWrongFormat, dateUseTooEarly, dateUseTooLate);
		return dateParams;
	}
	
	private IDParameters createIDParameters() {
		Integer idStartingPoint = getInteger("Enter the starting point of the ID.");
		boolean idUseDuplicates = getBoolean("Use duplicate ID's? (Use 'true')");
		boolean idUseBelowStartingPoint = getBoolean("Use ID's below starting point? (Use 'true')");
		IDParameters idParams = new IDParameters(idStartingPoint, "ID", idUseDuplicates, idUseBelowStartingPoint);
		return idParams;
	}

}
