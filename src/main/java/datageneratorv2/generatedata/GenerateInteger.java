package datageneratorv2.generatedata;

public class GenerateInteger implements GenerateData {
	private Integer maxIntegerAmount;
	private Integer minIntegerAmount;
	
	public GenerateInteger() {
		this(Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public GenerateInteger(Integer maxIntegerAmount, Integer minIntegerAmount) {
		this.maxIntegerAmount = maxIntegerAmount;
		this.minIntegerAmount = minIntegerAmount;
	}

	@Override
	public void generateWrong() {
	}

	@Override
	public void generateRight() {
	}
}
