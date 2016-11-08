package com.atguigu.day03_mybaits.test3;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.atguigu.day03_mybaits.bean.User;
import com.atguigu.day03_mybaits.util.MybatisUtils;

/*
 * 测试: CRUD操作的注解的实现
 */
public class Test3 {
	
	@Test
	public void testAdd() {
		/**
		 *  如果将UserMapper.java基于注解的文件也放在test2包下，
		 *  基于注解的映射的<mapper namespace="com.atguigu.day03_mybaits.test2.userMapper">
		 *  就会和xml的文件名相同冲突
		 *  报错:类没有找到
		 */
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = factory.openSession(true);
		// 得到接口动态实现类对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1, "SS", 45));
		System.out.println(add);
		
		session.close();
	}
	
}
