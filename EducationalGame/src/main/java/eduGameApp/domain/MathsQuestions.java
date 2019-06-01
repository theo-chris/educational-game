package eduGameApp.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class MathsQuestions {
	private int x,y,answer;
	private int opt1,opt2,opt3,opt4;
	private String operator;
	private int score = 0;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void EasyQuestion() {
		Random rand = new Random();
		int choice = rand.nextInt(2) + 1;
		if (choice == 1) {
			this.operator = "+";
			this.EasyAdditionQuestion();
		} else {
			this.operator = "-";
			this.EasySubtractionQuestion();
		}
	}
	
	public void HardQuestion() {
		Random rand = new Random();
		int choice = rand.nextInt(2) + 1;
		if (choice == 1) {
			this.operator = "+";
			this.HardAdditionQuestion();
		} else {
			this.operator = "-";
			this.HardSubtractionQuestion();
		}
	}
	
	private void EasyAdditionQuestion() {
		Random rand = new Random();
		this.x = rand.nextInt(9) + 1;
		this.y = rand.nextInt(9) + 1;
		this.answer = this.x + this.y;
		
		this.getChoices(this.answer);
	}

	private void HardAdditionQuestion() {
		Random rand = new Random();
		this.x = rand.nextInt(99 - 10 + 1) + 10;
		this.y = rand.nextInt(99 - 10 + 1) + 10;
		this.answer = this.x + this.y;
		
		this.getChoices(this.answer);
	}
	
	private void EasySubtractionQuestion() {
		Random rand = new Random();
		this.x = rand.nextInt(9) + 1;
		this.y = rand.nextInt(this.x) + 1;
		this.answer = this.x - this.y;
		
		this.getChoices(this.answer);
	}
	
	private void HardSubtractionQuestion() {
		Random rand = new Random();
		this.x = rand.nextInt(99 - 10 + 1 ) + 10;
		this.y = rand.nextInt(this.x- 10 + 1) + 10;
		this.answer = this.x - this.y;
		
		this.getChoices(this.answer);
	}
	
	public boolean isCorrect(int answerIn) {
		
		return (this.answer == answerIn);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAnswer() {
		if (getOperator() == "+") {
			
			return getX() + getY();
		
		}else {
			return getX() - getY();
		}
	}

	public void setAnswer(int answer) {
		
		this.answer = answer;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public int getOpt1() {
		return opt1;
	}

	public void setOpt1(int opt1) {
		this.opt1 = opt1;
	}

	public int getOpt2() {
		return opt2;
	}

	public void setOpt2(int opt2) {
		this.opt2 = opt2;
	}

	public int getOpt3() {
		return opt3;
	}

	public void setOpt3(int opt3) {
		this.opt3 = opt3;
	}

	public int getOpt4() {
		return opt4;
	}

	public void setOpt4(int opt4) {
		this.opt4 = opt4;
	}

	private List<Integer> toList(int[] values) {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i : values) {
			temp.add(i);
		}
		return temp;
	}
	
	private void getChoices(int answer) {
		int lowest;
		int highest;
		if (answer-4 < 0) {
			lowest = 0;
			highest = 8;
		} else {
			lowest = answer-4;
			highest = answer+5;
		}
		List<Integer> values = this.toList(IntStream.range(lowest, highest).toArray());
		
		List<Integer> choices = new ArrayList<Integer>();
		
		if (answer-4 < 0) {
			choices.add(values.get(4+(answer-4)));
			values.remove(4+(answer-4));
		} else {
			choices.add(values.get(4));
			values.remove(4);
		}
		
		
		Random rand = new Random();
		
		int index = rand.nextInt(values.size()-1);
		choices.add(values.get(index));
		values.remove(index);
		
		index = rand.nextInt(values.size()-1);
		choices.add(values.get(index));
		values.remove(index);
		
		index = rand.nextInt(values.size()-1);
		choices.add(values.get(index));
		values.remove(index);
		
		
		
		
		index = rand.nextInt(choices.size());
		this.opt1 = choices.get(index);
		choices.remove(index);

		index = rand.nextInt(choices.size());
		this.opt2 = choices.get(index);
		choices.remove(index);

		index = rand.nextInt(choices.size());
		this.opt3 = choices.get(index);
		choices.remove(index);

		this.opt4 = choices.get(0);
		
	}

}
