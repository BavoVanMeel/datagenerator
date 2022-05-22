package datageneratorv2.persistance;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "ID")
public class IDParameters extends DataTypeParameters {
	private AtomicLong idCounter;
	private String dataTypeName;
	private Integer idStartingPoint;
	private boolean idUseDuplicates;
	private boolean idUseBelowStartingPoint;
	
	public AtomicLong getIdCounter() {
		return idCounter;
	}

	public void setIdCounter(AtomicLong idCounter) {
		this.idCounter = idCounter;
	}

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}
	
	public Integer getIdStartingPoint() {
		return idStartingPoint;
	}

	public void setIdStartingPoint(Integer idStartingPoint) {
		this.idStartingPoint = idStartingPoint;
	}

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
	
	public IDParameters() {
	}

	public IDParameters(Integer idStartingPoint, String dataTypeName, boolean idUseDuplicates, boolean idUseBelowStartingPoint) {
		this.idCounter = new AtomicLong(idStartingPoint);
		this.idStartingPoint = idStartingPoint;
		this.dataTypeName = dataTypeName;
		this.idUseDuplicates = idUseDuplicates;
		this.idUseBelowStartingPoint = idUseBelowStartingPoint;
	}
	
	public String getAndIncrementCounter() {
		if (idCounter == null) {
			this.idCounter = new AtomicLong(idStartingPoint);
		}
		String result = String.valueOf(idCounter.getAndIncrement());
		return result;
	}
	
	public String getClassName() {
		return "IDPARAMETRERS";
	}

	@Override
	public String toString() {
		return "IDParameters [idCounter=" + idCounter + ", idUseDuplicates=" + idUseDuplicates
				+ ", idUseBelowStartingPoint=" + idUseBelowStartingPoint + "]";
	}
	
}
