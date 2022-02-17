package com.study.s1.notice;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.s1.SuperTest;

public class NoticeDAOTest extends SuperTest{
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void listTest() {
		List<NoticeDTO> ar = noticeDAO.list();
		assertNotNull(ar);
	}
	public void detailTest() {
		
	}
	public void addTest() {
		
	}
	public void updateTest() {
		
	}
	public void deleteTest() {
		
	}
	
	
}
