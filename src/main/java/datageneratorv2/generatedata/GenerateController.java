package datageneratorv2.generatedata;

import java.util.ArrayList;
import java.util.List;

import datageneratorv2.datatypes.Heading;

public class GenerateController {
	private List<Heading> headings;
	
	public GenerateController(List<Heading> headings) {
		this.headings = headings;
	}
	
	// Methodes should create file with data and return the path as a string value
	public String generateDataFile() {
		return "";
	}
	
	public List<String[]> generateData(Integer totalRecords, Integer totalBadRecords) {
		/*
		 * if (totalBadRecords > totalRecords) { throw new
		 * NumberOutOfBoundsException("Amount of bad records should not be " +
		 * "greater than the total amount of records."); }
		 */
		List<String[]> list = new ArrayList<String[]>();
		String[] headingList = new String[headings.size()];
		for (int i = 0; i < headings.size(); i++) {
			headingList[i] = headings.get(i).getHeadingName();
		}
		list.add(headingList);
		
		GenerateID generateID = new GenerateID();
		GenerateInteger generateInteger = new GenerateInteger(1, 5);
		GenerateString generateString = new GenerateString(50);
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
		return list;
	}

}
