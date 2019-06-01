package eduGameApp.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;

@Controller
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private UserRepo userRepo;
	
	private List<String> questions = Arrays.asList("----------",
			"What is your favourite colour?",
			"What is your favourite pet?",
			"Who is your hero?",
			"What is your favourite subject?",
			"What is your favourite food?");
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserSignupValidator(userRepo));
	}
	@RequestMapping("/")
	public String signup(@ModelAttribute("user") User user,Model model) {
		model.addAttribute("score", "0");
		model.addAttribute("questionsList", (List<String>) this.questions);
		return "signup";
	}
	

	@RequestMapping(value="add", params="add", method= RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,Model model) {
		//-- 2 options (Redirect if errors or proceed to main if no errors)
		if (result.hasErrors()) {
			model.addAttribute("questionsList", (List<String>) this.questions);
			model.addAttribute("selectedQuestion",user.getSecurityQuestion());
			return "signup";
			
		} else {
			userRepo.save(user);
			EducationalGameApplication.setUser(user);
			return "redirect:/main/";
		}
	}
	
	@RequestMapping(value="all")
	@ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepo.findAll();
	}

	@RequestMapping(value="add", params = "cancel", method = RequestMethod.POST)
	public String cancelRegistration(@ModelAttribute("user") User user, Model model) {
		return "redirect:/";
	}

}
