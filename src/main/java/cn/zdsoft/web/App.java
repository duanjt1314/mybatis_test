package cn.zdsoft.web;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import cn.zdsoft.common.DBHelper;
import cn.zdsoft.common.LogHelper;
import cn.zdsoft.dao.StudentDao;
import cn.zdsoft.dao.TeacherDao;
import cn.zdsoft.domain.Student;
import cn.zdsoft.domain.Teacher;

public class App {

	public static void main(String[] args) throws IOException {
		// 获取session
		SqlSession session = DBHelper.getSession();
		// 获取mapper接口的代理对象
		TeacherDao teacherDao = session.getMapper(TeacherDao.class);
		// 调用代理对象方法
		Teacher teacher = teacherDao.findById(1);
		System.out.println(new Gson().toJson(teacher));
		// 关闭session
		session.close();
		System.out.println("新增成功");
	}

}
