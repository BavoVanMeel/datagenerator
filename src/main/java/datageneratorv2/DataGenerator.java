package datageneratorv2;

import java.util.List;

import datageneratorv2.datatypes.Heading;
import datageneratorv2.datatypes.ProcessInputData;
import datageneratorv2.filehandling.CSVHandler;

public class DataGenerator {

	public static void main(String[] args) {
		List<String[]> csvInput = CSVHandler.readCSV("src/main/resources/accounts_to_migrate.csv");
		List<Heading> headings = ProcessInputData.process(csvInput);
		headings.forEach(h -> System.out.println(h));
	}
}
