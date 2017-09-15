package com.danielclark.data;

import java.util.List;

public interface StudentDAO {
	
	public void addStudent(Student stud);
	public void removeStudent(Student stud);
	public void displayStudents(List<Student> students);
	
	
//  public Student getStateByName(String name);
//  public Student getStateByAbbreviation(String abbreviation);
//  public void addState(Student state);
//  public Student getNextState(Student state);
//  public Student getPreviousState(Student state);
}
