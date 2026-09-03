package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao {

	int addStudent(Student addstudeent);
	
	int deleteStudent(int id);
	
	List<Student> findAllStudent();
	
}
