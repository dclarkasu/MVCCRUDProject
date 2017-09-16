package com.danielclark.controllers;

import java.util.List;

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
@SessionAttributes ("student")
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
		mv.addObject("students", studentDAO.getAllStudents());
		mv.setViewName("result.jsp");
		return mv;
	}
	@RequestMapping(path="/RemoveStudent.do", method=RequestMethod.POST)
	public ModelAndView removeStudent(int id) { // only takes an id
		ModelAndView mv = new ModelAndView();
		studentDAO.removeStudent(id);
//		mv.addObject("student", stud);
		mv.addObject("students", studentDAO.getAllStudents());
		mv.setViewName("result.jsp");
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
	@RequestMapping(path= "EditExistingStudent.do", 
			method=RequestMethod.POST)
	public ModelAndView editExistingStudent(Student stud) {
		ModelAndView mv = new ModelAndView();
		studentDAO.updateStudent(stud);
		mv.setViewName("studentList.jsp");//individual studnt page
		mv.addObject("students", studentDAO.getAllStudents());
		return mv;
	}
	
	@RequestMapping(path= "editStudents.do", 
			method=RequestMethod.GET)
	public ModelAndView editStudents() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("removeStudent.jsp");
		mv.addObject("students", studentDAO.getAllStudents());
		return mv;
	}
	
	

	// TODO : Implement a request handler for:
	// path "GetStateData.do"
	// params "abbr"
	// method GET
	// return : ModelAndView
	// view : "result.jsp"
	// object : "state", getStateByAbbreviation
//	@RequestMapping(path="GetStateData.do", params="abbr")
//	public ModelAndView getStateByAbbreviation(String abbr) { // same as writing @RequestParm("abbr")
//		ModelAndView mv = new ModelAndView();
//		Student st = this.studentDAO.getStateByAbbreviation(abbr);
//		mv.addObject("student", st);
//		mv.setViewName("result.jsp");
//		return mv;
//	}
	

	//Method allows user to click next and view the next state
//	@RequestMapping(path="GetStateData.do", params="next", method=RequestMethod.GET)
//	public ModelAndView getNextState(@ModelAttribute("state") Student state) { // same as writing @RequestParm("abbr")
//		ModelAndView mv = new ModelAndView();
//		Student st = this.studentDAO.getNextState(state);
//		mv.addObject("state", st);
//		mv.setViewName("result.jsp");
//		return mv;
//	}
	//Method allows user to click next and view the next state
//	@RequestMapping(path="GetStateData.do", params="previous", method=RequestMethod.GET)
//	public ModelAndView getPreviousState(@ModelAttribute("state")Student state) { 
//		ModelAndView mv = new ModelAndView();
//		Student st = this.studentDAO.getPreviousState(state);
//		mv.addObject("state", st);
//		mv.setViewName("result.jsp");
//		return mv;
//	}
	

	// -------------------

	// TODO : Implement another request handler for:
	// path "NewState.do"
	// method POST
	// command object : State
	// return : ModelAndView
	// view : "redirect:stateAdded.do"
	// behavior : add state to dao, add state to flashAttributes
	
	// TODO : Implement another request handler for:
    // path "stateAdded.do"
    // method GET
    // command object : State
    // return : ModelAndView
    // view : "result.jsp" or "result" if using InternalResourceViewResolver

}
