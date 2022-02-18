	package com.study.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankbookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.study.s1.bankbook.BankbookDAO.";
	
	public int add(BankbookDTO bankbookDTO) {
		return sqlSession.insert(namespace+"add", bankbookDTO);
	}
	public List<BankbookDTO> list() throws Exception{
			return sqlSession.selectList(namespace+"list");
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
	
}
