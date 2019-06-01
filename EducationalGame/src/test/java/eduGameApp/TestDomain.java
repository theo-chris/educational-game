package eduGameApp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import eduGameApp.controllers.IndexFormDto;
import eduGameApp.domain.EnglishQuestionPair;
import eduGameApp.domain.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class TestDomain {
	
	@Test
	public void IndexFormDtoTest() {
		IndexFormDto indexFormDto= new IndexFormDto();
		indexFormDto.setUsername("username");
		indexFormDto.setPassword("password");		
		assertThat(indexFormDto.getUsername().equals("username")&&indexFormDto.getPassword().equals("password"));
	}
	
	@Test
	public void IndexFormDtoEmptyTest() {
		IndexFormDto indexFormDto= new IndexFormDto();
		indexFormDto.setUsername("username");		
		indexFormDto.setUsernameEmpty();
		assertThat(indexFormDto.getUsername().equals(""));
	}
		
	@Test
	public void UserGettersSettersTest() {
		User user = new User();
		user.setFirstName("fn");
		user.setLastName("ln");
		user.setPassword("password");
		user.setPassword2("password");
		user.setUsername("username");
		user.setId(123);
		user.setTimeStamp(12345);
		assertThat(user.getUsername().equals("username")&&user.getPassword().equals("password")&&
				user.getPassword2().equals("password")&&
				user.getLastName().equals("ln")&&
				user.getFirstName().equals("fn")&&
				user.getId().equals(123)&&user.nameFormatTest("fn")&&user.passwordFormatTest("password")&&
				user.getTimeStamp()==12345);
	}
	
	@Test
	public void UserConstructorTest() {
		User user = new User(123,"fn","ln","un","pw","pw2","sq","sa");
		assertThat(user.getUsername().equals("un")&&user.getPassword().equals("pw")&&
				user.getPassword2().equals("pw2")&&
				user.getLastName().equals("ln")&&
				user.getFirstName().equals("fn")&&
				user.getId().equals(123)&&user.nameFormatTest("fn")&&user.passwordFormatTest("pw"));
	}
	
	@Test
	public void EnglishQuestionPairTest() {
		EnglishQuestionPair eqp = new EnglishQuestionPair(null, null, null, null, null,null);
		eqp.set_name("name");
		eqp.set_opt1("opt1");
		eqp.set_opt2("opt2");
		eqp.set_opt3("opt3");
		eqp.set_opt4("opt4");
		eqp.setCorrectAnswer("answer");
		assertThat(eqp.get_name().equals("name")&&eqp.get_opt1().equals("opt1")&&
				eqp.get_opt2().equals("opt2")&&
				eqp.get_opt3().equals("opt3")&&
				eqp.get_opt4().equals("opt4")&&
				eqp.isCorrect("answer"));
	}
	@Test
	public void EnglishQuestionPairSecondConstructorTest() {
		EnglishQuestionPair eqp = new EnglishQuestionPair(null, null, null, null, null,null,null);
		eqp.set_name("name");
		eqp.set_opt1("opt1");
		eqp.set_opt2("opt2");
		eqp.set_opt3("opt3");
		eqp.set_opt4("opt4");
		eqp.set_opt5("opt5");
		eqp.setCorrectAnswer("answer");
		assertThat(eqp.get_name().equals("name")&&eqp.get_opt1().equals("opt1")&&
				eqp.get_opt2().equals("opt2")&&
				eqp.get_opt3().equals("opt3")&&
				eqp.get_opt4().equals("opt4")&&
				eqp.get_opt5().equals("opt5")&&
				eqp.getCorrectAnswer().equals("answer"));
	}
	
	
}