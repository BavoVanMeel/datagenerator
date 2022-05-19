package datageneratorv2.persistance;

public class StringParameters extends DataTypeParameters {
	private Integer maxStringLength;
	private boolean stringUseEmpty;
	private boolean stringUseTooLong;
	private boolean stringUseNull;
	
	public Integer getMaxStringLength() {
		return maxStringLength;
	}

	public void setMaxStringLength(Integer maxStringLength) {
		this.maxStringLength = maxStringLength;
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

	public StringParameters(Integer maxStringLength, boolean stringUseEmpty, boolean stringUseTooLong,
			boolean stringUseNull) {
		this.maxStringLength = maxStringLength;
		this.stringUseEmpty = stringUseEmpty;
		this.stringUseTooLong = stringUseTooLong;
		this.stringUseNull = stringUseNull;
	}
	
}
