package eduGameApp.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import eduGameApp.EducationalGameApplication;

public class EnglishQuestions {
	private HashMap<Integer,String> easyNames = new HashMap<Integer,String>();
	private HashMap<Integer,String> hardNames = new HashMap<Integer,String>();
	
	
	public EnglishQuestions() {
		int num = 0;
		for (String i : Arrays.asList("baby.png","ball.png","bee.png","blue.png","boat.png","boy.png","bus.png","car.png","cat.png","cow.png","deer.jpeg","dog.png","egg.png","fish.png","frog.png","girl.jpg","hat.png","lamp.png","lion.jpeg","moon.png","pig.png","red.png","sea.jpeg","sun.jpeg","tree.png")) {
			easyNames.put(num, i);
			num++;
		}
		num = 0;
		for (String i : Arrays.asList("apple.png","beach.png","board.png","chair.png","clock.png","clown.png","Earth.png","glasses.png","horse.png","lemon.png","light.png","parrot.jpeg","peach.png","plane.png","puzzle.png","rainbow.png","rhino.jpeg","screen.jpeg","shark.png","table.png","teddy.png","tennis.png","wallet.png","watch.png","zebra.png")) {
			hardNames.put(num, i);
			num++;
		}
		
	}
	
	public EnglishQuestionPair getEasyQuestion() {
		String newName = "";
		String opt1 = "";
		String opt2 = "";
		String opt3 = "";
		String opt4 = "";
		String actualAnswer ="";
		HashSet<String> options = new HashSet<String>();
		Random rand = new Random();
		int choice = -1;
		for (int i = 0; i<4; i++) {
			choice = rand.nextInt((easyNames.size()-1)+1);
			boolean found = false;
			while (!found) {
				try {
					String option = easyNames.get(choice).split("\\.")[0];
					while (EducationalGameApplication.getAskedQuestions().contains(option)) {
						choice = rand.nextInt((easyNames.size()-1)+1);
						option = easyNames.get(choice).split("\\.")[0];
					} 
					HashSet<String> newOptions = EducationalGameApplication.getAskedQuestions();
					newOptions.add(option);
					EducationalGameApplication.setAskedQuestions(newOptions);
					options.add(option);
					found = true;
				} catch (Exception e) {
					choice = rand.nextInt((easyNames.size()-1)+1);
				}
			}
			
			if (i == 0) {
				// The randomly generated name is also the name in the question
				newName = "Easy/"+easyNames.get(choice);
				actualAnswer = easyNames.get(choice).split("\\.")[0];
				
			}
			easyNames.remove(choice);
			
		}
		
		int i = 0;
		for (String j : options) {
			switch (i) {
			case 0:
				opt1 = j;
			case 1:
				opt2 = j;
			case 2:
				opt3 = j;
			default:
				opt4 = j;
			}
			i++;
		}
		
		return new EnglishQuestionPair(newName,opt1,opt2,opt3,opt4,actualAnswer);
	}
	
	public EnglishQuestionPair getHardQuestion() {
		String newName = "";
		String opt1 = "";
		String opt2 = "";
		String opt3 = "";
		String opt4 = "";
		String opt5 = "";
		String actualAnswer ="";
		HashSet<String> options = new HashSet<String>();
		Random rand = new Random();
		int choice = -1;
		for (int i = 0; i<5; i++) {
			choice = rand.nextInt((hardNames.size()-1)+1);
			boolean found = false;
			while (!found) {
				try {
					String option = hardNames.get(choice).split("\\.")[0];
					while (EducationalGameApplication.getAskedQuestions().contains(option)) {
						choice = rand.nextInt((hardNames.size()-1)+1);
						option = hardNames.get(choice).split("\\.")[0];
					} 
					HashSet<String> newOptions = EducationalGameApplication.getAskedQuestions();
					newOptions.add(option);
					EducationalGameApplication.setAskedQuestions(newOptions);
					options.add(option);
					found = true;
				} catch (Exception e) {
					choice = rand.nextInt((hardNames.size()-1)+1);
				}
			}
			
			if (i == 0) {
				// The randomly generated name is also the name in the question
				newName ="Hard/"+ hardNames.get(choice).replace(" ", "-");
				actualAnswer =hardNames.get(choice).split("\\.")[0];
			}
			hardNames.remove(choice);
			
		}
		
		int i = 0;
		for (String j : options) {
			switch (i) {
			case 0:
				opt1 = j;
			case 1:
				opt2 = j;
			case 2:
				opt3 = j;
			case 3:
				opt4 = j;
			default:
				opt5 = j;
			}
			i++;
		}
		
		return new EnglishQuestionPair(newName,opt1,opt2,opt3,opt4,opt5,actualAnswer);
	}

	
}
