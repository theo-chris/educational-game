package eduGameApp;

import static org.mockito.BDDMockito.given;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import eduGameApp.domain.MathsQuestions;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMathsQuestions {

	MathsQuestions mathsQuestions;
	
	  @MockBean
	  private Random rand;
	
	@Before
	public void before() {
		mathsQuestions =new MathsQuestions();
	}
	
	@Test
	public void getSetScore() {
		mathsQuestions.setScore(2);
		assertThat(mathsQuestions.getScore()==2);
	}
	
	@Test
	public void getSetX() {
		mathsQuestions.setX(2);
		assertThat(mathsQuestions.getX()==2);
	}
	
	@Test
	public void getSetY() {
		mathsQuestions.setY(2);
		assertThat(mathsQuestions.getY()==2);
	}
	
	@Test
	public void getSetOperator() {
		mathsQuestions.setOperator("-");
		assertThat(mathsQuestions.getOperator().equals("-"));
	}
	
	@Test
	public void easyAdditionQuestion() {
		given(rand.nextInt()).willReturn(0);
		mathsQuestions.EasyQuestion();
		assertThat(mathsQuestions.getOperator().equals("+"));
	}
	
	@Test
	public void hardAdditionQuestion() {
		given(rand.nextInt()).willReturn(0);
		mathsQuestions.HardQuestion();
		assertThat(mathsQuestions.getOperator().equals("+"));
	}
	
	@Test
	public void easySubtractionQuestion() {
		given(rand.nextInt()).willReturn(2);
		mathsQuestions.EasyQuestion();
		assertThat(mathsQuestions.getOperator().equals("-"));
	}	
		
	@Test
	public void hardSubtractionQuestion() {
		given(rand.nextInt()).willReturn(2);
		mathsQuestions.HardQuestion();
		assertThat(mathsQuestions.getOperator().equals("-"));
	}
	
	@Test
	public void getAnswer() {
		mathsQuestions.setOperator("+");
		mathsQuestions.setX(2);
		mathsQuestions.setY(2);
		assertThat(mathsQuestions.getAnswer()==4);
	}
	
	
}