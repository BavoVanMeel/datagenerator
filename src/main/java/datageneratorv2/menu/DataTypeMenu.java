package datageneratorv2.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import datageneratorv2.datatypes.Heading;
import datageneratorv2.datatypes.HeadingDataType;
import datageneratorv2.persistance.Column;
import datageneratorv2.persistance.Table;

public class DataTypeMenu {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void buildChooseDataTypeMenu(List<Heading> headings) {
		String explanation = "This menu generates a list of all the column names and their most likely  \n" + 
				"of the input file. You can still change the datatype for each column by entering \n" + 
				"the column ID. Press enter. You will then be asked to type the correct datatype \n" + 
				"name. Press enter. You can repeat this proces for every datatype that you want to \n" + 
				"change. As long a there are 'Error' values in the datatype column, you're not able \n" + 
				"to continue. When you're satisfied, press x to continue. \n";
		System.out.println(explanation);
		printDataTypeMenu(headings);
	}
	
	public static void printDataTypeMenu(List<Heading> headings) {
		System.out.format("%5s%20s%20s", "ID", "COLUMN NAME", "DATATYPE \n");
		for (int i = 0; i < headings.size(); i++) {
			System.out.format("%5d%20s%20s", i, headings.get(i).getHeadingName(), headings.get(i).getHighestHeadingDataType().getName() + "\n");
		}
	}
	
	public static Table updateDataTypes(List<Heading> headings) {
		String input = scanner.nextLine();
		Integer inputInt = 0;
		while (!input.equalsIgnoreCase("x")) {
			try {
				inputInt = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Not a number");
			}
			if (inputInt >= 0 && inputInt < headings.size()) {
				headings = changeDataType(headings, inputInt);
				printDataTypeMenu(headings);
			}
			input = scanner.nextLine();
		}
		// After x is pressed, create table object
		Table table = createBasicTable(headings);
		return table;
	}
	
	public static List<Heading> changeDataType(List<Heading> headings, Integer id) {
		String input = scanner.nextLine();
		String[] validInput = new String[] {"String", "Integer", "ID", "Date"};
		if (Arrays.asList(validInput).contains(input)) {
			HeadingDataType headingDataType = new HeadingDataType(input);
			headings.get(id).setHighestHeadingDataType(headingDataType);
		}
		return headings;
	}
	
	private static Table createBasicTable(List<Heading> headings) {
		List<Column> columns = new ArrayList<Column>();
		for (int i = 0; i < headings.size(); i++) {
			Heading heading = headings.get(i);
			
			String columnName = heading.getHeadingName();
			String dataTypeName = heading.getHighestHeadingDataType().getName();
			Column column = new Column(columnName, dataTypeName);
			columns.add(column);
		}
		Table table = new Table(columns);
		return table;
	}
}
