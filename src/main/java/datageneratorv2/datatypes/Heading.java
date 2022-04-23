package datageneratorv2.datatypes;

import java.util.List;

public class Heading {
	String headingName;
	List<HeadingDataType> headingDateType;
	
	public Heading(String headingName) {
		this.headingName = headingName;
	}
	
	public void addHeadingDataType(HeadingDataType hdt) {
		headingDateType.add(hdt);
	}

	@Override
	public String toString() {
		String dataTypes = null;
		for (HeadingDataType hdt : headingDateType) {
			dataTypes += hdt.toString();
		}
		return "Heading [headingName=" + headingName + ", headingDateType=" + dataTypes + "]";
	}
	
}
