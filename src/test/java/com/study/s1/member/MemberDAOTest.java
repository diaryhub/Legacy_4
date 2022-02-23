package com.study.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.s1.SuperTest;

public class MemberDAOTest extends SuperTest{

	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void joinTest() {
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("ID");
		memberDTO.setPw("PW");
		memberDTO.setName("NAME");
		memberDTO.setEmail("@naver.com");
		memberDTO.setPhone("010-0000-0000");
		
	}
	//@Test
	public void loginTest() throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		
		
		memberDTO = memberDAO.login(memberDTO);
		
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void mypageTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		
		
		memberDTO = memberDAO.mypage(memberDTO);
		
		assertNotNull(memberDTO);
	}

}
