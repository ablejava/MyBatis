package com.atguigu.day03_mybaits.test1;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.atguigu.day03_mybaits.bean.User;

/*
 * mybatis快速入门
 */
public class Test {

	public static void main(String[] args) throws IOException {
		String resource = "conf.xml"; 
		// 使用类加载器加载配置文件
		InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = factory.openSession();
		// 映射文件中的标签
		String statement = "com.atguigu.day03_mybaits.test1.userMapper.getUser";
		
		User user = session.selectOne(statement, 2);
		System.out.println(user);
	}
}
