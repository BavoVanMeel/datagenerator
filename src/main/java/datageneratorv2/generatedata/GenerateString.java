package datageneratorv2.generatedata;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateString implements GenerateData {
	private Integer maxStringLength;
	
	public GenerateString(Integer maxStringLength) {
		this.maxStringLength = maxStringLength;
	}

	@Override
	public String generateWrong() {
		return "";
	}

	@Override
	public String generateRight() {
		return generateRandomString();
	}
	
	public String generateRandomString() {
		char[] alfabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZs".toCharArray();
		return generateRandomString(alfabet);
	}
	
	public String generateRandomString(char[] charset) {
		StringBuilder stringBuilder = new StringBuilder(maxStringLength);
		for (int i = 0; i < maxStringLength; i++) {
			Integer letterNumber = ThreadLocalRandom.current().nextInt(0, maxStringLength);
			char letter = charset[letterNumber];
			stringBuilder.append(letter);
		}
		return stringBuilder.toString();
	}
}
