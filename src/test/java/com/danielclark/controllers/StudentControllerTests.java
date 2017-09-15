//package com.danielclark.controllers;
//
//import static junit.framework.TestCase.fail;
//import static org.hamcrest.CoreMatchers.allOf;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasProperty;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.ModelAndView;
//
//import data.State;
//
//@RunWith(SpringJUnit4ClassRunner.class) //Run tests using this special Spring class. "treat me differently than other JUnits"
//@ContextConfiguration(locations = { "StateControllerTests-context.xml" })//..with this Spring config file
//@WebAppConfiguration//...and treat it like a WebApp(something that Tomcat could run)
//public class StudentControllerTests {
//	MockMvc mockMvc;// Need one of these to "perform()" requests
//
//	@Autowired
//	WebApplicationContext wc;//created when I told SPring to treat this like a WebApp
//							 //It's where all Spring's beans live (Controllers, DAO's, anything Spring created)
//	@Autowired
//	StudentController controller;//Spring created a controller because I annotated my class with @Controller
//							   //Here's how I get a hold of that object
//	MockStateDAO mockDAO;// set as a field
//
//	@Before
//	public void setUp() {
//		mockDAO = wc.getBean(MockStateDAO.class);//This MockStateDAO was created in StateControllerTests-context
//
//		// TODO - uncomment below to add a Mock object, which we control
//		 controller.setStateDao(mockDAO);
//		
//		// TODO - build the MockMvc object with MockMvcBuilders
//		 mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();// final step, build the thing to make request
//		 														 //using Application context Spring created for me
//		 
//		 //MockMvc allows us to test, period. It returns objects and tests other things than just method
//		 // functionality like, requestmapping and parameter connections
//	}
//
//	@After
//	public void tearDown(){
//		mockDAO.loadStates(); //cleanup
//	}
//
//	@Test
//	public void test_GET_GetStateData_do_with_valid_name_param_returns_State() {
//		try {
//			//performing a get request to this url with the param "name"(from our form) Colorado
//			MvcResult result = mockMvc.perform(get("/GetStateData.do").param("name", "Colorado"))
//					.andExpect(status().isOk()).andReturn();//expecting that it returns a 200 status of OK. andReturn allows this all to be stored in result
//			ModelAndView mv = result.getModelAndView();
//			assertEquals("result.jsp", mv.getViewName());
//			ModelMap map = mv.getModelMap(); //What is in the model and available to the JSP?
//			assertNotNull(map.get("state"));
//
//			Student st = (Student) map.get("state"); // getting the state
//			assertEquals("Colorado", st.getName());
//			assertEquals("CO", st.getAbbreviation());
//			assertEquals("3", st.getLatitude());
//			// TODO - test other fields
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.toString());
//		}
//	}
//
//	@Test
//	public void test_GET_GetStateData_do_with_invalid_name_param_does_not_add_State_to_model() {
//		// TODO - complete this and remove fail("implement");
//		//fail("implement");
//		
//		try {
//			MvcResult result = mockMvc.perform(get("/GetStateData.do").param("name", "Coloradoooo"))
//					.andExpect(status().isOk()).andReturn();
//			ModelAndView mv = result.getModelAndView();
//			assertEquals("result.jsp", mv.getViewName());
//			ModelMap map = mv.getModelMap();
//			assertNull(map.get("state"));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.toString());
//		}
//	}
//
//	@Test
//	public void test_GET_GetStateData_do_with_valid_abbr_param_adds_State_to_model() {
//		try {
//			MvcResult res = mockMvc.perform(get("/GetStateData.do").param("abbr", "MI"))
//				.andExpect(status().isOk()).andReturn();
//			//.andExpect(status().is3xxRedirection());
//			ModelAndView modelAndView = res.getModelAndView();
//			assertEquals("result.jsp", modelAndView.getViewName());
//			Student st = (Student) modelAndView.getModelMap().get("state");
//			assertNotNull(st);
//			assertEquals("Michigan", st.getName());
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//	}
//
//	@Test
//	public void test_GET_GetStateData_do_with_invalid_abbr_param_does_not_add_State_to_model() {
//		// TODO - complete this and remove fail("implement");
//		//fail("implement");
////		try {
////			MvcResult res = mockMvc.perform(get("/GetStateData.do").param("abbr", "1i"))
////					.andExpect(status().isOk()).andReturn();
////			//.andExpect(status().is3xxRedirection());
////			ModelAndView modelAndView = res.getModelAndView();
////			assertEquals("result.jsp", modelAndView.getViewName());
////			State st = (State) modelAndView.getModelMap().get("state");
////			assertNull(st);
////			assertEquals("Michigan", st.getName());
////		}
////		catch(Exception e) {
////			fail(e.toString());
////		}
//	}
//
//	@Test
//	public void test_POST_NewState_do_adds_state_and_returns_resultJSP() {
//		try {
//			MvcResult result = mockMvc.perform(post("/NewState.do").param("name", "MyState").param("capital", "Cap").param("abbreviation",  "Abbrev")
//					.param("latitude", "LAT").param("longitude", "LONG")).andReturn();
//			assertEquals("result.jsp", result.getModelAndView().getViewName());
//			
//		
//		// check the mock object's list directly for the new state. Check MockDAO for if state is there. Use its methods
//			Student state = this.mockDAO.getStateByName("MyState");
//			assertNotNull(state);
//			assertThat(state, allOf(
//					hasProperty("name", is("MyState")),//tests that it has property "capital" and it is "Cap"
//					hasProperty("capital", is("Cap")), 
//					hasProperty("abbreviation", is("Abbrev")),
//					hasProperty("latitude", is("LAT")),
//					hasProperty("longitude", is("LONG"))
//					));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.toString());
//		}
//	}
//	
//	// TODO - change previous test according to directions
//	
////	@Test
////	public void test_GET_stateAdded_do_returns_resultJSP_view() {
////		// TODO - complete this and remove fail("implement");
////		//fail("implement");
////	}
//}
