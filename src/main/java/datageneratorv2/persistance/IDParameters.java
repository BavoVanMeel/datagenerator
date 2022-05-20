package datageneratorv2.persistance;

import java.util.concurrent.atomic.AtomicLong;

public class IDParameters extends DataTypeParameters {
	private AtomicLong idCounter;

	public IDParameters(Integer idCounter) {
		this.idCounter = new AtomicLong(idCounter);
	}
	
	public String getAndIncrementCounter() {
		String result = String.valueOf(idCounter.getAndIncrement());
		return result;
	}
}
