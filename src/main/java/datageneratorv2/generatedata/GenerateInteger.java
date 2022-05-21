package datageneratorv2.generatedata;

import java.util.concurrent.ThreadLocalRandom;

import datageneratorv2.persistance.IntegerParameters;
import datageneratorv2.persistance.StringParameters;

public class GenerateInteger implements GenerateData {
	private IntegerParameters integerParams;
	
	public GenerateInteger(IntegerParameters integerParams) {
		this.integerParams = integerParams;
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
		Integer randomValue = ThreadLocalRandom.current().nextInt(integerParams.getMinIntegerAmount(), integerParams.getMaxIntegerAmount());
		return randomValue.toString();
	}
	
	public String generateOutOfBounds() {
		Integer negativeOrPositive = ThreadLocalRandom.current().nextInt(0, 2);
		if (negativeOrPositive == 0) {
			Long randomLong = ThreadLocalRandom.current().nextLong(Long.MIN_VALUE, integerParams.getMinIntegerAmount());
			return randomLong.toString();
		}
		Long randomLong = ThreadLocalRandom.current().nextLong(integerParams.getMaxIntegerAmount(), Long.MAX_VALUE);
		return randomLong.toString();
	}
	
	public String generateWrongDataType() {
		String result = "";
		Integer amountOfOptions = 1;
		Integer option = ThreadLocalRandom.current().nextInt(0, amountOfOptions);
		switch (option) {
		case 0:
			GenerateString generateString = new GenerateString(new StringParameters(10, false, false, false));
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
