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

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;


@Controller
@RequestMapping("/passwordRecovery")
public class passRecoveryController {
	
		@Autowired
		private UserRepo userRepo;

		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			binder.addValidators(new PassRecoveryValidator(userRepo));
		}
		
		
		@RequestMapping("/")
		public String passRecovery(@ModelAttribute("user") User user,Model model) {
			EducationalGameApplication.setPasswordResetSection(0);
			return "passwordRecovery";
		}
		

		@RequestMapping(value ="/securityQuestion", method= RequestMethod.POST)
		public String securityQuestion(@Valid @ModelAttribute("user") User user,BindingResult result, Model model) {
			if(!result.hasErrors()) {
				EducationalGameApplication.setPasswordResetUsername(user.getUsername());
				User toReset = userRepo.findByUsername(user.getUsername());
				model.addAttribute("securityQuestion",toReset.getSecurityQuestion());

				EducationalGameApplication.setPasswordResetSection(1);
				
				return "securityQ";
			} else {

				EducationalGameApplication.setPasswordResetSection(0);
				return "passwordRecovery";
			}
			
			
		}
		@RequestMapping("/resetPassword")
		public String forgotPassword(@Valid @ModelAttribute("user") User user,BindingResult result,Model model){
			if(!result.hasErrors()) {
				EducationalGameApplication.setPasswordResetSection(2);
				return "newPassword";
				
			} else {
				EducationalGameApplication.setPasswordResetSection(1);
				User toReset = userRepo.findByUsername(EducationalGameApplication.getPasswordResetUsername());
				model.addAttribute("securityQuestion",toReset.getSecurityQuestion());
				
				return "securityQ";
			}
			
	    }
		@RequestMapping("/resetPasswordSuccess")
		public String forgotPasswordToMain(@Valid @ModelAttribute("user") User user,BindingResult result,Model model){
			if(!result.hasErrors()) {
				User toReset = userRepo.findByUsername(EducationalGameApplication.getPasswordResetUsername());
				toReset.setPassword(user.getPassword());
				toReset.setPassword2(user.getPassword2());
				userRepo.save(toReset);

				EducationalGameApplication.setPasswordResetSection(-1);
				return "redirect:/";
			} else {
				return "newPassword";
			}
			
	    }
		    


}
