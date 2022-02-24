package com.study.s1.util;

public class Pager {
	//페이지당 보여줄 row 갯수
	private Long perPage;
	
	//페이지 번호
	private Long page;

	//시작번호
	private Long startRow;
	
	//끝번호
	private Long lastRow;
	
	//------JSP사용변수----------
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;

	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	public void makenNum(Long totalCount) {
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;	
		}
		//블럭 당 갯수
		Long perBlock=10L;
		//천체 블럭의 갯수
		Long totalBlock=totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		// page 번호로 몇번째 block인지 계산
		// 1. 1 ~ 10
		// 2. 11 ~ 20
		
		// page		BLOCK
		// 1		1
		// 2		1
		
		// 11		2
		
		Long curBlock = this.getPage()/10;
		if(this.getPage()%perBlock!=0) {
			curBlock++;
		}
		
		// curBlock으로 StartNum, lastNum 구하기
		
		startNum=(curBlock-1)*perBlock+1;
		lastNum=curBlock*perBlock;
		
		// 이전, 다음 블럭 유무
		next=false;
		if(totalBlock>curBlock) {
			next=true;
		}
		pre=false;
		if(curBlock>1) {
			pre=true;
		}
		//현재 블럭이 마지막 블럭이면 
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;	
		}
		
	}
	

	public Long getPerPage() {
		if(this.perPage==null || perPage<1) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
		if(page==null || page<1) {
			page=1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	

}
