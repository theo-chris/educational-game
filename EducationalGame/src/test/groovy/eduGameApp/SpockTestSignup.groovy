package eduGameApp

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext

import eduGameApp.controllers.IndexController
import eduGameApp.controllers.IndexFormDto
import eduGameApp.controllers.SignupController
import eduGameApp.repository.UserRepo

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import spock.lang.Specification
import spock.lang.Unroll

@ContextConfiguration
@WebMvcTest(controllers=[IndexController.class,SignupController.class])
class SpockTestSignup extends Specification {
	
	@Autowired
	def WebApplicationContext wac
	
	@MockBean
	private UserRepo userRepo;
	
	def MockMvc mockMvc 
	def ResultActions result
	
	//SignUp
	
	def "signUp/"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get '/signup/'"
			result = this.mockMvc.perform(get('/signup/'));
		then: "I should see the view signup'"
			result.andExpect(status().isOk()).andExpect(view().name('signup'));
	}
	
	def "signUpCancelRedirect"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a post '/signup/add' with param=cancel"
			result = this.mockMvc.perform(post('/signup/add').param("cancel",''));
		then: "I should be redirected"
			result.andExpect(view().name('redirect:/'));
	}
	
	def "signUpValidData"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a post '/signup/add' with params"
			result = this.mockMvc.perform(post('/signup/add')
				.param("add",'')
				.param("firstName",'fred')
				.param("lastName",'krueger')
				.param("username",'freddie')
				.param("password",'passw')
				.param("password2",'passw')
				.param("securityQuestion",'Who is your hero?')
				.param("securityAnswer",'answer'));
		then: "I should be redirected to main"
			result.andExpect(view().name('redirect:/main/'));
	}
	
	/*def "getAllUsers/"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get '/signup/all'"
			result = this.mockMvc.perform(get('/signup/all'));
		then: "I should see the view signup'"
			result.andExpect(status().isOk()).andExpect(content().xml(ATOM_XML));
	}*/
	
	//different invalid data
	def "signUpInvalidData"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a post '/signup/add' with one invalid parameter"
			result = this.mockMvc.perform(post('/signup/add')
				.param("add",'')
				.param("firstName",'fred')
				.param("lastName",'krueger')
				.param("username",'freddie')
				.param("password",'passwa')
				.param("password2",'passw')
				.param("securityQuestion",'Who is your hero?')
				.param("securityAnswer",'answer'));
		then: "I should seethe view signup"
			result.andExpect(status().isOk()).andExpect(view().name('signup'));
	}
	
	def "signUpInvalidData2"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a post '/signup/add' with invalid parameters"
			result = this.mockMvc.perform(post('/signup/add')
				.param("add",'')
				.param("firstName",'1321')
				.param("lastName",'1234')
				.param("username",'Guest')
				.param("password",'123')
				.param("password2",'123')
				.param("securityQuestion",'----------')
				.param("securityAnswer",'answer'));
		then: "I should see the view signup"
			result.andExpect(status().isOk()).andExpect(view().name('signup'));
	}
	
	
	/*def "signUpExistingUser"() {
		given: "the context of the controller is set up with a user"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
			mockMvc.perform(post('/signup/add')
				.param("add",'')
				.param("firstName",'fred')
				.param("lastName",'krueger')
				.param("username",'conflict')
				.param("password",'passw')
				.param("password2",'passw')
				.param("securityQuestion",'Who is your hero?')
				.param("securityAnswer",'answer'));
		when: "I do a post '/signup/add' with params"		
			result = mockMvc.perform(post('/signup/add')
				.param("add",'')
				.param("firstName",'fred')
				.param("lastName",'flinston')
				.param("username",'conflict')
				.param("password",'passw')
				.param("password2",'passw')
				.param("securityQuestion",'Who is your hero?')
				.param("securityAnswer",'answer'));
		then: "I should see the view signup"
			result.andExpect(view().name('main'));
	}*/
	
	
}