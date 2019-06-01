package eduGameApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.MathsQuestions;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class TestEducationalGameApplication {

	
	@Test
	public void gettingAndSettingMathsQuestions() {
		MathsQuestions mq=new MathsQuestions();
		mq.setAnswer(1);
		EducationalGameApplication.setMathsQuestions(mq);
		MathsQuestions mq1=new MathsQuestions();
		mq1=EducationalGameApplication.getMathsQuestions();
		assertThat(mq1.getAnswer()==1);
	}
	
	@Test
	public void settingMathsScore() {
		EducationalGameApplication.setMathScore(1);
		assertThat(EducationalGameApplication.getMathScore()==1);
	}

}
