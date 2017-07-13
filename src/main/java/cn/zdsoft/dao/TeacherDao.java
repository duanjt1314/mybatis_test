package cn.zdsoft.dao;

import cn.zdsoft.domain.Teacher;

/**
 * 定义接口，通过动态代理的方式查询，这样就不用写具体的实现类了，但是需要按照一定的规范来
 * @author 段江涛
 * @date 2017-07-13
 */
public interface TeacherDao {
	public Teacher findById(int id);
}
