package datageneratorv2.generatedata;

public class WrongResult {
	private String value;
	private String reason;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public WrongResult(String value, String reason) {
		this.value = value;
		this.reason = reason;
	}
	
}
