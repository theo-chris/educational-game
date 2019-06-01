package eduGameApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import eduGameApp.EducationalGameApplication;
import eduGameApp.controllers.passRecoveryController;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;

@WebMvcTest(passRecoveryController.class)
@RunWith(SpringRunner.class)
public class TestPassRecoveryController {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepo userRepo;

  @Test
  public void passwordRecoveryPage() throws Exception{
    mockMvc.perform(post("/passwordRecovery/").with(user("Guest").password("password")))
        .andExpect(status().is(200))
        .andExpect(view().name("passwordRecovery"));
  }
  
  @Test
  public void transitionToSecurityQuestion() throws Exception{
	  User toCompare=new User();
	  toCompare.setSecurityQuestion("What is your favourite colour?");
	  toCompare.setUsername("testUsername");
	  
	  given(userRepo.findByUsername("testUsername")).willReturn(toCompare);
	  
	  mockMvc.perform(post("/passwordRecovery/securityQuestion").with(user("Guest").password("password"))
				.param("firstName","fred")
				.param("lastName","krueger")
				.param("username","testUsername")
				.param("password","passw")
				.param("password2","passw")
				.param("securityQuestion","What is your favourite colour?")
				.param("securityAnswer","answer"))
        .andExpect(status().is(200))
        .andExpect(view().name("securityQ"));
  }
  
  @Test
  public void unsuccessfulTransitionToSecurityQuestion() throws Exception{
      EducationalGameApplication.setPasswordResetSection(0);
	  User toCompare=new User();
	  toCompare.setSecurityQuestion("What is your favourite colour?");
	  toCompare.setUsername("testUsername");
	  
	  given(userRepo.findByUsername("testUsername")).willReturn(null);
	  
	  mockMvc.perform(post("/passwordRecovery/securityQuestion").with(user("Guest").password("password"))
				.param("username","testUsername"))
        .andExpect(status().is(200))
        .andExpect(view().name("passwordRecovery"));
  }
  
  @Test
  public void successfulSecurityAnswer() throws Exception{
	  User toCompare=new User();
	  toCompare.setSecurityQuestion("What is your favourite colour?");
	  toCompare.setSecurityAnswer("black");
	  toCompare.setUsername("testUsername");
	  
	  given(userRepo.findByUsername("testUsername")).willReturn(toCompare);
      EducationalGameApplication.setPasswordResetSection(1);
      EducationalGameApplication.setPasswordResetUsername("testUsername");

	  mockMvc.perform(post("/passwordRecovery/resetPassword").with(user("Guest").password("password"))
				.param("securityAnswer","black")
				.param("username","testUsername")
				.param("securityQuestion", "What is your favourite colour?"))
        .andExpect(status().is(200))
        .andExpect(view().name("newPassword"));
  }
  @Test
  public void unsuccessfulSecurityAnswer() throws Exception{
	  User toCompare=new User();
	  toCompare.setSecurityQuestion("What is your favourite colour?");
	  toCompare.setSecurityAnswer("black");
	  toCompare.setUsername("testUsername");
	  
	  given(userRepo.findByUsername("testUsername")).willReturn(toCompare);
      EducationalGameApplication.setPasswordResetSection(1);
      EducationalGameApplication.setPasswordResetUsername("testUsername");

	  mockMvc.perform(post("/passwordRecovery/resetPassword").with(user("Guest").password("password"))
				.param("securityAnswer","blue")
				.param("username","testUsername")
				.param("securityQuestion", "What is your favourite colour?"))
        .andExpect(status().is(200))
        .andExpect(view().name("securityQ"));
  }
  
  @Test
  public void successfulPasswordRecoveryRedirectsToMain() throws Exception{
	  User toCompare=new User();
	  toCompare.setSecurityQuestion("What is your favourite colour?");
	  toCompare.setUsername("testUsername");
	  toCompare.setSecurityAnswer("answer");
    given(userRepo.findByUsername(Mockito.anyString()))
                .willReturn(toCompare);

    mockMvc.perform(post("/passwordRecovery/resetPasswordSuccess").with(user("Guest").password("password"))
			.param("firstName","fred")
			.param("lastName","krueger")
			.param("username","freddie")
			.param("password","passw")
			.param("password2","passw")
			.param("securityQuestion","Who is your hero?")
			.param("securityAnswer","answer"))
        .andExpect(status().is(302))
        .andExpect(redirectedUrl("/"));
  }


  @Test
  public void failedPasswordRecoveryRedirectsToNewPassword() throws Exception{

    EducationalGameApplication.setPasswordResetSection(2);

    mockMvc.perform(post("/passwordRecovery/resetPasswordSuccess").with(user("Guest").password("password"))
        .param("password","password")
        .param("password2","blah"))
        .andExpect(status().is(200))
        .andExpect(view().name("newPassword"));
  }
}