package datageneratorv2.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class CSVHandler {
	public static List<String[]> readCSV(String path) {
		// String path = "src/main/resources/accounts_to_migrate.csv";
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
	
	public void writeCSV(List<String[]> data, String seperator, String fileLocation) {
		File file = new File(fileLocation);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (CSVWriter csvWriter= new CSVWriter(fileWriter)) {
			csvWriter.writeAll(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
