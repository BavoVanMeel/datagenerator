package datageneratorv2.datatypes;

public class DataType {
	static final String DATATYPE_INTEGER = "\\d+";
	static final String DATATYPE_DOUBLE = "\\d*[.]\\d+";
	
	public String getDataType(String s) {
		if (s.matches(DATATYPE_INTEGER)) {
			return "Integer";
		}
		if (s.matches(DATATYPE_DOUBLE)) {
			return "Double";
		}
		return "String";
	}
}
