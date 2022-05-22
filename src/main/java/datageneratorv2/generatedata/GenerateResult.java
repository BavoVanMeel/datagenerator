package datageneratorv2.generatedata;

import java.util.List;

public class GenerateResult {
	private List<String[]> testData;
	private List<String[]> validationData;
	
	public List<String[]> getTestData() {
		return testData;
	}

	public void setTestData(List<String[]> testData) {
		this.testData = testData;
	}

	public List<String[]> getValidationData() {
		return validationData;
	}

	public void setValidationData(List<String[]> validationData) {
		this.validationData = validationData;
	}

	public GenerateResult(List<String[]> testData, List<String[]> validationData) {
		this.testData = testData;
		this.validationData = validationData;
	}
}
