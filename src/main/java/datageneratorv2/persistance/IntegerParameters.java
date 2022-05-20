package datageneratorv2.persistance;

public class IntegerParameters extends DataTypeParameters {
	private Integer minIntegerAmount;
	private Integer maxIntegerAmount;
	private boolean integerUseOutOfBounds;
	private boolean integerUseWrongDataType;
	private boolean integerUseNull;
	
	public Integer getMinIntegerAmount() {
		return minIntegerAmount;
	}
	
	public void setMinIntegerAmount(Integer minIntegerAmount) {
		this.minIntegerAmount = minIntegerAmount;
	}
	
	public Integer getMaxIntegerAmount() {
		return maxIntegerAmount;
	}
	
	public void setMaxIntegerAmount(Integer maxIntegerAmount) {
		this.maxIntegerAmount = maxIntegerAmount;
	}
	
	public boolean isIntegerUseOutOfBounds() {
		return integerUseOutOfBounds;
	}
	
	public void setIntegerUseOutOfBounds(boolean integerUseOutOfBounds) {
		this.integerUseOutOfBounds = integerUseOutOfBounds;
	}
	
	public boolean isIntegerUseWrongDataType() {
		return integerUseWrongDataType;
	}
	
	public void setIntegerUseWrongDataType(boolean integerUseWrongDataType) {
		this.integerUseWrongDataType = integerUseWrongDataType;
	}
	
	public boolean isIntegerUseNull() {
		return integerUseNull;
	}
	
	public void setIntegerUseNull(boolean integerUseNull) {
		this.integerUseNull = integerUseNull;
	}
	
	public IntegerParameters(Integer minIntegerAmount, Integer maxIntegerAmount, boolean integerUseOutOfBounds,
			boolean integerUseWrongDataType, boolean integerUseNull) {
		this.minIntegerAmount = minIntegerAmount;
		this.maxIntegerAmount = maxIntegerAmount;
		this.integerUseOutOfBounds = integerUseOutOfBounds;
		this.integerUseWrongDataType = integerUseWrongDataType;
		this.integerUseNull = integerUseNull;
	}
	
}
