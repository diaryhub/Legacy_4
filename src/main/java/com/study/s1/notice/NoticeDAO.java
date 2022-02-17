package com.study.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private String namespace="com.study.s1.notice.NoticeDAO.";
	
	public List<NoticeDTO> list() {
		return sqlSession.selectList(namespace+"list");
	}
	public void detail() {
		
	}
	public void add() {
		
	}
	public void delete() {
		
	}
	public void update() {
		
	}
}
