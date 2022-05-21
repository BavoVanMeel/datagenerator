package datageneratorv2.generatedata;

import java.util.concurrent.ThreadLocalRandom;

import datageneratorv2.persistance.StringParameters;

public class GenerateString implements GenerateData {
	private StringParameters stringParams;
	
	public GenerateString(StringParameters stringParams) {
		this.stringParams = stringParams;
	}
	
	@Override
	public String generateRight() {
		return generateRandomString(stringParams.getMaxStringLength());
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
			returnValue = generateRandomString(stringParams.getMaxStringLength() + 100);
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
		for (int i = 0; i < stringParams.getMaxStringLength(); i++) {
			Integer letterNumber = ThreadLocalRandom.current().nextInt(0, stringParams.getMaxStringLength());
			char letter = charset[letterNumber];
			stringBuilder.append(letter);
		}
		return stringBuilder.toString();
	}
}
