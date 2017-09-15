package com.danielclark.controllers;

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
@SessionAttributes ("state")
public class StudentController {
	// TODO : Autowire a StudentDAO and create getters and setters
	@Autowired
	  private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	

	// TODO : Implement a request handler for:
	// path "GetStateData.do"
	// params "name"
	// method GET
	// return : ModelAndView
	// view : "result.jsp"
	// object : "state", getStateByName
	@RequestMapping(path="GetStateData.do", 
			params="name",
			method=RequestMethod.GET)
	public ModelAndView getByName(@RequestParam("name") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("state", studentDAO.getStateByName(n));
		return mv;
	}

	// TODO : Implement a request handler for:
	// path "GetStateData.do"
	// params "abbr"
	// method GET
	// return : ModelAndView
	// view : "result.jsp"
	// object : "state", getStateByAbbreviation
	@RequestMapping(path="GetStateData.do", params="abbr")
	public ModelAndView getStateByAbbreviation(String abbr) { // same as writing @RequestParm("abbr")
		ModelAndView mv = new ModelAndView();
		Student st = this.studentDAO.getStateByAbbreviation(abbr);
		mv.addObject("state", st);
		mv.setViewName("result.jsp");
		return mv;
	}
	

	// TODO : Implement a request handler for:
	// path "NewState.do"
	// method POST
	// command object : State
	// return : ModelAndView
	// view : "result.jsp"
	@RequestMapping(path="/NewState.do", method=RequestMethod.POST)
	public ModelAndView addNewState(Student state) {
		ModelAndView mv = new ModelAndView();
		studentDAO.addState(state);
		
		mv.addObject("state", state);
		mv.setViewName("result.jsp");
		return mv;
	}
	//Method allows user to click next and view the next state
	@RequestMapping(path="GetStateData.do", params="next", method=RequestMethod.GET)
	public ModelAndView getNextState(@ModelAttribute("state") Student state) { // same as writing @RequestParm("abbr")
		ModelAndView mv = new ModelAndView();
		Student st = this.studentDAO.getNextState(state);
		mv.addObject("state", st);
		mv.setViewName("result.jsp");
		return mv;
	}
	//Method allows user to click next and view the next state
	@RequestMapping(path="GetStateData.do", params="previous", method=RequestMethod.GET)
	public ModelAndView getPreviousState(@ModelAttribute("state")Student state) { 
		ModelAndView mv = new ModelAndView();
		Student st = this.studentDAO.getPreviousState(state);
		mv.addObject("state", st);
		mv.setViewName("result.jsp");
		return mv;
	}
	

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
