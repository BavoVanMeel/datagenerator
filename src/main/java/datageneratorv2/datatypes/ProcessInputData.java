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
}
