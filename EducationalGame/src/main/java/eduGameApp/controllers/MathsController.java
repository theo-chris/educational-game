package eduGameApp.controllers;


import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.DelayThread;
import eduGameApp.domain.MathsQuestions;

@Controller
@RequestMapping("/maths")
public class MathsController {
	private MathsQuestions mathsQuestions = new MathsQuestions();
	
	@RequestMapping(value="/")
    public String maths(Model model, @ModelAttribute("pojo") String pojo, @ModelAttribute("MathsQuestions") MathsQuestions mathsQuestions,RedirectAttributes rattrs) {
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		if (!pojo.equals("question")) {
			return "redirect:/";
		}
		
		if ((EducationalGameApplication.getCounter() < 4 && !EducationalGameApplication.isStartedEnglish()) || (EducationalGameApplication.getCounter() < 8 && EducationalGameApplication.isStartedEnglish())) { // change to see if easy question is selected
			model.addAttribute("timerStart", "14");
			model.addAttribute("timerDisplay", "15");
			model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());
			mathsQuestions.EasyQuestion();
			EducationalGameApplication.setMathsQuestions(mathsQuestions);
			model.addAttribute("x", mathsQuestions.getX());
			model.addAttribute("operator", mathsQuestions.getOperator());
			model.addAttribute("y", mathsQuestions.getY());
			model.addAttribute("opt1", mathsQuestions.getOpt1());
			model.addAttribute("opt2", mathsQuestions.getOpt2());
			model.addAttribute("opt3", mathsQuestions.getOpt3());
			model.addAttribute("opt4", mathsQuestions.getOpt4());
			model.addAttribute("answer", mathsQuestions.getAnswer());
			int qnum = EducationalGameApplication.getCounter() +1;
			if (EducationalGameApplication.isStartedEnglish()) {
				qnum -= 4;
			}
			model.addAttribute("questionNum",qnum);
			model.addAttribute("title","Easy");
			model.addAttribute("score",EducationalGameApplication.getMathScore());
			if (EducationalGameApplication.isStartedEnglish() == true) {
				model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
			}
			if (EducationalGameApplication.isStartedEnglish() == true) {
				model.addAttribute("easyMode",false);
			} else {
				model.addAttribute("easyMode",true);
			}
			
			
			EducationalGameApplication.setCounter(EducationalGameApplication.getCounter() +1);
			

	        return "maths";
		} else if ((EducationalGameApplication.getCounter2() < 4 && !EducationalGameApplication.isStartedEnglish()) || (EducationalGameApplication.getCounter2() < 8 && EducationalGameApplication.isStartedEnglish())){
			model.addAttribute("timerStart", "11");
			model.addAttribute("timerDisplay", "12");
			model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());
		
			mathsQuestions.HardQuestion();
			EducationalGameApplication.setMathsQuestions(mathsQuestions);
			model.addAttribute("x", mathsQuestions.getX());
			model.addAttribute("operator", mathsQuestions.getOperator());
			model.addAttribute("y", mathsQuestions.getY());
			model.addAttribute("opt1", mathsQuestions.getOpt1());
			model.addAttribute("opt2", mathsQuestions.getOpt2());
			model.addAttribute("opt3", mathsQuestions.getOpt3());
			model.addAttribute("opt4", mathsQuestions.getOpt4());
			model.addAttribute("answer", mathsQuestions.getAnswer());
			int qnum = EducationalGameApplication.getCounter2() +1;
			if (EducationalGameApplication.isStartedEnglish()) {
				qnum -= 4;
			}
			model.addAttribute("questionNum",qnum);
			model.addAttribute("title","Hard");
			model.addAttribute("score",EducationalGameApplication.getMathScore());
			if (EducationalGameApplication.isStartedEnglish()) {
				model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
			}
			EducationalGameApplication.setCounter2(EducationalGameApplication.getCounter2() + 1);
			model.addAttribute("easyMode",false);

			return "maths";
			
		}else {
			if (EducationalGameApplication.isStartedEnglish()) {

				rattrs.addFlashAttribute("pojo", "question");
				return "redirect:/summary/";
			} else {
				rattrs.addFlashAttribute("pojo", "question");
				return "redirect:/maths/progress";
			}
			
		}
    }
	
	@RequestMapping(value="answer", params = "opt1", method = RequestMethod.POST)
	public String opt1(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		this.mathsQuestions = EducationalGameApplication.getMathsQuestions();
		

		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (mathsQuestions.isCorrect(mathsQuestions.getOpt1())) { 
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setMathScore(EducationalGameApplication.getMathScore()+1);
		}
	    rattrs.addFlashAttribute("pojo", "question");
	    
	    
		DelayThread.delay(400);
		return "redirect:/maths/";
	}
	
	@RequestMapping(value="answer", params = "opt2", method = RequestMethod.POST)
	public String opt2(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		this.mathsQuestions = EducationalGameApplication.getMathsQuestions();

		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (mathsQuestions.isCorrect(mathsQuestions.getOpt2())) {
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setMathScore(EducationalGameApplication.getMathScore()+1);
		}
	    rattrs.addFlashAttribute("pojo", "question");
		DelayThread.delay(400);
		return "redirect:/maths/";
	}
	
	@RequestMapping(value="answer", params = "opt3", method = RequestMethod.POST)
	public String opt3(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		this.mathsQuestions = EducationalGameApplication.getMathsQuestions();

		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (mathsQuestions.isCorrect(mathsQuestions.getOpt3())) {	
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setMathScore(EducationalGameApplication.getMathScore()+1);
		}
	    rattrs.addFlashAttribute("pojo", "question");
		DelayThread.delay(400);
		return "redirect:/maths/";
	}
	
	@RequestMapping(value="answer", params = "opt4", method = RequestMethod.POST)
	public String opt4(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		this.mathsQuestions = EducationalGameApplication.getMathsQuestions();
		
		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (mathsQuestions.isCorrect(mathsQuestions.getOpt4())) {
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setMathScore(EducationalGameApplication.getMathScore()+1);
		}
	    rattrs.addFlashAttribute("pojo", "question");
		DelayThread.delay(400);
		return "redirect:/maths/";
	}
	
	@RequestMapping(value="/skip")
	public String skip(Model model,RedirectAttributes rattrs) {
		if (EducationalGameApplication.getCounter2() == 0 &&(EducationalGameApplication.getCounter() <= 4 && 
				!EducationalGameApplication.isStartedEnglish()) || (EducationalGameApplication.getCounter() <= 8 &&
				EducationalGameApplication.isStartedEnglish())) {
		} else {
			EducationalGameApplication.setTimerRemaining(0);
		}
	    rattrs.addFlashAttribute("pojo", "question");
		return "redirect:/maths/";
	}
	
	@RequestMapping(value="/progress")
	public String progress(Model model, @ModelAttribute("pojo") String pojo) {
		if (!pojo.equals("question")) {
			return "redirect:/";
		}
		model.addAttribute("Destination","English");
		EducationalGameApplication.setAskedQuestions(new HashSet<String>());

		return "SubjectTransition";
	}
}
