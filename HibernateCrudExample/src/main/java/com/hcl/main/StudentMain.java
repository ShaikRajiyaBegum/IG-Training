package com.hcl.main;

import java.util.ArrayList;
import java.util.List;

import com.hcl.model.Student;
import com.hcl.service.StudentService;
import com.hcl.serviceimpl.StudentImpl;

public class StudentMain {

	public static void main(String[] args) {

		Student student1 = new Student("Rajiya", "Shaik", "rajiya123@gmail.com");
		Student student2 = new Student("sahithi", "sarikonda", "rajiya123@gmail.com");
		Student student3 = new Student("rani", "vemula", "rajiya123@gmail.com");
		Student student4 = new Student("sowjanya", "paani", "rajiya123@gmail.com");

		StudentService service = new StudentImpl();
		service.saveStudent(student1);
		service.saveStudent(student2);
		service.saveStudent(student3);
		service.saveStudent(student4);

		student1.setFirstName("RajiyaBegum");
		service.updateStudent(student1);

		service.getStudent(student1.getId());

		service.getAllStudents();

		service.deleteStudent(student1.getId());

	}

}
