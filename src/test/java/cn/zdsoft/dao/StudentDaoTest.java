package cn.zdsoft.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

import cn.zdsoft.domain.Student;

public class StudentDaoTest {

	@Test
	public void testGetStudent() {
		Student stu = new StudentDao().getById(1);
		assertTrue(stu != null && stu.getName().equals("lisi"));
		System.out.println(stu);
	}

	@Test
	public void testGetAll() {
		List<Student> list = new StudentDao().getAll();
		assertTrue(list != null && list.size() > 0);
		System.out.println(new Gson().toJson(list));
	}

	@Test
	public void testGetByWhere() {
		Student stu = new Student();
		stu.setName("%重庆%");
		stu.setClass_id(1);
		List<Student> list = new StudentDao().getByWhere(stu);
		assertTrue(list != null);
		System.out.println(new Gson().toJson(list));
	}

	@Test
	public void testGetByName() {
		String name = "重庆人";
		List<Student> list = new StudentDao().getByName(name);
		assertTrue(list != null);
		System.out.println(new Gson().toJson(list));
	}

	@Test
	public void testAdd() {
		int maxId = new StudentDao().getMaxId();
		Student stu = new Student();
		stu.setId(maxId + 1);
		stu.setName("猪猪" + maxId);
		stu.setTeacher_id(1);
		stu.setClass_id(maxId);
		boolean result = new StudentDao().insert(stu);
		assertTrue(result);
		System.out.println("add success");
	}

	@Test
	public void testUpdate() {
		Student stu = new StudentDao().getById(1);
		stu.setName("重庆人");
		stu.setClass_id(1);
		System.out.println(new Gson().toJson(stu));
		boolean result = new StudentDao().update(stu);
		assertTrue(result);
		System.out.println("update success");
	}

	@Test
	public void testDelete() {
		boolean result = new StudentDao().delete(2);
		assertTrue(result);
	}
	
	@Test
	public void testDeleteMore() {
		int[] ids=new int[]{1,3};
		boolean result = new StudentDao().deleteMore(ids);
		assertTrue(result);
	}

}
