package eduGameApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.DelayThread;
import eduGameApp.domain.EnglishQuestionPair;
import eduGameApp.domain.EnglishQuestions;

@Controller
@RequestMapping("/english")
public class EnglishController {
	private EnglishQuestions englishQuestions = new EnglishQuestions();
	private EnglishQuestionPair pair;
	@RequestMapping(value="/")
	public String english(Model model, @ModelAttribute("pojo") String pojo,RedirectAttributes rattrs) {
		if (!pojo.equals("question")) {
			return "redirect:/";
		}
		englishQuestions = new EnglishQuestions();
		
		if (EducationalGameApplication.isStartedEnglish() == false) {
			model.addAttribute("easyMode",false);
			
		}
		if ((EducationalGameApplication.getCounter() < 4 && EducationalGameApplication.isStartedEnglish()) || (EducationalGameApplication.getCounter() < 8 && !EducationalGameApplication.isStartedEnglish())) { // Easy
			model.addAttribute("timerStart", "14");
			model.addAttribute("timerDisplay", "15");
			model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());
			
			pair = englishQuestions.getEasyQuestion();
			model.addAttribute("name",pair.getName());
			model.addAttribute("opt1",pair.get_opt1());
			model.addAttribute("opt2",pair.get_opt2());
			model.addAttribute("opt3",pair.get_opt3());
			model.addAttribute("opt4",pair.get_opt4());
			model.addAttribute("answer", pair.getCorrectAnswer());
			model.addAttribute("hasQuestion",false);
			model.addAttribute("score",EducationalGameApplication.getEnglishScore());
			if (EducationalGameApplication.isStartedEnglish() == false) {
				model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
			}
			int qnum = EducationalGameApplication.getCounter() +1;
			if (EducationalGameApplication.isStartedEnglish() == false) {
				qnum -= 4;
			}
			model.addAttribute("questionNum",qnum);
			if (EducationalGameApplication.isStartedEnglish() == false) {
				model.addAttribute("easyMode",false);
			} else {
				model.addAttribute("easyMode",true);
			}
			model.addAttribute("title","Easy");
			EducationalGameApplication.setCounter(EducationalGameApplication.getCounter() +1);
			
			return "english";
		} else if ((EducationalGameApplication.getCounter2() < 4 && EducationalGameApplication.isStartedEnglish()) || (EducationalGameApplication.getCounter2() < 8 && !EducationalGameApplication.isStartedEnglish())) { // Hard
			model.addAttribute("timerStart", "11");
			model.addAttribute("timerDisplay", "12");
			model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());
			
			pair = englishQuestions.getHardQuestion();
			model.addAttribute("name", pair.getName());
			model.addAttribute("opt1", pair.get_opt1());
			model.addAttribute("opt2", pair.get_opt2());
			model.addAttribute("opt3", pair.get_opt3());
			model.addAttribute("opt4", pair.get_opt4());
			model.addAttribute("opt5", pair.get_opt5());
			model.addAttribute("answer", pair.getCorrectAnswer());
			model.addAttribute("hasQuestion",true);
			model.addAttribute("score",EducationalGameApplication.getEnglishScore());
			if (EducationalGameApplication.isStartedEnglish() == false) {
				model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
			}
			model.addAttribute("easyMode",false);
			int qnum = EducationalGameApplication.getCounter2() +1;
			if (EducationalGameApplication.isStartedEnglish() == false) {
				qnum -= 4;
			}
			model.addAttribute("questionNum",qnum);
			model.addAttribute("title","Hard");
			EducationalGameApplication.setCounter2(EducationalGameApplication.getCounter2() +1);
			
			return "english";
		} else { // End
			if (EducationalGameApplication.isStartedEnglish()) {
			    rattrs.addFlashAttribute("pojo", "question");
				return "redirect:/english/progress";
			} else {
				rattrs.addFlashAttribute("pojo", "question");
				return "redirect:/summary/";
			}
		}
		
		
	}
	@RequestMapping(value="answer", params = "opt1", method = RequestMethod.POST)
	public String opt1(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		
		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (pair.isCorrect(pair.get_opt1())) {
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
			
		}
	    rattrs.addFlashAttribute("pojo", "question");
	    
	    DelayThread.delay(400);
		return "redirect:/english/";
	}
	@RequestMapping(value="answer", params = "opt2", method = RequestMethod.POST)
	public String opt2(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		
		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (pair.isCorrect(pair.get_opt2())) {
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
			
		}
	    rattrs.addFlashAttribute("pojo", "question");
	    
	    DelayThread.delay(400);
		return "redirect:/english/";
	}
	@RequestMapping(value="answer", params = "opt3", method = RequestMethod.POST)
	public String opt3(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		
		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (pair.isCorrect(pair.get_opt3())) {
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
			
		}
	    rattrs.addFlashAttribute("pojo", "question");
	    
	    DelayThread.delay(400);
		return "redirect:/english/";
	}
	@RequestMapping(value="answer", params = "opt4", method = RequestMethod.POST)
	public String opt4(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		
		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (pair.isCorrect(pair.get_opt4())) {
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
			
		}
	    rattrs.addFlashAttribute("pojo", "question");
	    
	    DelayThread.delay(400);
		return "redirect:/english/";
	}
	@RequestMapping(value="answer", params = "opt5", method = RequestMethod.POST)
	public String opt5(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		
		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (pair.isCorrect(pair.get_opt5())) {
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
			
		}
	    rattrs.addFlashAttribute("pojo", "question");
	    
	    DelayThread.delay(400);
		return "redirect:/english/";
	}
	
	@RequestMapping(value="/skip")
	public String skip(Model model,RedirectAttributes rattrs) {
		if (EducationalGameApplication.getCounter2() == 0 && ((EducationalGameApplication.getCounter() <= 4 
				&& EducationalGameApplication.isStartedEnglish()) || (EducationalGameApplication.getCounter() <= 8 
				&& !EducationalGameApplication.isStartedEnglish()))) {
		
		} else {
			EducationalGameApplication.setTimerRemaining(0);
		}
		
	    rattrs.addFlashAttribute("pojo", "question");
		return "redirect:/english/";
	}
	
	@RequestMapping(value="/progress")
	public String progress(Model model, @ModelAttribute("pojo") String pojo) {
		if (!pojo.equals("question")) {
			return "redirect:/";
		}
		model.addAttribute("Destination","Maths");

		return "SubjectTransition";
	}
	

}
