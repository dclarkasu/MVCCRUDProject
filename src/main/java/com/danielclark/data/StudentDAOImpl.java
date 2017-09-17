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
public class StudentDAOImpl implements StudentDAO {
	private static final String FILE_NAME = "/WEB-INF/students.csv";
	private List<Student> students = new ArrayList<>();

	/*
	 * Use Autowired to have Spring inject an instance of a WebApplicationContext
	 * into this object after creation. We will use the WebApplicationContext to
	 * retrieve a ServletContext so we can read from a file.
	 */
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

	// @Override
	// public Student getStateByName(String name) {
	// // TODO : Implement method
	// Student s = null;
	// // Find the state by it's name in the 'states' array
	// // If found, assign the state to 's'
	// for (Student st : states) {
	// if (st.getName().equalsIgnoreCase(name)) {
	// s = st;
	// break;
	// }
	// }
	//
	// return s;
	// }
	//
	// @Override
	// public Student getStateByAbbreviation(String abbrev) {
	// // TODO : Implement method
	// Student s = null;
	// // Find the state by it's abbreviation in the 'states' array
	// // If found, assign the state to 's'
	// for (Student st : states) {
	// if (st.getAbbreviation().equalsIgnoreCase(abbrev)) {
	// s = st;
	// break;
	// }
	// }
	// return s;
	// }

	// @Override
	// public Student getNextState(Student state) {
	// // method finds index of state passed in and increases by 1
	// int i = states.indexOf(state);
	// if (i == states.indexOf(states.size() - 1)) {
	// return states.get(0);
	// } else {
	//
	// i++;
	// return states.get(i);
	// }
	// }
	//
	// @Override
	// public Student getPreviousState(Student state) {
	// int i = states.indexOf(state);
	// if (i == states.indexOf(0)) {
	// return states.get(states.size()-1);
	// } else {
	//
	// i--;
	// return states.get(i);
	// }
	// }

}
