package eduGameApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BeanPropertyBindingResult;

import eduGameApp.EducationalGameApplication;
import eduGameApp.controllers.MainController;
import eduGameApp.controllers.UserSignupValidator;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@WebMvcTest(MainController.class)
@RunWith(SpringRunner.class)
public class TestMainController {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepo repository;

  @Test
  public void mainWithNoUserLoggedIn() throws Exception{
	  EducationalGameApplication.setUser(null);
	  mockMvc.perform(post("/main/").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/login"));
  }
  
  @Test
  public void mainWithUserLoggedIn() throws Exception{
	  User user=new User();
	  user.setUsername("testUsername");
	  EducationalGameApplication.setUser(user);
	  mockMvc.perform(post("/main/").with(user("user").password("password")))
	  .andExpect(status().is(200))
      .andExpect(view().name("main"));
  }
  
  @Test
  public void choseMaths() throws Exception{
	  mockMvc.perform(post("/main/start-maths/").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/maths/"));
  }
  
  @Test
  public void choseEnglish() throws Exception{
	  mockMvc.perform(post("/main/start-english/").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void choseEnglishWithNoUserLoggedIn() throws Exception{
	  EducationalGameApplication.setUser(null);
	  mockMvc.perform(post("/main/english").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/login"));
  }
  
  @Test
  public void choseEnglishWithUserLoggedIn() throws Exception{
	  User user=new User();
	  user.setUsername("testUsername");
	  EducationalGameApplication.setUser(user);
	  mockMvc.perform(post("/main/english").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/english/"));
  }  
  
  @Test 
  public void testDuplicateUser(){
    given(repository.findByUsername("duplicateUsername"))
         .willReturn(new User());

    User userToValidate = new User();    
    userToValidate.setFirstName("test");
    userToValidate.setLastName("smith");
    userToValidate.setUsername("duplicateUsername");
    userToValidate.setPassword("password");
    userToValidate.setPassword2("password");
    userToValidate.setSecurityQuestion("What is something");
    userToValidate.setSecurityAnswer("Not much");

    UserSignupValidator v = new UserSignupValidator(repository);  
    BeanPropertyBindingResult errors = new BeanPropertyBindingResult(userToValidate, "userToValidate");

    v.validate(userToValidate, errors);
    assertEquals(errors.getAllErrors().size(), 2);
  }
}