package datageneratorv2.filehandling.configuration;

public class DataOptions {
	private Integer amountOfRows;
	private Integer amountOfBadRows;
	private Integer stringMaxLength;
	private boolean stringUseEmpty;
	private boolean stringUseTooLong;
	private boolean stringUseNull;
	
	public Integer getAmountOfRows() {
		return amountOfRows;
	}

	public void setAmountOfRows(Integer amountOfRows) {
		this.amountOfRows = amountOfRows;
	}

	public Integer getAmountOfBadRows() {
		return amountOfBadRows;
	}

	public void setAmountOfBadRows(Integer amountOfBadRows) {
		this.amountOfBadRows = amountOfBadRows;
	}

	public boolean isStringUseEmpty() {
		return stringUseEmpty;
	}

	public void setStringUseEmpty(boolean stringUseEmpty) {
		this.stringUseEmpty = stringUseEmpty;
	}

	public boolean isStringUseTooLong() {
		return stringUseTooLong;
	}

	public void setStringUseTooLong(boolean stringUseTooLong) {
		this.stringUseTooLong = stringUseTooLong;
	}

	public boolean isStringUseNull() {
		return stringUseNull;
	}

	public void setStringUseNull(boolean stringUseNull) {
		this.stringUseNull = stringUseNull;
	}

	public DataOptions(Integer amountOfRows, Integer amountOfBadRows, Integer stringMaxLength) {
		this(amountOfRows, amountOfBadRows, stringMaxLength, false, false, false);
	}

	public DataOptions(Integer amountOfRows, Integer amountOfBadRows, Integer stringMaxLength, 
			boolean stringUseEmpty, boolean stringUseTooLong, boolean stringUseNull) {
		this.amountOfRows = amountOfRows;
		this.amountOfBadRows = amountOfBadRows;
		this.stringMaxLength = stringMaxLength;
		this.stringUseEmpty = stringUseEmpty;
		this.stringUseTooLong = stringUseTooLong;
		this.stringUseNull = stringUseNull;
	}

	@Override
	public String toString() {
		return "DataOptions [amountOfRows=" + amountOfRows + ", amountOfBadRows=" + amountOfBadRows
				+ ", stringUseEmpty=" + stringUseEmpty + ", stringUseTooLong=" + stringUseTooLong + ", stringUseNull="
				+ stringUseNull + "]";
	}
	
}
