package com.study.s1.notice;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.s1.util.Pager;
@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private String namespace="com.study.s1.notice.NoticeDAO.";
	
	public List<NoticeDTO> list(Pager pager) {
		return sqlSession.selectList(namespace+"list",pager);
	}
	public NoticeDTO detail(NoticeDTO notionDTO) {
		return sqlSession.selectOne(namespace+"detail",notionDTO);
	}
	public int add(NoticeDTO noticeDTO) {
		return sqlSession.insert(namespace+"add",noticeDTO);
	}
	public int delete(NoticeDTO noticeDTO) {
		return sqlSession.delete(namespace+"delete", noticeDTO);
	}
	public int update(NoticeDTO noticeDTO) {
		return sqlSession.update(namespace+"update", noticeDTO);
	}
	public Long total(Pager pager) {
		return sqlSession.selectOne(namespace+"total",pager);
	}
}
