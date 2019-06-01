package eduGameApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import eduGameApp.EducationalGameApplication;
import eduGameApp.controllers.MathsController;
import eduGameApp.domain.User;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(MathsController.class)
@RunWith(SpringRunner.class)
public class TestMathsController {

  @Autowired
  private MockMvc mockMvc;

  @Before
  public void before() {
	  EducationalGameApplication.getMathsQuestions().setAnswer(2);  
  }
  
  @Test
  public void mathsWithNoUserLoggedIn() throws Exception{
	  EducationalGameApplication.setUser(null);
    mockMvc.perform(post("/maths/").with(user("user").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/login"));
  }
  
  @Test
  public void mathsAccessedNotThroughAQuestion() throws Exception{
    mockMvc.perform(post("/maths/").with(user("user").password("password")).param("pojo", "notAQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/"));
  }
  
  @Test
  public void easyMathsStartedWithEnglish() throws Exception{
	  EducationalGameApplication.setStartedEnglish(true);
	  EducationalGameApplication.setCounter(1);
	  EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/maths/").with(user("user").password("password")).param("pojo", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("maths"));
  }
  
  @Test
  public void easyMathsStartedWithMaths() throws Exception{
	  User user=new User();
	  user.setUsername("testUsername");
	  EducationalGameApplication.setUser(user);
	  EducationalGameApplication.setStartedEnglish(false);
	  EducationalGameApplication.setCounter(1);
	  EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/maths/").with(user("user").password("password")).param("pojo", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("maths"));
  }
  
  @Test
  public void hardMathsStartedWithMaths() throws Exception{
	  EducationalGameApplication.setStartedEnglish(false);
	  EducationalGameApplication.setCounter(5);
	  EducationalGameApplication.setCounter2(3);
	  mockMvc.perform(post("/maths/").with(user("user").password("password")).param("pojo", "question"))
	    .andExpect(status().is(200))
	    .andExpect(view().name("maths"));
  }
  
  @Test
  public void mathsEndGameRedirectProgress() throws Exception{
	  EducationalGameApplication.setStartedEnglish(false);
	  EducationalGameApplication.setCounter(15);
	  EducationalGameApplication.setCounter2(15);
	  mockMvc.perform(post("/maths/").with(user("user").password("password")).param("pojo", "question"))
	  .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/maths/progress"));
  }
  
  @Test
  public void mathsHardStartedWithEnglish() throws Exception{
	  User user=new User();
	  user.setUsername("testUsername");
	  EducationalGameApplication.setUser(user);
	  EducationalGameApplication.setStartedEnglish(true);
	  EducationalGameApplication.setCounter(10);
	  EducationalGameApplication.setCounter2(5);
	  mockMvc.perform(post("/maths/").with(user("user").password("password")).param("pojo", "question"))
	    .andExpect(status().is(200))
	    .andExpect(view().name("maths"));
  }
  
  @Test
  public void mathsEndGameToSummary() throws Exception{
	  EducationalGameApplication.setStartedEnglish(true);
	  EducationalGameApplication.setCounter(10);
	  EducationalGameApplication.setCounter2(10);
	  mockMvc.perform(post("/maths/").with(user("user").password("password")).param("pojo", "question"))
	  .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/summary/"));
  }
  
  @Test
  public void opt1() throws Exception{
	EducationalGameApplication.getMathsQuestions().setOpt1(2);
	EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/maths/answer").with(user("user").password("password"))
    		.param("opt1", "")
    		.param("timer", "5")
    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  @Test
  public void opt2() throws Exception{
	EducationalGameApplication.getMathsQuestions().setOpt2(2);
	EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/maths/answer").with(user("user").password("password"))
    		.param("opt2", "")
    		.param("timer", "5")
    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  @Test
  public void opt3() throws Exception{
	  EducationalGameApplication.getMathsQuestions().setOpt3(2);
	  EducationalGameApplication.setCounter2(0);
	  mockMvc.perform(post("/maths/answer").with(user("user").password("password"))
	    		.param("opt3", "")
	    		.param("timer", "5")
	    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  @Test
  public void opt4() throws Exception{
	  EducationalGameApplication.getMathsQuestions().setOpt4(2);
	  EducationalGameApplication.setCounter2(0);
	  mockMvc.perform(post("/maths/answer").with(user("user").password("password"))
	    		.param("opt4", "")
	    		.param("timer", "5")
	    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  
  @Test
  public void skip() throws Exception{
	  EducationalGameApplication.getMathsQuestions().setOpt4(2);
	  EducationalGameApplication.setCounter2(0);
	  mockMvc.perform(post("/maths/skip").with(user("user").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  
  @Test
  public void progressRedirect() throws Exception{
	  mockMvc.perform(post("/maths/progress").with(user("user").password("password")).param("pojo", "notQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/"));
  }
  
  @Test
  public void progressSubjectTransition() throws Exception{
	 mockMvc.perform(post("/maths/progress").with(user("user").password("password")).param("pojo", "question"))
	    .andExpect(status().is(200))
	    .andExpect(view().name("SubjectTransition"));
  }
  
  
}