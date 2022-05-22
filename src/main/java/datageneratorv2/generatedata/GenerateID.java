package datageneratorv2.generatedata;

import datageneratorv2.persistance.IDParameters;

public class GenerateID implements GenerateData {
	/*
	 * Why AtomicLong?
	 * More threadsafe than long so better for scalling this
	 * application up.
	 */
	private IDParameters idParams;

	public GenerateID(IDParameters idParams) {
		this.idParams = idParams;
	}

	@Override
	public String generateRight() {
		String s = String.valueOf(idParams.getAndIncrementCounter());
		return s;
	}

	@Override
	public WrongResult generateWrong() {
		return new WrongResult("", "empty");
	}
}
