	package com.study.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.s1.util.Pager;

@Repository
public class BankbookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.study.s1.bankbook.BankbookDAO.";
	
	public int add(BankbookDTO bankbookDTO) {
		return sqlSession.insert(namespace+"add", bankbookDTO);
	}
	public List<BankbookDTO> list(Pager pager) throws Exception{
			return sqlSession.selectList(namespace+"list",pager);
		}
	public BankbookDTO detail(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.selectOne(namespace+"detail",bankbookDTO);
	}
	public int update(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.update(namespace+"update", bankbookDTO);
	}
	public int delete(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.delete(namespace+"delete", bankbookDTO);
	}
	public Long total(Pager pager) {
		return sqlSession.selectOne(namespace+"total",pager);
	}
	
}
