package datageneratorv2.datatypes;

import java.util.ArrayList;
import java.util.List;

public class ProcessInputData {
	
	public static List<Heading> process(List<String[]> lines) {
		List<Heading> headings = fillHeadings(lines.get(0));
		lines.remove(0);
		
		for (String[] line : lines) {
			String[] parts = line[0].split(";");
			for (int i = 0; i < parts.length; i++) {
				String dataType = DataType.getDataType(parts[i]);
				if (!headings.get(i).containsHeadingDataType(dataType)) {
					HeadingDataType headingDataType = new HeadingDataType(dataType);
					headingDataType.setCount(1);
					headings.get(i).addHeadingDataType(headingDataType);
				} else {
					HeadingDataType headingDataType = headings.get(i).getHeadingDataType(dataType);
					headingDataType.setCount(headingDataType.getCount() + 1);
				}
			}
		}
		return headings;
	}
	
	public static List<Heading> fillHeadings(String[] heading) {
		List<Heading> headings = new ArrayList<Heading>();
		String[] parts = heading[0].split(";");
		for (String part : parts) {
			headings.add(new Heading(part));
		}
		return headings;
	}
	
	public static void buildChooseDataTypeMenu(List<Heading> headings) {
		String explanation = "This menu generates a list of all the column names and their most likely  \n" + 
				"of the input file. You can still change the datatype for each column by entering \n" + 
				"the column ID. Press enter. You will then be asked to type the correct datatype \n" + 
				"name. Press enter. You can repeat this proces for every datatype that you want to \n" + 
				"change. As long a there are 'Error' values in the datatype column, you're not able \n" + 
				"to continue. When you're satisfied, press x to continue. \n";
		System.out.println(explanation);
		System.out.format("%5s%20s%20s", "ID", "COLUMN NAME", "DATATYPE \n");
		for (int i = 0; i < headings.size(); i++) {
			System.out.format("%5d%20s%20s", i, headings.get(i).getHeadingName(), headings.get(i).getHighestHeadingDataType().getName() + "\n");
		}
	}
}
