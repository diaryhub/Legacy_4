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
}
