package com.study.s1.board.notice;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.s1.board.BoardDAO;
import com.study.s1.board.BoardDTO;
import com.study.s1.board.BoardFileDTO;
import com.study.s1.member.MemberFileDTO;
import com.study.s1.util.Pager;
@Repository
public class NoticeDAO implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.study.s1.board.notice.NoticeDAO.";

	
	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"detail", boardDTO);
	}
	
	public NoticeFileDTO detailFile(NoticeFileDTO noticeFileDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detailFile", noticeFileDTO);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	public List<NoticeFileDTO> listFile(BoardDTO boardDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"listFile",boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"add", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"delete", boardDTO);
	}

	@Override
	public Long total(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"total", pager);
	}

	@Override
	public int reply(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"addFile", boardFileDTO);
	}
	
	

}
