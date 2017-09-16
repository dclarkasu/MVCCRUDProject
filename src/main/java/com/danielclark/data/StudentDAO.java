package com.danielclark.data;

import java.util.List;

public interface StudentDAO {
	
	public void addStudent(Student stud);
	public void removeStudent(Student stud);
	public List<Student> getAllStudents();
	
//  public Student getStateByAbbreviation(String abbreviation);
//  public Student getNextState(Student state);
//  public Student getPreviousState(Student state);
}
