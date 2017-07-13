package cn.zdsoft.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBHelper {
	// GC不理static
	private static SqlSessionFactory factory = null;

	public static SqlSessionFactory getSqlSessionFactory() throws IOException {
		if (factory == null) {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		return factory;
	}

	// 获得会话
	public static SqlSession getSession() throws IOException {
		return getSqlSessionFactory().openSession(true);
	}

	/**
	 * 获得得sql会话
	 * 
	 * @param isAutoCommit
	 *            是否自动提交，如果为false则需要sqlSession.commit();rollback();
	 * @return sql会话
	 * @throws IOException 
	 */
	public static SqlSession getSession(boolean isAutoCommit) throws IOException {
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
	
}
