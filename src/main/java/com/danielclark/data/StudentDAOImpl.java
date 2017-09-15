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
//	private static final String FILE_NAME = "/WEB-INF/states.csv";
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
		// TODO : Implement method
		students.add(stud);
	}
	
	@Override
	public void displayStudents(List<Student> students) {
		for (Student stud : students) {
			System.out.println(stud);
		}
	}
	
	@Override
	public void removeStudent(Student stud) {
		students.remove(students.indexOf(stud));
	}
	
//	@PostConstruct
//	public void init() {
//		// Retrieve an input stream from the servlet context
//		// rather than directly from the file system
//		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
//				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
//			String line = buf.readLine();
//			while ((line = buf.readLine()) != null) {
//				String[] tokens = line.split(",");
//				String abbrev = tokens[1];
//				String name = tokens[2];
//				String capital = tokens[3];
//				String latitude = tokens[4];
//				String longitude = tokens[5];
//				states.add(new Student(abbrev, name, capital, latitude, longitude));
//			}
//		} catch (Exception e) {
//			System.err.println(e);
//		}
//	}
//
//	@Override
//	public Student getStateByName(String name) {
//		// TODO : Implement method
//		Student s = null;
//		// Find the state by it's name in the 'states' array
//		// If found, assign the state to 's'
//		for (Student st : states) {
//			if (st.getName().equalsIgnoreCase(name)) {
//				s = st;
//				break;
//			}
//		}
//
//		return s;
//	}
//
//	@Override
//	public Student getStateByAbbreviation(String abbrev) {
//		// TODO : Implement method
//		Student s = null;
//		// Find the state by it's abbreviation in the 'states' array
//		// If found, assign the state to 's'
//		for (Student st : states) {
//			if (st.getAbbreviation().equalsIgnoreCase(abbrev)) {
//				s = st;
//				break;
//			}
//		}
//		return s;
//	}


//	@Override
//	public Student getNextState(Student state) {
//		// method finds index of state passed in and increases by 1
//		int i = states.indexOf(state);
//		if (i == states.indexOf(states.size() - 1)) {
//			return states.get(0);
//		} else {
//
//			i++;
//			return states.get(i);
//		}
//	}
//
//	@Override
//	public Student getPreviousState(Student state) {
//		int i = states.indexOf(state);
//		if (i == states.indexOf(0)) {
//			return states.get(states.size()-1);
//		} else {
//
//			i--;
//			return states.get(i);
//		}
//	}


}
