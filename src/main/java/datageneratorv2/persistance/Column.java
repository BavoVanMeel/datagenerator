package datageneratorv2.persistance;

public class Column {
	private String columnName;
	private String dataTypeName;
	private DataTypeParameters dataTypeParameters;
	private boolean generateWrong;
	
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}
	
	public boolean isGenerateWrong() {
		return generateWrong;
	}

	public void setGenerateWrong(boolean generateWrong) {
		this.generateWrong = generateWrong;
	}

	public DataTypeParameters getDataTypeDetail() {
		return dataTypeParameters;
	}

	public void setDataTypeDetail(DataTypeParameters dataTypeParameters) {
		this.dataTypeParameters = dataTypeParameters;
	}
	
	public Column(String columnName, String dataTypeName) {
		this(columnName, dataTypeName, false, null);
	}

	public Column(String columnName, String dataTypeName, boolean generateWrong, DataTypeParameters dataTypeParameters) {
		this.columnName = columnName;
		this.dataTypeName = dataTypeName;
		this.generateWrong = generateWrong;
		this.dataTypeParameters = dataTypeParameters;
	}
}
