package cn.zdsoft.dao;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.google.gson.Gson;

import cn.zdsoft.common.DBHelper;
import cn.zdsoft.dao.TeacherDao;
import cn.zdsoft.domain.Teacher;

public class TeacherDaoTest {

	@Test
	public void testFindById() throws IOException {
		// 获取session
		SqlSession session = DBHelper.getSession();
		// 获取mapper接口的代理对象
		TeacherDao teacherDao = session.getMapper(TeacherDao.class);
		// 调用代理对象方法
		Teacher teacher = teacherDao.findById(1);
		System.out.println(new Gson().toJson(teacher));
		// 关闭session
		session.close();
	}

	@Test	
	public void testInsert() throws IOException {
		// 获取session
		SqlSession session = DBHelper.getSession();
		// 获取mapper接口的代理对象
		TeacherDao teacherDao = session.getMapper(TeacherDao.class);

		Teacher teacher = new Teacher();
		teacher.setName("周恩乐2");

		// 调用代理对象方法
		int res = teacherDao.insert(teacher);
		System.out.println("结果：" + res);
		
		session.commit();
		// 关闭session
		session.close();
	}
}
