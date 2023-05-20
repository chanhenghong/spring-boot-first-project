package com.chanheng.stock1;

import com.chanheng.stock1.data.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Stock1ApplicationTests {
	@Autowired
	private RoleMapper roleMapper;
	@Test
	void testSelectRoles(){
		System.out.println(roleMapper.selectRole());
	}

}
