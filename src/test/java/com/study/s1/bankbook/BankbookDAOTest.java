package com.study.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.s1.SuperTest;

public class BankbookDAOTest extends SuperTest{
	
	@Autowired
	private BankbookDAO bankbookDAO;
	@Test
	public void check() {
		assertNotNull(bankbookDAO);
	}
	@Test
	public void listTest() throws Exception{
		List<BankbookDTO> ar = bankbookDAO.list();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void addTest() throws Exception{
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setbookName("t1");
		bankbookDTO.setbookContents("c1");
		bankbookDTO.setbookRate(3.12);
		bankbookDTO.setbookSale(1);
		int result = bankbookDAO.add(bankbookDTO);
		assertEquals(1, result);
	}
	//@Test
	public void detailTest() throws Exception{
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setbookNumber(8L);
		bankbookDTO = bankbookDAO.detail(8L);
		assertNotNull(bankbookDTO);
	}
	//@Test
	public void deleteTest() throws Exception{
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setbookNumber(8L);
		int result = bankbookDAO.delete(bankbookDTO);
		assertEquals(1, result);
	}
	@Test
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
