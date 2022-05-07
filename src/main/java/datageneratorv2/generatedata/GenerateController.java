package datageneratorv2.generatedata;

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
	
	// totalBadRecords should be smaller than totalRecords
	public String generateData(Integer totalRecords, Integer totalBadRecords) {
		/*
		 * if (totalBadRecords > totalRecords) { throw new
		 * NumberOutOfBoundsException("Amount of bad records should not be " +
		 * "greater than the total amount of records."); }
		 */
		
		String returnValue = "";
		GenerateID generateID = new GenerateID();
		GenerateInteger generateInteger = new GenerateInteger(1, 5);
		GenerateString generateString = new GenerateString(50);
		for (int i = 0; i < (totalRecords - totalBadRecords); i++) {
			for (Heading heading : headings) {
				switch (heading.getHighestHeadingDataType().getName()) {
				case "ID":
					returnValue += generateID.generateRight() + ", ";
					break;
				case "Integer":
					returnValue += generateInteger.generateRight() + ", ";
					break;
				case "String":
					returnValue += generateString.generateRight() + ", ";
					break;
				default:
				}
			}
			returnValue += "\n";
		}
		
		for (int i = 0; i < totalBadRecords; i++) {
			for (Heading heading : headings) {
				switch (heading.getHighestHeadingDataType().getName()) {
				case "ID":
					returnValue += generateID.generateRight() + ", ";
					break;
				case "Integer":
					returnValue += generateInteger.generateWrong() + ", ";
					break;
				case "String":
					returnValue += generateString.generateWrong() + ", ";
					break;
				default:
				}
			}
			returnValue += "\n";
		}
		return returnValue;
	}

}
