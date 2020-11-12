package cn.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.tedu.entity.Emp;

//Mybatis入门案例
public class TestMybatis {
	
	@Test
	public void testFindAll() throws IOException {
		InputStream in = Resources.getResourceAsStream("Mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = fac.openSession();
		List<Emp> empList = session.selectList("EmpMapper.findAll01");
		for (Emp emp : empList) {
			System.out.println(emp);
		}
	}
}
