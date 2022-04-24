package datageneratorv2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import datageneratorv2.datatypes.ProcessInputData;

public class DataGenerator {

	public static void main(String[] args) {
		ProcessInputData.process(readCSV());
	}
	
	public static List<String[]> readCSV() {
		String path = "src/main/resources/accounts_to_migrate.csv";
		File file = new File(path);
		List<String[]> lines = null;
		try {
			FileReader fileReader = new FileReader(file);
			try (CSVReader csvReader = new CSVReader(fileReader)) {
				lines = csvReader.readAll();
			} catch (IOException | CsvException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
