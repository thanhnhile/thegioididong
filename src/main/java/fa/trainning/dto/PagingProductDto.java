package fa.trainning.dto;

import java.util.List;

public class PagingProductDto {
	private int currentPage;
	private int pageSize;
	private int totalPages;
	private long totalElements;
	private List<?> listDtos;
	
	
	public PagingProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PagingProductDto(int currentPage, int pageSize, int totalPages, long totalElements, List<?> listDtos) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.listDtos = listDtos;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}


	public long getTotalElements() {
		return totalElements;
	}


	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}


	public List<?> getListDtos() {
		return listDtos;
	}


	public void setListDtos(List<?> listDtos) {
		this.listDtos = listDtos;
	}


	


	


	
	
	
	
}
