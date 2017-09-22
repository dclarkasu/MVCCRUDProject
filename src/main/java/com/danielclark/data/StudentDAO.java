package com.danielclark.data;

import java.util.List;

public interface StudentDAO {
	
	public void addStudent(Student stud);
	public void removeStudent(int id);
	public Student updateStudent(Student stud, int id, String firstName, String lastName, int grade);
	public Student getStudentById(int id);
	public List<Student> getAllStudents();
	
}
