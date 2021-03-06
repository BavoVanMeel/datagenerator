package datageneratorv2.persistance;

public class Table {
	private Integer amountOfRows;
	private Integer amountOfBadRows;
	private ColumnList columns;
	
	public Integer getAmountOfRows() {
		return amountOfRows;
	}

	public void setAmountOfRows(Integer amountOfRows) {
		this.amountOfRows = amountOfRows;
	}

	public Integer getAmountOfBadRows() {
		return amountOfBadRows;
	}

	public void setAmountOfBadRows(Integer amountOfBadRows) {
		this.amountOfBadRows = amountOfBadRows;
	}

	public ColumnList getColumns() {
		return columns;
	}

	public void setColumns(ColumnList columns) {
		this.columns = columns;
	}
	
	public Table() {
	}

	public Table(ColumnList columns) {
		this(columns, 0, 0);
	}

	public Table(ColumnList columns, Integer amountOfRows, Integer amountOfBadRows) {
		this.columns = columns;
		this.amountOfRows = amountOfRows;
		this.amountOfBadRows = amountOfBadRows;
	}

//	@Override
//	public String toString() {
//		String columns = "";
//		for (Column column : this.getColumns()) {
//			columns += column.toString() + " ";
//		}
//		return "Table [amountOfRows=" + amountOfRows + ", amountOfBadRows=" + amountOfBadRows + ", columns=" + columns
//				+ "]";
//	}	
	
	
}
