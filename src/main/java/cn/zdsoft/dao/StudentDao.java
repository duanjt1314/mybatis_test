package cn.zdsoft.dao;

import java.io.IOException;
import java.util.List;

import cn.zdsoft.common.DBHelper;
import cn.zdsoft.common.LogHelper;
import cn.zdsoft.domain.Student;

public class StudentDao {
	/**
	 * 根据学生编码查询学生信息
	 * 
	 * @param id
	 * @return
	 */
	public Student getById(int id) {
		Student stu = null;
		try {
			stu = DBHelper.getSession().selectOne("cn.zdsoft.mapping.StudentMapper.getStudent", id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	/**
	 * 查找所有用户
	 * 
	 * @return
	 */
	public List<Student> getAll() {
		List<Student> list = null;
		try {
			list = DBHelper.getSession().selectList("cn.zdsoft.mapping.StudentMapper.getAll");
		} catch (IOException e) {
			LogHelper.logger.error("获取所有学生出错", e);
		}
		return list;
	}

	/**
	 * 查找
	 * 
	 * @param stu
	 * @return
	 */
	public List<Student> getByWhere(Student stu) {
		List<Student> list = null;
		try {
			list = DBHelper.getSession().selectList("cn.zdsoft.mapping.StudentMapper.getByWhere", stu);
		} catch (IOException e) {
			LogHelper.logger.error("获取学生出错", e);
		}
		return list;
	}

	/**
	 * 根据名称查询学生信息
	 * 
	 * @param name
	 * @return
	 */
	public List<Student> getByName(String name) {
		List<Student> list = null;
		try {
			list = DBHelper.getSession().selectList("cn.zdsoft.mapping.StudentMapper.getByName", name);
		} catch (IOException e) {
			LogHelper.logger.error("根据名称查询学生信息出错", e);
		}
		return list;
	}

	/**
	 * 获得用户编码的最大值
	 * @return
	 */
	public int getMaxId(){
		try {
			int result = DBHelper.getSession().selectOne("cn.zdsoft.mapping.StudentMapper.getMaxId");
			return result;
		} catch (IOException e) {
			LogHelper.logger.error("新增学生出错", e);
		}
		return 0;
	}
	
	/**
	 * 新增用户
	 * 
	 * @param stu
	 * @return
	 */
	public boolean insert(Student stu) {
		try {
			int result = DBHelper.getSession(true).insert("cn.zdsoft.mapping.StudentMapper.add", stu);
			return result > 0;
		} catch (IOException e) {
			LogHelper.logger.error("新增学生出错", e);
		}
		return false;
	}

	/**
	 * 修改
	 * 
	 * @param stu
	 * @return
	 */
	public boolean update(Student stu) {
		try {
			int result = DBHelper.getSession(true).update("cn.zdsoft.mapping.StudentMapper.update", stu);
			return result > 0;
		} catch (IOException e) {
			LogHelper.logger.error("修改学生出错", e);
		}
		return false;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		try {
			int result = DBHelper.getSession(true).delete("cn.zdsoft.mapping.StudentMapper.delete", id);
			return result > 0;
		} catch (IOException e) {
			LogHelper.logger.error("删除学生出错", e);
		}
		return false;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public boolean deleteMore(int[] ids){
		try {
			int result = DBHelper.getSession(true).delete("cn.zdsoft.mapping.StudentMapper.deleteMore", ids);
			return result > 0;
		} catch (IOException e) {
			LogHelper.logger.error("删除学生出错", e);
		}
		return false;
	}
	
	public List<Student> getStudentAndTeacher(){
		List<Student> list=null;
		try {
			list = DBHelper.getSession().selectList("cn.zdsoft.mapping.StudentMapper.getStudentAndTeacher");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
