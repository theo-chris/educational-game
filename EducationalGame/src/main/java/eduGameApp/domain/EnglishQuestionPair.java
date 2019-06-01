package eduGameApp.domain;



public class EnglishQuestionPair {
	private String _name;
	private String _opt1;
	private String _opt2;
	private String _opt3;
	private String _opt4;
	private String _opt5;
	private String correctAnswer;
	
	public EnglishQuestionPair(String name, String opt1, String opt2, String opt3, String opt4, String actualAnswer) {
		this._name = name;
		this._opt1 = opt1;
		this._opt2 = opt2;
		this._opt3 = opt3;
		this._opt4 = opt4;
		this.correctAnswer = actualAnswer;
	}

	public EnglishQuestionPair(String name, String opt1, String opt2, String opt3, String opt4, String opt5,String actualAnswer) {
		this._name = name;
		this._opt1 = opt1;
		this._opt2 = opt2;
		this._opt3 = opt3;
		this._opt4 = opt4;
		this._opt5 = opt5;
		this.correctAnswer = actualAnswer;
	}

	public String getName() { return _name; }

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_opt1() {
		return _opt1;
	}

	public void set_opt1(String _opt1) {
		this._opt1 = _opt1;
	}

	public String get_opt2() {
		return _opt2;
	}

	public void set_opt2(String _opt2) {
		this._opt2 = _opt2;
	}

	public String get_opt3() {
		return _opt3;
	}

	public void set_opt3(String _opt3) {
		this._opt3 = _opt3;
	}

	public String get_opt4() {
		return _opt4;
	}

	public void set_opt4(String _opt4) {
		this._opt4 = _opt4;
	}

	public String get_opt5() {
		return _opt5;
	}

	public void set_opt5(String _opt5) {
		this._opt5 = _opt5;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswerIn) {
		this.correctAnswer = correctAnswerIn;
	}
	
	public boolean isCorrect(String userAnswerIn) {
		
		return (this.correctAnswer.equals(userAnswerIn));
	}
	
}
