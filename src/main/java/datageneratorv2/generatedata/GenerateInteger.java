package datageneratorv2.generatedata;

import java.util.concurrent.ThreadLocalRandom;

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
	public String generateWrong() {
		String returnValue = "";
		Integer amountOfOptions = 3;
		Integer option = ThreadLocalRandom.current().nextInt(0, amountOfOptions);
		switch (option) {
		case 0:
			// Integer out of bounds
			returnValue = generateOutOfBounds();
			break;
		case 1:
			// Wrong data type
			break;
		case 2:
			break;
		default:
			break;
		}
		return returnValue;
	}

	@Override
	public String generateRight() {
		Integer randomValue = ThreadLocalRandom.current().nextInt(minIntegerAmount, maxIntegerAmount);
		return randomValue.toString();
	}
	
	public String generateOutOfBounds() {
		Integer negativeOrPositive = ThreadLocalRandom.current().nextInt(0, 2);
		if (negativeOrPositive == 0) {
			Long randomLong = ThreadLocalRandom.current().nextLong(Long.MIN_VALUE, minIntegerAmount);
			return randomLong.toString();
		}
		Long randomLong = ThreadLocalRandom.current().nextLong(maxIntegerAmount, Long.MAX_VALUE);
		return randomLong.toString();
	}
}
