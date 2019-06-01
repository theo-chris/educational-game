package eduGameApp.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;



@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
    private UserRepo userRepo;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new indexValidator(userRepo));
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("indexFormDto", new IndexFormDto());
		if (EducationalGameApplication.getUser() != null) {
			return "redirect:/main/";
		}
	    return "Landing";
	}
	
	 
    @RequestMapping("/login")
    public String login(@ModelAttribute("indexFormDto") IndexFormDto indexFormDto) {
		if (EducationalGameApplication.getUser() != null) {
			return "redirect:/main/";
		}
    	

	  return "index";
    
    }
   
    @RequestMapping(value = "/main",params="login", method = RequestMethod.POST)
    public String main(@Valid @ModelAttribute("indexFormDto") IndexFormDto indexFormDto,BindingResult result,Model model){
    	
    	
	    	if(result.hasErrors()) {
	    		return "index";
	    	}
	    	else {
		    	EducationalGameApplication.setUser(userRepo.findByUsername(indexFormDto.getUsername()));
		    	return "redirect:/main/";
	    	}
    }
  
    
    @RequestMapping(value = "/main",params="signup", method = RequestMethod.POST)
    public String signup(Model model){
    	
	    	return "redirect:/signup/";
    }
    @RequestMapping(value = "/main", params="guest",method = RequestMethod.POST)
    public String loginGuest( @ModelAttribute("indexFormDto") IndexFormDto indexFormDto,Model model){
		if (userRepo.findByUsername("Guest") == null) {
			userRepo.save(new User(-1,"Guest","Guest","Guest","Guest","Guest","Guest","Guest"));
		}
		EducationalGameApplication.setUser(userRepo.findByUsername("Guest"));
	    	return "redirect:/main/";
    }
    
    @RequestMapping(value = "/guest")
    public String guest(Model model){
		if (userRepo.findByUsername("Guest") == null) {
			userRepo.save(new User(-1,"Guest","Guest","Guest","Guest","Guest","Guest","Guest"));
		}
		EducationalGameApplication.setUser(userRepo.findByUsername("Guest"));
	    	return "redirect:/main/";
    }
    
    @RequestMapping(value= "/main", params="passwordRecovery", method = RequestMethod.POST)
    public String forgotPassword(Model model){
	    	
	    	return "redirect:/passwordRecovery/";
    }
    
    @RequestMapping(value= "/logout", method = RequestMethod.POST)
    public String logout(Model model){
	    	EducationalGameApplication.setUser(null);
	    	return "redirect:/";
    }

	
	@RequestMapping(value="/progress-english")
	public String progressEnglish(Model model,RedirectAttributes rattrs) {
		EducationalGameApplication.setEnglishScore(0);
	    rattrs.addFlashAttribute("pojo", "question");

		return "redirect:/english/";
	}
	
	@RequestMapping(value="/progress-maths")
	public String progressMaths(Model model,RedirectAttributes rattrs) {
		EducationalGameApplication.setMathScore(0);
	    rattrs.addFlashAttribute("pojo", "question");

		return "redirect:/maths/";
	}
    
    

}