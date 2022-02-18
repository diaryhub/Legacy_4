package com.study.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BankbookService {
	//Controller -> Service -> DAO
	//DAO로 보내기 전에 전처리작업
	//DAO에서 return된 데이터를 Controller로 보내기 전에 후처리작업
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	//메서드는 DAO와 거의 동일
	
	//list
	
	public List<BankbookDTO> list() throws Exception{
		List<BankbookDTO> ar = bankbookDAO.list();
		return ar;
	}
	public BankbookDTO detail(BankbookDTO bankbookDTO) throws Exception{
		return bankbookDAO.detail(bankbookDTO);
	}
	
	public int add(BankbookDTO bankbookDTO) throws Exception{
		return bankbookDAO.add(bankbookDTO);
	}
	
	
}
