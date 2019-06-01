package eduGameApp.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduGameApp.EducationalGameApplication;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("/")
    public String main(Model model) {
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		model.addAttribute("username",  EducationalGameApplication.getUser().getUsername());
        return "main";
    }
	
	@RequestMapping(value="/start-maths/")
	public String startMaths(Model model,RedirectAttributes rattrs) {
		EducationalGameApplication.setMathScore(0);
		EducationalGameApplication.setCounter(0);
		EducationalGameApplication.setCounter2(0);
		EducationalGameApplication.setTimerRemaining(0);
		EducationalGameApplication.setStartedEnglish(false);
	    rattrs.addFlashAttribute("pojo", "question");

		return "redirect:/maths/";
	}
	
	@RequestMapping(value="/start-english/")
	public String startEnglish(Model model,RedirectAttributes rattrs) {
		EducationalGameApplication.setCounter(0);
		EducationalGameApplication.setCounter2(0);
		EducationalGameApplication.setTimerRemaining(0);
		EducationalGameApplication.setEnglishScore(0);
		EducationalGameApplication.setStartedEnglish(true);
		EducationalGameApplication.setAskedQuestions(new HashSet<String>());
	    rattrs.addFlashAttribute("pojo", "question");

		return "redirect:/english/";
	}
	
	@RequestMapping("english")
	public String english(Model model) {
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		return "redirect:/english/";
	}

}
