package datageneratorv2.generatedata;

import java.util.ArrayList;
import java.util.List;

import datageneratorv2.filehandling.CSVHandler;
import datageneratorv2.persistance.Column;
import datageneratorv2.persistance.ConfigurationJson;
import datageneratorv2.persistance.IDParameters;
import datageneratorv2.persistance.IntegerParameters;
import datageneratorv2.persistance.StringParameters;

public class GenerateController {
	
	public GenerateController() {
	}
	
	// Methodes should create file with data and return the path as a string value
	public String generateDataFile(String fileNameTest, String fileNameValidation, ConfigurationJson config) {
		String filePathTest = "src/main/resources/" + fileNameTest + ".csv";
		String filePathValidation = "src/main/resources/" + fileNameValidation + ".csv";
		GenerateResult generateResult = generateData(config);
		CSVHandler csvHandler = new CSVHandler();
		csvHandler.writeCSV(generateResult.getTestData(), ",", filePathTest);
		csvHandler.writeCSV(generateResult.getValidationData(), ",", filePathValidation);
		return filePathTest;
	}
	
	private GenerateResult generateData(ConfigurationJson config) {
		/*
		 * if (totalBadRecords > totalRecords) { throw new
		 * NumberOutOfBoundsException("Amount of bad records should not be " +
		 * "greater than the total amount of records."); }
		 */
		System.out.println("Generating data...");
		long start = System.nanoTime();
		List<String[]> testData = new ArrayList<String[]>();
		List<String[]> validationData = new ArrayList<String[]>();
		List<Column> columns = config.getColumns();
		
		String[] headingList = new String[columns.size()];
		for (int i = 0; i < columns.size(); i++) {
			headingList[i] = columns.get(i).getColumnName();
		}
		testData.add(headingList);
		validationData.add(headingList);
		
		Integer totalRows = config.getAmountOfRows();
		Integer totalBadRows = config.getAmountOfBadRows();
		Integer totalColumns = columns.size();
		String[][] result = new String[totalRows][totalColumns];
		String[][] badResults = new String[totalRows][totalColumns];
		for (int i = 0; i < totalColumns; i++) {
			Column column = columns.get(i);
			switch (column.getDataTypeParameters().getClass().getSimpleName()) {
			case "IDParameters":
				IDParameters idParams = (IDParameters) column.getDataTypeParameters();
				GenerateID generateID = new GenerateID(idParams);
				for (int j = 0; j < totalRows; j++) {
					if (j < totalRows - totalBadRows) {
						String id = generateID.generateRight();
						result[j][i] = id;
						badResults[j][i] = id;
					} else {
						String id = generateID.generateRight();
						result[j][i] = id;
						badResults[j][i] = id;
						// NULL values for ID generates problems regarding usability
//						WrongResult wrongResult = generateID.generateWrong();
//						result[j][i] = wrongResult.getValue();
//						badResults[j][i] = wrongResult.getReason();
					}
				}
				break;
				// TODO: case aangepast naar klassenamen dus testen + lijn in config verwijderen
			case "StringParameters":
				StringParameters stringParams = (StringParameters) column.getDataTypeParameters();
				GenerateString generateString = new GenerateString(stringParams);
				for (int j = 0; j < totalRows; j++) {
					if (j < totalRows - totalBadRows) {
						result[j][i] = generateString.generateRight();
						badResults[j][i] = "+";
					} else {
						WrongResult wrongResult = generateString.generateWrong();
						result[j][i] = wrongResult.getValue();
						badResults[j][i] = wrongResult.getReason();
					}
				}
				break;
			case "IntegerParameters":
				IntegerParameters integerParams = (IntegerParameters) column.getDataTypeParameters();
				GenerateInteger generateInteger = new GenerateInteger(integerParams);
				for (int j = 0; j < totalRows; j++) {
					if (j < totalRows - totalBadRows) {
						result[j][i] = generateInteger.generateRight();
						badResults[j][i] = "+";
					} else {
						WrongResult wrongResult = generateInteger.generateWrong();
						result[j][i] = wrongResult.getValue();
						badResults[j][i] = wrongResult.getReason();
					}
				}
				break;
			}
		}
		
		// Convert last part of 2d array to list
		for (int i = 0; i < totalRows; i++) {
			// Testdata
			String[] rowTest = result[i];
			testData.add(rowTest);
			
			// Validation data
			String[] rowValidation = badResults[i];
			validationData.add(rowValidation);
		}
		GenerateResult generateResult = new GenerateResult(testData, validationData);
		long stop = System.nanoTime();
		long timeElapsed = (stop - start) / 1000000;
		long timePerRecord = totalRows / timeElapsed;
		System.out.println("Generating complete: " + totalRows + " records in " + timeElapsed + " milliseconds.");
		System.out.println("Avarage amount of records generated per millisecond: " + timePerRecord + ".");
		return generateResult;
	}

}
