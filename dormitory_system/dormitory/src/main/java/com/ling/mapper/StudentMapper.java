package com.ling.mapper;

import java.util.List;

import com.ling.entity.Student;

public interface StudentMapper {

	public int create(Student student);

	public int delete(Integer id);

	public int update(Student student);

	public int updateSelective(Student student);

	public List<Student> query(Student student);

	public Student detail(Integer id);
	public Student detailByName(String name);

	public int count(Student student);

	public Student login(String userName,String password);
}
