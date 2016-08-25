package org.heartbeater.saveme.dbConnectionTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlConnectionTest {

	private static Logger logger = LoggerFactory.getLogger(MysqlConnectionTest.class);
	
	@Autowired
	DataSource ds;
	
	@Test
	public void getConnection() throws Exception{
		logger.info("get datasource : "+ds);
		
		try (Connection c = ds.getConnection()){
			logger.info("get connection : "+c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void getSqlSessionFactory() throws Exception{
		logger.info("get sqlSessionFactory : "+sqlSessionFactory);
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()){
			logger.info("get sqlSession : "+sqlSession);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void getSqlSession() throws Exception{
		logger.info("get sqlSession by autowired : "+sqlSession);
	}
	
}
