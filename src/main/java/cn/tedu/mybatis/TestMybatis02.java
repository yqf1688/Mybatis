package cn.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.Emp;

public class TestMybatis02 {
	private SqlSession session = null;
	
	@Before
	public void testFindAll() throws IOException {
		InputStream in = Resources.getResourceAsStream("Mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
		session = fac.openSession(true);
	}
	@Test
	public void testInsert() {
		int rows = session.insert("EmpMapper.empInsert");
			System.out.println("添加成功");
	}
	@Test
	public void testUpdate() {
		int rows = session.update("EmpMaper.empUpdate");
		System.out.println("修改成功");
	}
	@Test
	public void testDelete() {
		session.delete("EmpMapper.empDelete");
		System.out.println("删除成功");
	}
	//练习5: 查询emp表中指定id的员工信息 
	@Test
	public void findAllId() {
		Emp emp =(Emp) session.selectOne("EmpMapper.findAllId", 1);
		System.out.println(emp);
	}
	//练习6：新增员工信息: 张飞 Java开发工程师 15000
	@Test
	public void empInsert02() {
		session.insert("EmpMapper.empInsert02", new Emp(null,"张飞","java开发工程师",1500.0));
		System.out.println("添加成功！!");
	}
	//修改员工信息: 张飞 架构师 25000**
	@Test
	public void empUpdate02() {
		session.update("EmpMapper.empUpdate02", new Emp("张飞","架构师",35000.0));
		System.out.println("修改成功！!");
	}
	//删除emp表中指定id的员工信息**
	@Test 
	public void empDelete02() {
		session.delete("EmpMapper.empDelete02", 3);
		System.out.println("删除成功");
	}
	/** 练习9: 动态指定要查询的列 */
	@Test
	public void testFindAll2() {
	  Map map = new HashMap();
	  //map.put("cols", "id, name");
	  //map.put("cols", "id, name, salary");
	  map.put("cols","id,name,job,salary");
	  //执行sql语句, 返回结果
	  List<Emp> list = session.selectList("EmpMapper.findAll2", map);
	  //输出结果
	  for ( Emp e : list ) {
	  	System.out.println( e );
	  }
	}
	//练习10: 根据name模糊查询emp表
	@Test
	public void findAllName() {
		
		session.selectList("");
	}
	
//	习11: 根据name模糊查询emp表
//	根据薪资查询员工信息（if标签）**
}
