//package com.danielclark.controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import data.State;
//import data.StateDAO;
//
//public class MockStateDAO implements StudentDAO {
//
//	List<Student> states;
//	public MockStateDAO() {
//		states = new ArrayList<>();
//		loadStates();
//	}
//
//	public void loadStates(){
//		states.clear();
//		states.add(new Student("MI", "Michigan", "Lansing", "1.0", "2.0"));
//		states.add(new Student("CO", "Colorado", "Denver", "3", "4"));
//	}
//
//	@Override
//	public Student getStateByName(String name) {
//		Student s = null;
//		for (Student state : states) {
//			if (state.getName().equalsIgnoreCase(name)) {
//				s = state;
//				break;
//			}
//		}
//		return s;
//	}
//	@Override
//	public Student getStateByAbbreviation(String abbrev) {
//		Student s = null;
//		for (Student state : states) {
//			if (state.getAbbreviation().equalsIgnoreCase(abbrev)) {
//				s = state;
//				break;
//			}
//		}
//		return s;
//	}
//	@Override
//	public void addState(Student state) {
//		states.add(state);
//	}
//
//	@Override
//	public Student getNextState(Student state) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Student getPreviousState(Student state) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
