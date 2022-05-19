package datageneratorv2.persistance;

import java.util.List;

public class Table {
	private Integer amountOfRows;
	private Integer amountOfBadRows;
	private List<Column> columns;
	
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

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
	public Table(List<Column> columns) {
		this(columns, 0, 0);
	}

	public Table(List<Column> columns, Integer amountOfRows, Integer amountOfBadRows) {
		this.columns = columns;
		this.amountOfRows = amountOfRows;
		this.amountOfBadRows = amountOfBadRows;
	}	
	
}
