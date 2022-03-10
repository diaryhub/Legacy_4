package com.study.s1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace ="com.study.s1.member.MemberDAO.";
	
	public int join(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(namespace+"join",memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(namespace+"login",memberDTO);
	}
	
	public MemberDTO mypage(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(namespace+"mypage",memberDTO);
	}
	public int update(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(namespace+"update",memberDTO);
	}
	public int addFile(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.insert(namespace+"addFile", memberFileDTO);
	}
	
}
