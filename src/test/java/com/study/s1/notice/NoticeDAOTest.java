package com.study.s1.notice;


import static org.junit.Assert.assertNotEquals;
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
	//@Test
	public void detailTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	//@Test
	public void addTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("title");
		noticeDTO.setContents("contents");
		noticeDTO.setWriter("writer");
		noticeDTO.setHit(1);
		int result = noticeDAO.add(noticeDTO);
		assertNotEquals(0, result);
	}
	//@Test
	public void updateTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1);
		noticeDTO.setTitle("title2");
		noticeDTO.setContents("contents2");
		noticeDTO.setWriter("writer2");
		noticeDTO.setHit(11);
		int result = noticeDAO.update(noticeDTO);
		assertNotEquals(0, result);
		
	}
	@Test
	public void deleteTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1);
		int result = noticeDAO.delete(noticeDTO);
		assertNotEquals(0, result);
	}
	
	
}
