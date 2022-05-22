package datageneratorv2.persistance;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "String")
public class StringParameters extends DataTypeParameters {
	private String dataTypeName;
	private Integer maxStringLength;
	private boolean stringUseEmpty;
	private boolean stringUseTooLong;
	private boolean stringUseNull;
	
	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

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

	public StringParameters() {
	}

	public StringParameters(String dataTypeName, Integer maxStringLength, boolean stringUseEmpty, boolean stringUseTooLong,
			boolean stringUseNull) {
		this.dataTypeName = dataTypeName;
		this.maxStringLength = maxStringLength;
		this.stringUseEmpty = stringUseEmpty;
		this.stringUseTooLong = stringUseTooLong;
		this.stringUseNull = stringUseNull;
	}
	
	public String getClassName() {
		return "STRINGPARAMETRERS";
	}

	@Override
	public String toString() {
		return "StringParameters [maxStringLength=" + maxStringLength + ", stringUseEmpty=" + stringUseEmpty
				+ ", stringUseTooLong=" + stringUseTooLong + ", stringUseNull=" + stringUseNull + "]";
	}
	
}
