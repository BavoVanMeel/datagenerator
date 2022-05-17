package datageneratorv2.filehandling.configuration;

public class DataOptions {
	private Integer amountOfRows;
	private Integer amountOfBadRows;
	private boolean stringUseEmpty;
	private boolean stringUseTooLong;
	private boolean stringUseNull;
	
	public DataOptions(Integer amountOfRows, Integer amountOfBadRows) {
		this(amountOfRows, amountOfBadRows, false, false, false);
	}

	public DataOptions(Integer amountOfRows, Integer amountOfBadRows, boolean stringUseEmpty, boolean stringUseTooLong,
			boolean stringUseNull) {
		this.amountOfRows = amountOfRows;
		this.amountOfBadRows = amountOfBadRows;
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
