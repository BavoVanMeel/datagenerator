package datageneratorv2.generatedata;

import java.util.ArrayList;
import java.util.List;

import datageneratorv2.datatypes.Heading;
import datageneratorv2.filehandling.CSVHandler;
import datageneratorv2.persistance.Column;
import datageneratorv2.persistance.IDParameters;
import datageneratorv2.persistance.IntegerParameters;
import datageneratorv2.persistance.StringParameters;
import datageneratorv2.persistance.Table;

public class GenerateController {
	private List<Heading> headings;
	
	public GenerateController(List<Heading> headings) {
		this.headings = headings;
	}
	
	// Methodes should create file with data and return the path as a string value
	public String generateDataFile(String fileName, Table table) {
		String filePath = "src/main/resources/" + fileName + ".csv";
		List<String[]> data = generateData(table);
		CSVHandler csvHandler = new CSVHandler();
		csvHandler.writeCSV(data, ",", filePath);
		return filePath;
	}
	
	private List<String[]> generateData(Table table) {
		/*
		 * if (totalBadRecords > totalRecords) { throw new
		 * NumberOutOfBoundsException("Amount of bad records should not be " +
		 * "greater than the total amount of records."); }
		 */
		System.out.println("Generating data...");
		long start = System.nanoTime();
		List<String[]> list = new ArrayList<String[]>();
		String[] headingList = new String[headings.size()];
		for (int i = 0; i < headings.size(); i++) {
			headingList[i] = headings.get(i).getHeadingName();
		}
		list.add(headingList);
		
		List<Column> columns = table.getColumns();
		Integer totalRows = table.getAmountOfRows();
		Integer totalColumns = columns.size();
		String[][] result = new String[totalRows][totalColumns];
		for (int i = 0; i < totalColumns; i++) {
			Column column = columns.get(i);
			switch (column.getDataTypeName()) {
			case "ID":
				IDParameters idParams = (IDParameters) column.getDataTypeDetail();
				GenerateID generateID = new GenerateID(idParams);
				for (int j = 0; j < totalRows; j++) {
					result[j][i] = generateID.generateRight();
				}
				break;
			case "String":
				StringParameters stringParams = (StringParameters) column.getDataTypeDetail();
				GenerateString generateString = new GenerateString(stringParams);
				for (int j = 0; j < totalRows; j++) {
					result[j][i] = generateString.generateRight();
				}
				break;
			case "Integer":
				IntegerParameters integerParams = (IntegerParameters) column.getDataTypeDetail();
				GenerateInteger generateInteger = new GenerateInteger(integerParams);
				for (int j = 0; j < totalRows; j++) {
					result[j][i] = generateInteger.generateRight();
				}
				break;
			}
		}
		
		// Last part of 2d array to list
		for (int i = 0; i < totalRows; i++) {
			String[] row = result[i];
			list.add(row);
		}
//		GenerateID generateID = new GenerateID(1);
//		GenerateInteger generateInteger = new GenerateInteger(1, 5);
//		GenerateString generateString = new GenerateString(50);
//		GenerateDate generateDate = new GenerateDate("yyyy-MM-dd", LocalDate.of(2000, 1, 1), LocalDate.now());
//		for (int i = 0; i < (dataOptions.getAmountOfRows() - dataOptions.getAmountOfBadRows()); i++) {
//			String[] record = new String[headings.size()];
//			for (int j = 0; j < headings.size(); j++) {
//				switch (headings.get(j).getHighestHeadingDataType().getName()) {
//				case "ID":
//					record[j] = generateID.generateRight();
//					break;
//				case "Integer":
//					record[j] = generateInteger.generateRight(); 
//					break;
//				case "String":
//					record[j] = generateString.generateRight();
//					break;
//				case "Date":
//					record[j] = generateDate.generateRight();
//					break;
//				default:
//				}
//			}
//			list.add(record);
//		}
//		
//		for (int i = 0; i < (dataOptions.getAmountOfBadRows()); i++) {
//			String[] record = new String[headings.size()];
//			for (int j = 0; j < headings.size(); j++) {
//				switch (headings.get(j).getHighestHeadingDataType().getName()) {
//				case "ID":
//					record[j] = generateID.generateRight();
//					break;
//				case "Integer":
//					record[j] = generateInteger.generateWrong(); 
//					break;
//				case "String":
//					record[j] = generateString.generateWrong();
//					break;
//				default:
//				}
//			}
//			list.add(record);
//		}
		long stop = System.nanoTime();
		long timeElapsed = (stop - start) / 1000000;
		long timePerRecord = totalRows / timeElapsed;
		System.out.println("Generating complete: " + totalRows + " records in " + timeElapsed + " milliseconds.");
		System.out.println("Avarage amount of records generated per millisecond: " + timePerRecord + ".");
		return list;
	}

}
