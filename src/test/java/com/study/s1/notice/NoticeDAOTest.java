package com.study.s1.notice;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.s1.SuperTest;
import com.study.s1.util.Pager;

public class NoticeDAOTest extends SuperTest{
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void listTest() {
		Pager pager = new Pager();
		pager.setPage(5L);
		List<NoticeDTO> ar = noticeDAO.list(pager);
		assertNotNull(ar);
	}
	//@Test
	public void detailTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(21);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	@Test
	public void addTest() throws Exception {
		for(int i=0;i<300;i++) {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("title"+i);
		noticeDTO.setContents("contents"+i);
		noticeDTO.setWriter("writer");
		noticeDTO.setHit(0);
		int result = noticeDAO.add(noticeDTO);
		if(i%10==0) {
		Thread.sleep(1000);
		}
		}
//		assertNotEquals(0, result);
	}
	//@Test
	public void updateTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(21);
		noticeDTO.setTitle("title2");
		noticeDTO.setContents("contents2");
		noticeDTO.setWriter("writer2");
		noticeDTO.setHit(11);
		int result = noticeDAO.update(noticeDTO);
		assertNotEquals(0, result);
		
	}
	//@Test
	public void deleteTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1);
		int result = noticeDAO.delete(noticeDTO);
		assertNotEquals(0, result);
	}
	
	
}
