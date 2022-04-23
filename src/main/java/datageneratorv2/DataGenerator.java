package datageneratorv2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class DataGenerator {

	public static void main(String[] args) {
		System.out.println("tests");
		readCSV();
	}
	
	public static void readCSV() throws IOException, CsvValidationException {
		File file = new File("/datagenerator/src/main/resources/accounts_to_migrate.csv");
		FileReader fileReader = new FileReader(file);
		try (CSVReader reader = new CSVReader(fileReader)) {
			String[] result;
			while ((result = reader.readNext()) != null) {
				System.out.println(result[0] + " " + result[1]);
			}
		}
	}

}
