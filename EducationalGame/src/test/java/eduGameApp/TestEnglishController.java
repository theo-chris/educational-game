package eduGameApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import eduGameApp.EducationalGameApplication;
import eduGameApp.controllers.EnglishController;
import eduGameApp.domain.EnglishQuestionPair;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.mockito.BDDMockito.given;

@WebMvcTest(EnglishController.class)
@RunWith(SpringRunner.class)
public class TestEnglishController {

  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  EnglishQuestionPair pair;
  
  
  @Before
  public void before() {
	  given(pair.isCorrect("answer"))
      .willReturn(false);  
	  pair=new EnglishQuestionPair("", "", "", "", "", "");
	  pair.set_opt1("answer");
	  pair.set_opt2("answer");
	  pair.set_opt3("answer");
	  pair.set_opt4("answer");
	  pair.set_opt5("answer");
	  pair.setCorrectAnswer("answer");    
  }
  
  @Test
  public void englishAccessedNotThroughAQuestion() throws Exception{
    mockMvc.perform(post("/english/").with(user("user").password("password")).param("pojo", "notAQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/"));
  }
  
  @Test
  public void easyEnglish() throws Exception{
	  EducationalGameApplication.setStartedEnglish(false);
	  EducationalGameApplication.setCounter(1);
	  EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/english/").with(user("user").password("password")).param("pojo", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("english"));
  }
  
  @Test
  public void easyEnglishStartedWithEnglish() throws Exception{
	  EducationalGameApplication.setStartedEnglish(true);
	  EducationalGameApplication.setCounter(1);
	  EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/english/").with(user("user").password("password")).param("pojo", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("english"));
  }
  

  @Test
  public void hardEnglishStartedWithMaths() throws Exception{
	  EducationalGameApplication.setStartedEnglish(false);
	  EducationalGameApplication.setCounter(9);
	  EducationalGameApplication.setCounter2(3);
	  mockMvc.perform(post("/english/").with(user("user").password("password")).param("pojo", "question"))
	    .andExpect(status().is(200))
	    .andExpect(view().name("english"));
  }
  
  @Test
  public void englishEndGameToProgress() throws Exception{
	  EducationalGameApplication.setStartedEnglish(true);
	  EducationalGameApplication.setCounter(10);
	  EducationalGameApplication.setCounter2(10);
	  mockMvc.perform(post("/english/").with(user("user").password("password")).param("pojo", "question"))
	    .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/english/progress"));
  }
  
  @Test
  public void englishEndGameRedirectToSummary() throws Exception{
	  EducationalGameApplication.setStartedEnglish(false);
	  EducationalGameApplication.setCounter(10);
	  EducationalGameApplication.setCounter2(10);
	  mockMvc.perform(post("/english/").with(user("user").password("password")).param("pojo", "question"))
	    .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/summary/"));
  }
  
  @Test
  public void opt1() throws Exception{
	EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("opt1", "answer")
    		.param("timer", "5")
    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void opt2() throws Exception{
	EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("opt2", "answer")
    		.param("timer", "5")
    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void opt3() throws Exception{
	EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("opt3", "answer")
    		.param("timer", "5")
    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void opt4() throws Exception{
	EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("opt4", "answer")
    		.param("timer", "5")
    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void opt5() throws Exception{
	EducationalGameApplication.setCounter2(0);
    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("opt5", "answer")
    		.param("timer", "5")
    		.param("timerRemaining", "5"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void progressAccessedNotThroughAQuestion() throws Exception{
    mockMvc.perform(post("/english/progress").with(user("user").password("password"))
    		.param("pojo", "notQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/"));
  }
  
  @Test
  public void progressToSubjectTransition() throws Exception{
    mockMvc.perform(post("/english/progress").with(user("user").password("password"))
    		.param("pojo", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("SubjectTransition"));
  }
  
  @Test
  public void skip() throws Exception{
	EducationalGameApplication.setCounter(10);
	EducationalGameApplication.setStartedEnglish(true);
    mockMvc.perform(post("/english/skip").with(user("user").password("password"))
    		.param("pojo", "notQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  
}