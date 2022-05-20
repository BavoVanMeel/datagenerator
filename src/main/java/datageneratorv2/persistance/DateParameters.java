package datageneratorv2.persistance;

import java.time.LocalDate;

public class DateParameters extends DataTypeParameters {
	private String dateFormat;
	private LocalDate minDate;
	private LocalDate maxDate;
	private boolean dateUseWrongFormat;
	private boolean dateUseTooEarly;
	private boolean dateUseTooLate;
	
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public LocalDate getMinDate() {
		return minDate;
	}

	public void setMinDate(LocalDate minDate) {
		this.minDate = minDate;
	}

	public LocalDate getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(LocalDate maxDate) {
		this.maxDate = maxDate;
	}

	public boolean isDateUseWrongFormat() {
		return dateUseWrongFormat;
	}

	public void setDateUseWrongFormat(boolean dateUseWrongFormat) {
		this.dateUseWrongFormat = dateUseWrongFormat;
	}

	public boolean isDateUseTooEarly() {
		return dateUseTooEarly;
	}

	public void setDateUseTooEarly(boolean dateUseTooEarly) {
		this.dateUseTooEarly = dateUseTooEarly;
	}

	public boolean isDateUseTooLate() {
		return dateUseTooLate;
	}

	public void setDateUseTooLate(boolean dateUseTooLate) {
		this.dateUseTooLate = dateUseTooLate;
	}

	public DateParameters(String dateFormat, LocalDate minDate, LocalDate maxDate, boolean dateUseWrongFormat,
			boolean dateUseTooEarly, boolean dateUseTooLate) {
		this.dateFormat = dateFormat;
		this.minDate = minDate;
		this.maxDate = maxDate;
		this.dateUseWrongFormat = dateUseWrongFormat;
		this.dateUseTooEarly = dateUseTooEarly;
		this.dateUseTooLate = dateUseTooLate;
	}
	
}
