package datageneratorv2.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Heading {
	static final float PERCENTAGE = 0.90f;
	
	private String headingName;
	private List<HeadingDataType> headingDateType;
	
	public Heading(String headingName) {
		this.headingName = headingName;
		headingDateType = new ArrayList<HeadingDataType>();
	}
	
	public String getHeadingName() {
		return headingName;
	}

	public void setHeadingName(String headingName) {
		this.headingName = headingName;
	}
	
	public void addHeadingDataType(HeadingDataType hdt) {
		headingDateType.add(hdt);
	}

	public List<HeadingDataType> getHeadingDateTypes() {
		return headingDateType;
	}
	
	public HeadingDataType getHeadingDataType(String headingDataTypeName) {
		for (HeadingDataType hdt : headingDateType) {
			if (hdt.getName() == headingDataTypeName) {
				return hdt;
			}
		}
		return null;
	}
	
	public boolean containsHeadingDataType(String headingDataTypeName) {
		if (headingDateType.isEmpty()) {
			return false;
		}
		for (HeadingDataType hdt : headingDateType) {
			if (hdt.getName() == headingDataTypeName) {
				return true;
			}
		}
		return false;
	}
	
	public HeadingDataType getHighestHeadingDataType() {
		HeadingDataType headingDataType = new HeadingDataType("Error");
		Integer total = 0;
		for (HeadingDataType hdt : headingDateType) {
			total += hdt.getCount();
		}
		for (HeadingDataType hdt : headingDateType) {
			if (hdt.getCount() / (float) total >= PERCENTAGE) {
				headingDataType = hdt;
			}
		}
		return headingDataType;
	}

	@Override
	public String toString() {
		String dataTypes = null;
		for (HeadingDataType hdt : headingDateType) {
			dataTypes += hdt.toString();
		}
		return "Heading [headingName= " + headingName + ", headingDateType= " + dataTypes + "] with highest datatype: " + getHighestHeadingDataType().toString();
	}
	
}
