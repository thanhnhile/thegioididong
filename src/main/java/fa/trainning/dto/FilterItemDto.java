package fa.trainning.dto;

public class FilterItemDto {
	private String filterKey;
    private Object value;
    private String operation;
    
	public FilterItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilterItemDto(String filterKey, Object value, String operation) {
		super();
		this.filterKey = filterKey;
		this.value = value;
		this.operation = operation;
	}
	public String getFilterKey() {
		return filterKey;
	}
	public void setFilterKey(String filterKey) {
		this.filterKey = filterKey;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
    
}
