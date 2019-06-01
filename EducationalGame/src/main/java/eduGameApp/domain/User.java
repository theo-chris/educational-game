package eduGameApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@Column(name="First_Name", nullable= false)
    private String firstName;
	@Column(name="Last_Name", nullable= false)
    private String lastName;
	@Column(name="Username", unique=true, nullable= false)
    private String username;
	@Column(name="Password", nullable = false)
    private String password;
	@Column(name="Password2", nullable = false)
	private String password2;
	@Column(name="Security_Question", nullable = false)
	private String securityQuestion;
	@Column(name="Security_Answer", nullable = false)
	private String securityAnswer;
	@Column(name="HighScore", nullable = true)
	private Integer HighScore = 0;
	@Column(name="timeStamp", nullable = true)
	private Integer timeStamp;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public Integer getHighScore() {
		return HighScore;
	}
	public void setHighScore(Integer highScore) {
		HighScore = highScore;
	}
	public Integer getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Integer timeStamp) {
		this.timeStamp = timeStamp;
	}
	public boolean nameFormatTest(String s) {
		String regex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
		return s.matches(regex);
		
	}
	
	public boolean passwordFormatTest(String s) {
		String regex = "^[A-Za-z]{4,8}$";
		return s.matches(regex);
		
	}
	public boolean usernameFormatTest(String s) {
		String regex = "^[a-zA-Z0-9]{4,12}$";
		return s.matches(regex);
		
	}
	public User() { }
	
	public User(Integer id, String firstName, String lastName, String username, String password, String password2,
			String securityQuestion, String securityAnswer) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	
	

}
