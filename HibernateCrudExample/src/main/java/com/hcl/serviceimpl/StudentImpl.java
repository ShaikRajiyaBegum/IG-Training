package com.hcl.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hcl.model.Student;
import com.hcl.service.StudentService;
import com.hcl.util.HibernateUtil;

public class StudentImpl implements StudentService {

	// save student
	public Student saveStudent(Student student) {
		Transaction transaction = null;
		try {

			SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
			Session session = SessionFactory.openSession();

			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			// session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}
		return student;

	}

	@Override
	public Student updateStudent(Student student) {
		Transaction transaction = null;
		try {

			SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
			Session session = SessionFactory.openSession();

			transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			transaction.commit();
			// session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}
		return student;

	}

	@Override
	public Student getStudent(int id) {
		Transaction transaction = null;
		Student student = null;
		try {

			SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
			Session session = SessionFactory.openSession();

			transaction = session.beginTransaction();
			student = (Student) session.get(Student.class, id);
			transaction.commit();
			// session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}
		return student;

	}

	@Override
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try {

			SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
			Session session = SessionFactory.openSession();

			transaction = session.beginTransaction();
			students = session.createQuery("from Student").list();
			transaction.commit();
			// session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}
		return students;

	}

	@Override
	public void deleteStudent(int id) {
		Transaction transaction = null;
		Student student = null;
		try {

			SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
			Session session = SessionFactory.openSession();

			transaction = session.beginTransaction();
			student = (Student) session.get(Student.class, id);
			session.delete(student);
			transaction.commit();
			// session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}

	}

	// get student
	// get all students
	// delete student
}
