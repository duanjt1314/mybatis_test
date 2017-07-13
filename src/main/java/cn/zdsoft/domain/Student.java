package cn.zdsoft.domain;

import com.google.gson.Gson;

/**
 * 学生类
 * @author Administrator
 *
 */
public class Student {
	private int id;
	private String name;
	private int teacher_id;
	private int class_id;
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	
	
	
}
