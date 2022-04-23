package datageneratorv2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import datageneratorv2.datatypes.DataType;

public class DataGenerator {

	public static void main(String[] args) {
		idk(readCSV());
		getHeading(readCSV().get(0)[0]);
	}
	
	public static List<String[]> readCSV() {
		String path = "src/main/resources/accounts_to_migrate.csv";
		File file = new File(path);
		List<String[]> lines = null;
		try {
			FileReader fileReader = new FileReader(file);
			try (CSVReader csvReader = new CSVReader(fileReader)) {
				lines = csvReader.readAll();
				// lines.forEach(l -> System.out.println(Arrays.toString(l)));
			} catch (IOException | CsvException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void idk(List<String[]> lines) {
		String[] parts = lines.get(1)[0].split(";");
		for (String p : parts) {
			String dataType = new DataType().getDataType(p);
			System.out.println(dataType);
		}
	}
	
	public static void getHeading(String heading) {
		String[] parts = heading.split(";");
		
	}

}
