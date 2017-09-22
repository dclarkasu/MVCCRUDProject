package com.danielclark.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class StudentDAODBImpl implements StudentDAO {
	private static final String FILE_NAME = "/WEB-INF/students.csv";
	private List<Student> students = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;
	
	@Override
	public void addStudent(Student stud) {
		stud.setId(students.lastIndexOf(getAllStudents()) + 1);
		students.add(stud);
	}

	@Override
	public void removeStudent(int id) {
		for(int i = 0; i < students.size(); i++) {
			if((id == students.get(i).getId()) && id <= students.size()) {
				students.remove(i);
				break;
			}
		}
	}

	@PostConstruct
	public void init() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				int id = Integer.parseInt(tokens[0]);
				String firstName = tokens[1];
				String lastName = tokens[2];
				int grade = Integer.parseInt((tokens[3]));
				students.add(new Student(firstName, lastName, id, grade));
			}
			System.out.println("***************" + students);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public List<Student> getAllStudents() {
		return new ArrayList<>(students);
	}

	@Override
	public Student updateStudent(Student stud, int id, String firstName, String lastName, int grade) {
		stud.setFirstName(firstName);
		stud.setLastName(lastName);
		stud.setGrade(grade);
		return stud;
	}

	@Override
	public Student getStudentById(int id) {
		Student stud = null;
		for(Student st : students) {
			if((st.getId()) == id) {
				stud = st;
				break;
			}
		}
		return stud;
	}
}