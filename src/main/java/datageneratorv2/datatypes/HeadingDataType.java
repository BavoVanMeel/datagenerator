package datageneratorv2.datatypes;

public class HeadingDataType {
	String name;
	Integer count;
	
	public HeadingDataType(String name) {
		this.name = name;
		this.count = 0;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "HeadingDataType [name=" + name + ", count=" + count + "]";
	}
}
