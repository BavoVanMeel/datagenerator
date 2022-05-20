package datageneratorv2.persistance;

import java.util.concurrent.atomic.AtomicLong;

public class IDParameters extends DataTypeParameters {
	private AtomicLong idCounter;
	private boolean idUseDuplicates;
	private boolean idUseBelowStartingPoint;
	
	public boolean isIdUseDuplicates() {
		return idUseDuplicates;
	}

	public void setIdUseDuplicates(boolean idUseDuplicates) {
		this.idUseDuplicates = idUseDuplicates;
	}

	public boolean isIdUseBelowStartingPoint() {
		return idUseBelowStartingPoint;
	}

	public void setIdUseBelowStartingPoint(boolean idUseBelowStartingPoint) {
		this.idUseBelowStartingPoint = idUseBelowStartingPoint;
	}

	public IDParameters(Integer idStartingPoint, boolean idUseDuplicates, boolean idUseBelowStartingPoint) {
		this.idCounter = new AtomicLong(idStartingPoint);
		this.idUseDuplicates = idUseDuplicates;
		this.idUseBelowStartingPoint = idUseBelowStartingPoint;
	}
	
	public String getAndIncrementCounter() {
		String result = String.valueOf(idCounter.getAndIncrement());
		return result;
	}
}
