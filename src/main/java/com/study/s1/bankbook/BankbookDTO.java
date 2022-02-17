package com.study.s1.bankbook;

public class BankbookDTO {
	
	private Long bookNumber;
	private String bookName;
	private String bookContents;
	private Double bookRate;
	private Integer bookSale;
	public Long getbookNumber() {
		return bookNumber;
	}
	public void setbookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getbookName() {
		return bookName;
	}
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}
	public String getbookContents() {
		return bookContents;
	}
	public void setbookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	public Double getbookRate() {
		return bookRate;
	}
	public void setbookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getbookSale() {
		return bookSale;
	}
	public void setbookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	
}
