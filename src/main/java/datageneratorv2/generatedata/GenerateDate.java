package datageneratorv2.generatedata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateDate implements GenerateData {
	private String dateFormat;
	private LocalDate minDate;
	private LocalDate maxDate;
	
	public GenerateDate(String dateFormat) {
		this(dateFormat, LocalDate.MIN, LocalDate.now());
	}
	
	public GenerateDate(String dateFormat, LocalDate minDate, LocalDate maxDate) {
		this.dateFormat = dateFormat;
		this.minDate = minDate;
		this.maxDate = maxDate;
	}

	@Override
	public String generateRight() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
		int minDay = (int) minDate.toEpochDay();
		int maxDay = (int) maxDate.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextInt(minDay, maxDay);
		LocalDate date = LocalDate.ofEpochDay(randomDay);
		return date.format(dateFormatter);
	}

	@Override
	public String generateWrong() {
		// TODO Auto-generated method stub
		return null;
	}

}
