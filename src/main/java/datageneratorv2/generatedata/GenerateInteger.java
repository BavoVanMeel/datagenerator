package datageneratorv2.generatedata;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateInteger implements GenerateData {
	private Integer maxIntegerAmount;
	private Integer minIntegerAmount;
	
	public GenerateInteger() {
		this(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public GenerateInteger(Integer minIntegerAmount, Integer maxIntegerAmount) {
		this.minIntegerAmount = minIntegerAmount;
		this.maxIntegerAmount = maxIntegerAmount;
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
			returnValue = generateWrongDataType();
			break;
		case 2:
			// NULL 
			returnValue = null;
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
	
	public String generateWrongDataType() {
		String result = "";
		Integer amountOfOptions = 1;
		Integer option = ThreadLocalRandom.current().nextInt(0, amountOfOptions);
		switch (option) {
		case 0:
			GenerateString generateString = new GenerateString(10);
			result = generateString.generateRandomString(10);
			break;
		case 1:
			result = generateDouble(1, 2);
			break;
		}
		return result;
	}
	
	public String generateDouble(Integer amountOfPositiveCharacters, Integer amountOfDecimals) {
		Double positive = ThreadLocalRandom.current().nextDouble(0, amountOfPositiveCharacters);
		Double decimal = ThreadLocalRandom.current().nextDouble(amountOfDecimals, 0);
		Double result = positive + decimal;
		return result.toString();
	}
	
}
