package datageneratorv2.generatedata;

import java.util.concurrent.atomic.AtomicLong;

public class GenerateID implements GenerateData {
	/*
	 * Why AtomicLong?
	 * More threadsafe than long so better for scalling this
	 * application up.
	 */
	private AtomicLong idCounter;

	public GenerateID(Integer idCounter) {
		this.idCounter = new AtomicLong(idCounter);
	}

	@Override
	public String generateRight() {
		String s = String.valueOf(idCounter.getAndIncrement());
		return s;
	}

	@Override
	public String generateWrong() {
		return null;
	}
}
