package datageneratorv2.generatedata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datageneratorv2.datatypes.Heading;
import datageneratorv2.filehandling.CSVHandler;

public class GenerateController {
	private List<Heading> headings;
	
	public GenerateController(List<Heading> headings) {
		this.headings = headings;
	}
	
	// Methodes should create file with data and return the path as a string value
	// Hier al dataoptions meegeven als param en dat doorsturen naat generateData
	public String generateDataFile(List<String[]> data, String fileName) {
		String filePath = "src/main/resources/" + fileName + ".csv";
		CSVHandler csvHandler = new CSVHandler();
		csvHandler.writeCSV(data, ",", filePath);
		return filePath;
	}
	
	public List<String[]> generateData(Integer totalRecords, Integer totalBadRecords) {
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
		
		GenerateID generateID = new GenerateID();
		GenerateInteger generateInteger = new GenerateInteger(1, 5);
		GenerateString generateString = new GenerateString(50);
		GenerateDate generateDate = new GenerateDate("yyyy-MM-dd", LocalDate.of(2000, 1, 1), LocalDate.now());
		for (int i = 0; i < (totalRecords - totalBadRecords); i++) {
			String[] record = new String[headings.size()];
			for (int j = 0; j < headings.size(); j++) {
				switch (headings.get(j).getHighestHeadingDataType().getName()) {
				case "ID":
					record[j] = generateID.generateRight();
					break;
				case "Integer":
					record[j] = generateInteger.generateRight(); 
					break;
				case "String":
					record[j] = generateString.generateRight();
					break;
				case "Date":
					record[j] = generateDate.generateRight();
					break;
				default:
				}
			}
			list.add(record);
		}
		
		for (int i = 0; i < (totalBadRecords); i++) {
			String[] record = new String[headings.size()];
			for (int j = 0; j < headings.size(); j++) {
				switch (headings.get(j).getHighestHeadingDataType().getName()) {
				case "ID":
					record[j] = generateID.generateRight();
					break;
				case "Integer":
					record[j] = generateInteger.generateWrong(); 
					break;
				case "String":
					record[j] = generateString.generateWrong();
					break;
				default:
				}
			}
			list.add(record);
		}
		long stop = System.nanoTime();
		long timeElapsed = (stop - start) / 1000000;
		long timePerRecord = totalRecords / timeElapsed;
		System.out.println("Generating complete: " + totalRecords + " records in " + timeElapsed + " milliseconds.");
		System.out.println("Avarage amount of records generated per millisecond: " + timePerRecord + ".");
		return list;
	}

}
