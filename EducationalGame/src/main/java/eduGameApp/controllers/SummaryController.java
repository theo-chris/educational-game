package eduGameApp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.User;
import eduGameApp.domain.UserScoreComparator;
import eduGameApp.repository.UserRepo;

@Controller
@RequestMapping("/summary")
public class SummaryController {
	@Autowired private UserRepo userRepo;
	
	private Integer maths = 0;
	private Integer english = 0;
	private Integer bonus = 0;
	
	private List<String> questions = Arrays.asList("----------",
			"What is your favourite colour?",
			"What is your favourite pet?",
			"Who is your hero?",
			"What is your favourite subject?",
			"What is your favourite food?");
	
	
	@RequestMapping("/")
    public String main(Model model, @ModelAttribute("pojo") String pojo) {
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		if (!pojo.equals("question")) {
			return "redirect:/";
		}
		User highest = null;
		for (User user : userRepo.findAll()) {
			if (!user.getUsername().equals("Guest") && (highest == null || highest.getHighScore() <= user.getHighScore())) {
				highest = user;
			}
		}
		bonus = EducationalGameApplication.getTimerRemaining()/5;
		User toUpdate = userRepo.findByUsername(EducationalGameApplication.getUser().getUsername());
		if (!EducationalGameApplication.getUser().getUsername().equals("Guest")) {
			if (toUpdate.getHighScore() == null || toUpdate.getHighScore() <= (EducationalGameApplication.getMathScore() + EducationalGameApplication.getEnglishScore() + bonus)) {
				toUpdate.setHighScore(EducationalGameApplication.getMathScore() + EducationalGameApplication.getEnglishScore() + bonus);
				userRepo.save(toUpdate);
			}
			model.addAttribute("HighestScore", toUpdate.getHighScore());
			if (highest.getHighScore() <= (EducationalGameApplication.getMathScore() + EducationalGameApplication.getEnglishScore() + bonus)) {
				model.addAttribute("HighestScoreEver", toUpdate.getHighScore()+" by "+toUpdate.getUsername());
			} else {
				model.addAttribute("HighestScoreEver", highest.getHighScore()+" by "+highest.getUsername());
			}
			
		} else {
			model.addAttribute("HighestScore", "NONE");
			model.addAttribute("HighestScoreEver", highest.getHighScore()+" by "+highest.getUsername());
		}
		model.addAttribute("UserName", EducationalGameApplication.getUser().getUsername());
		model.addAttribute("EnglishScore", EducationalGameApplication.getEnglishScore());
		model.addAttribute("MathsScore", EducationalGameApplication.getMathScore());
		
		model.addAttribute("bonus", EducationalGameApplication.getTimerRemaining()/5);

		this.maths = EducationalGameApplication.getMathScore();
		this.english = EducationalGameApplication.getEnglishScore();
		
		EducationalGameApplication.setMathScore(0);
		EducationalGameApplication.setEnglishScore(0);
        return "Summary";
    }
	
	@RequestMapping("/signup")
    public String signup(@ModelAttribute("user") User user,Model model) {
		model.addAttribute("score", english+maths+bonus);
		model.addAttribute("questionsList", (List<String>) this.questions);
		return "signup";
	}
}
