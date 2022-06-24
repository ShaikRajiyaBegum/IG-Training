package com.hcl.service;

import java.util.List;

import com.hcl.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public Student updateStudent(Student student);

	public Student getStudent(int id);

	public List<Student> getAllStudents();

	public void deleteStudent(int id);

}
