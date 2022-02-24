package com.study.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.s1.SuperTest;
import com.study.s1.util.Pager;

public class BankbookDAOTest extends SuperTest{
	
	@Autowired
	private BankbookDAO bankbookDAO;
	//@Test
	public void check() {
		assertNotNull(bankbookDAO);
	}
	@Test
	public void listTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BankbookDTO> ar = bankbookDAO.list(pager);
		System.out.println(ar.get(0).getbookNumber());
		System.out.println(ar.get(5).getbookNumber());
		assertEquals(5,ar.size());
	}
	
	//@Test
	public void addTest() throws Exception{
		for(int i=0;i<200;i++) {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setbookName("t"+i);
		bankbookDTO.setbookContents("c"+i);
		double rate=Math.random();//0.0~1.0
		rate=rate*1000;
		int r = (int)rate;
		rate = r/100.0;
		bankbookDTO.setbookRate(rate);
		bankbookDTO.setbookSale(1);
		int result = bankbookDAO.add(bankbookDTO);
		if(i%10==0)
		Thread.sleep(1000);//1초동안 휴식
		}
//		assertEquals(1, result);
		System.out.println("insert finish");
	}
	//@Test
	public void detailTest() throws Exception{
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setbookNumber(8L);
		bankbookDTO = bankbookDAO.detail(bankbookDTO);
		assertNotNull(bankbookDTO);
	}
	//@Test
	public void deleteTest() throws Exception{
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setbookNumber(8L);
		int result = bankbookDAO.delete(bankbookDTO);
		assertEquals(1, result);
	}
	//@Test
	public void updateTest() throws Exception{
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setbookNumber(21L);
		bankbookDTO.setbookName("t2");
		bankbookDTO.setbookContents("c2");
		bankbookDTO.setbookRate(5.21);
		bankbookDTO.setbookSale(0);
		int result = bankbookDAO.update(bankbookDTO);
		assertEquals(1, result);
	}
}
