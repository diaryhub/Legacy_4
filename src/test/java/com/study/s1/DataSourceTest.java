package com.study.s1;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DataSourceTest extends SuperTest{
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void connectionTest() {
		assertNotNull(dataSource);
	}

}
