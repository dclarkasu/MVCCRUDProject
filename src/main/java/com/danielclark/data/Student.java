package com.danielclark.data;

public class Student {
	private String firstName, lastName;
	private Integer id, grade;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, Integer id, Integer grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + "\n";
	}

	

}