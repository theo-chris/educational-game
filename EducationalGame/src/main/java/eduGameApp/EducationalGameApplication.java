package eduGameApp;

import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eduGameApp.domain.MathsQuestions;
import eduGameApp.domain.User;

@SpringBootApplication
public class EducationalGameApplication {

	private static String passwordResetUsername = "";
	private static Integer passwordResetSection = -1;
	private static Integer mathScore = 0;
	private static User user;
	private static MathsQuestions mathsQuestions = new MathsQuestions();
	private static Integer counter = 0;
	private static Integer timerRemaining = 0;
	private static Integer englishScore = 0;
	private static boolean startedEnglish = false;
	private static HashSet<String> askedQuestions = new HashSet<String>();
	
	public static Integer getEnglishScore() {
		return englishScore;
	}
	public static void setEnglishScore(Integer englishScoreIn) {
		englishScore = englishScoreIn;
	}
	public static Integer getCounter() {
		return counter;
	}
	public static void setCounter(Integer counter) {
		EducationalGameApplication.counter = counter;
	}
	public static Integer getCounter2() {
		return counter2;
	}
	public static void setCounter2(Integer counter2) {
		EducationalGameApplication.counter2 = counter2;
	}

	private static Integer counter2 = 0;
	
	public static Integer getMathScore() {
		return mathScore;
	}
	public static void setMathScore(Integer mathScoreIn) {
		mathScore = mathScoreIn;
	}
	public static User getUser() {
		return user;
	}
	public static void setUser(User user) {
		EducationalGameApplication.user = user;
	}
	public static String getPasswordResetUsername() {
		return passwordResetUsername;
	}

	public static Integer getPasswordResetSection() {
		return passwordResetSection;
	}
	public static void setPasswordResetSection(Integer passwordResetSection) {
		EducationalGameApplication.passwordResetSection = passwordResetSection;
	}

	public static MathsQuestions getMathsQuestions() {
		return mathsQuestions;
	}

	public static void setMathsQuestions(MathsQuestions mathsQuestions) {
		EducationalGameApplication.mathsQuestions = mathsQuestions;
	}

	public static void setPasswordResetUsername(String passwordResetUsername) {
		EducationalGameApplication.passwordResetUsername = passwordResetUsername;
	}
	public static Integer getTimerRemaining() {
		return timerRemaining;
	}
	public static void setTimerRemaining(Integer timerRemainingIn) {
		timerRemaining = timerRemainingIn;
	}
	public static void appendTimerRemaining(Integer timerRemaining) {
		EducationalGameApplication.timerRemaining += timerRemaining;
	}
	
	
	public static HashSet<String> getAskedQuestions() {
		return askedQuestions;
	}
	public static void setAskedQuestions(HashSet<String> askedQuestions) {
		EducationalGameApplication.askedQuestions = askedQuestions;
	}
	public static boolean isStartedEnglish() {
		return startedEnglish;
	}
	public static void setStartedEnglish(boolean startedEnglish) {
		EducationalGameApplication.startedEnglish = startedEnglish;
	}
	public static void main(String[] args) {
		SpringApplication.run(EducationalGameApplication.class, args);
	}
	
}
