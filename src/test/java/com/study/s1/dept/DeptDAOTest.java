package com.study.s1.dept;


import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.s1.SuperTest;

public class DeptDAOTest extends SuperTest {
	@Autowired
	private DeptDAO deptDAO;
	
	@Test
	public void listTest() throws Exception {
		List<DeptDTO> ar = deptDAO.list();
		for(int i=0;i<10;i++) {
			System.out.println(ar.get(i).getDepartment_name());
		}
		assertNotEquals(0, ar.size());
	}

}
