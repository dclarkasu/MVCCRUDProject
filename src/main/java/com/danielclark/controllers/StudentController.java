package com.danielclark.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.danielclark.data.Student;
import com.danielclark.data.StudentDAO;

@Controller
//@SessionAttributes("student")
public class StudentController {
	@Autowired
	  private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
	@RequestMapping(path="/NewStudent.do", method=RequestMethod.POST)
	public ModelAndView addNewStudent(Student stud) {
		ModelAndView mv = new ModelAndView();
		stud.getFirstName().toUpperCase();
		stud.getLastName().toUpperCase();
		studentDAO.addStudent(stud);
		mv.addObject("student", stud);
		mv.addObject("message", "New Student Added");
		mv.addObject("students", studentDAO.getAllStudents());
		mv.setViewName("redirect:home.do");
//		mv.setViewName("/listStudents.do");
		return mv;
	}
	@RequestMapping(path="/RemoveStudent.do", method=RequestMethod.POST)
	public ModelAndView removeStudent(int id) { // only takes an id
		ModelAndView mv = new ModelAndView();
		studentDAO.removeStudent(id);
		mv.addObject("students", studentDAO.getAllStudents());
		mv.addObject("message", "Student Removed");
		mv.setViewName("/listStudents.do");
		return mv;
	}
	@RequestMapping(path="/findStudent.do", method=RequestMethod.GET)
	public ModelAndView findStudent(int id) {
		ModelAndView mv = new ModelAndView();
		Student studentById = studentDAO.getStudentById(id);
		mv.addObject("student", studentById);
		mv.addObject("students", studentDAO.getAllStudents());
		mv.setViewName("result.jsp");
		return mv;
	}

	@RequestMapping(path= "/home.do", 
			method=RequestMethod.GET)
	public ModelAndView getAllStudents() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("students", studentDAO.getAllStudents());
		return mv;
	}
	@RequestMapping(path= "/EditExistingStudent.do", 
			method=RequestMethod.POST)
	public ModelAndView editExistingStudent(/*@ModelAttribute Student stud*/ @RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Student stud = studentDAO.getStudentById(id);
			mv.addObject("student", stud);
			mv.setViewName("EditExistingStudent.jsp");
		return mv;
	}
	
	@RequestMapping(path= "editedStudent.do", 
			method=RequestMethod.POST)
	public ModelAndView editedStudent(@RequestParam("id") int id, Student inStudent) {// Spring magic makes new command object
		ModelAndView mv = new ModelAndView();
		Student stud = studentDAO.getStudentById(id);
		studentDAO.updateStudent(stud, inStudent.getFirstName(), inStudent.getLastName(), inStudent.getGrade());
		mv.setViewName("/listStudents.do");
		mv.addObject("message", "New Student Added");
		mv.addObject("student", stud);
		return mv;
	}
	@RequestMapping(path= "/listStudents.do", 
			method=RequestMethod.POST)
	public ModelAndView listStudents() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentList.jsp");
		mv.addObject("students", studentDAO.getAllStudents());
		return mv;
	}
}	
	
