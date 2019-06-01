package eduGameApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import eduGameApp.EducationalGameApplication;
import eduGameApp.controllers.IndexController;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.mockito.BDDMockito.given;

@WebMvcTest(IndexController.class)
@RunWith(SpringRunner.class)
public class TestIndexController {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepo repository;
  
  
 
  @Before
  public void before() {	  
	  User user=new User();
	  user.setPassword("testPassword");
	  user.setUsername("testUsername");
	  user.setUsername("testUsername");
	  given(repository.findByUsername("testUsername")).willReturn(user);
	  EducationalGameApplication.setUser(user);
	  repository.save(user);
	  
  }
  
  @Test
  public void indexWithNoUserLoggedIn() throws Exception{
	  EducationalGameApplication.setUser(null);
	  
    mockMvc.perform(post("/").with(user("user").password("password")))
    .andExpect(status().is(200))
    .andExpect(view().name("Landing"));
  }
  
  @Test
  public void indexWithUserLoggedIn() throws Exception{
	  User user=new User();
	  user.setUsername("testUsername");
	  EducationalGameApplication.setUser(user);
      mockMvc.perform(post("/").with(user("user").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/main/"));
  }
  
  @Test
  public void loginWithNoUserLoggedIn() throws Exception{
	  EducationalGameApplication.setUser(null);
    mockMvc.perform(post("/login").with(user("user").password("password")))
    .andExpect(status().is(200))
    .andExpect(view().name("index"));
  }
  
  @Test
  public void loginWithUserLoggedIn() throws Exception{
	  User user=new User();
	  user.setUsername("testUsername");
	  EducationalGameApplication.setUser(user);
    mockMvc.perform(post("/login").with(user("user").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/main/"));
  }
  

  
  @Test
  public void loginAttemptWithExistingUsernameAndNotValidPassword() throws Exception{
	  User userToValidate=new User();
	  userToValidate.setUsername("testUsername");
	  userToValidate.setPassword("testPassword");
	  
	  given(repository.findByUsername("testUsername")).willReturn(userToValidate);

	  	  
	 mockMvc.perform(post("/main").with(user("user").password("password"))
	    	.param("login","")
    		.param("username", "testUsername")
    		.param("password","wrongTestPassword"))
	    .andExpect(status().is(200))
	    .andExpect(view().name("index"));
  }
  
  @Test
  public void playAsAGuest() throws Exception{
	  User userToValidate=new User();
	  userToValidate.setUsername("testUsername");
	  userToValidate.setPassword("testPassword");
	  
	  given(repository.findByUsername("Guest")).willReturn(null);

	  	  
	 mockMvc.perform(post("/main").with(user("user").password("password")).param("guest", ""))
	    .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/main/"));
  }
  
  @Test
  public void loginExistingUserCorrectCredentials() throws Exception{
	  User userToValidate=new User();
	  userToValidate.setUsername("testUsername");
	  userToValidate.setPassword("testPassword");
	  
	  given(repository.findByUsername("testUsername")).willReturn(userToValidate);

	  	  
	 mockMvc.perform(post("/main").with(user("testUsername").password("testPassword"))
	    	.param("login","")
    		.param("username", "testUsername")
    		.param("password","testPassword"))
	    .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/main/"));
  }
  
  @Test
  public void loginWithGuestUsername() throws Exception{
    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("login","")
    		.param("username", "Guest")
    		.param("password","testPassword"))
    .andExpect(status().is(200))
    .andExpect(view().name("index"));
  }
  
  @Test
  public void loginNoErrors() throws Exception{

    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("login","")
    		.param("username", "testUserne")
    		.param("password","testPassword"))
    .andExpect(status().is(200))
    .andExpect(view().name("index"));
  }
  
  @Test
  public void signup() throws Exception{
    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("signup",""))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/signup/"));
  }
  
  @Test
  public void showPageAsAGuest() throws Exception{
    mockMvc.perform(post("/guest").with(user("Guest").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/main/"));
  }
  
  @Test
  public void forgotPassword() throws Exception{
    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("passwordRecovery", ""))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/passwordRecovery/"));
  }
  
  @Test
  public void progressEnglish() throws Exception{
    mockMvc.perform(post("/progress-english").with(user("user").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void progressMaths() throws Exception{
    mockMvc.perform(post("/progress-maths").with(user("user").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
}