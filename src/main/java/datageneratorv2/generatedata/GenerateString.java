package datageneratorv2.generatedata;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateString implements GenerateData {
	private Integer maxStringLength;
	
	public GenerateString(Integer maxStringLength) {
		this.maxStringLength = maxStringLength;
	}
	
	@Override
	public String generateRight() {
		return generateRandomString(maxStringLength);
	}

	// TODO: use strange characters
	@Override
	public String generateWrong() {
		String returnValue = "";
		Integer amountOfOptions = 3;
		Integer option = ThreadLocalRandom.current().nextInt(0, amountOfOptions);
		switch (option) {
		case 0:
			// Empty
			returnValue = "";
			break;
		case 1:
			// Too long
			returnValue = generateRandomString(maxStringLength + 100);
			break;
		case 2:
			// Null
			returnValue = null;
			break;
		default:
			break;
		}
		return returnValue;
	}
	
	public String generateRandomString(Integer length) {
		char[] alfabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZs".toCharArray();
		return generateRandomString(alfabet, length);
	}
	
	public String generateRandomString(char[] charset, Integer length) {
		StringBuilder stringBuilder = new StringBuilder(length);
		for (int i = 0; i < maxStringLength; i++) {
			Integer letterNumber = ThreadLocalRandom.current().nextInt(0, maxStringLength);
			char letter = charset[letterNumber];
			stringBuilder.append(letter);
		}
		return stringBuilder.toString();
	}
}
