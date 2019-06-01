package eduGameApp.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;

public class PassRecoveryValidator implements Validator {
	UserRepo userRepo;
	
	
	public PassRecoveryValidator(UserRepo userRepository) {
		this.userRepo = userRepository;
	}
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		User userDto = (User) target;
		
		if (EducationalGameApplication.getPasswordResetSection() == 0) { // On the first password reset screen
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "" ,"Field cannot be empty.");
			if (!userDto.getUsername().isEmpty() && userRepo.findByUsername(userDto.getUsername()) == null) {
				errors.rejectValue("username","","Username was not found.");
			}
		} else if (EducationalGameApplication.getPasswordResetSection() == 1) {// On the second password reset screen
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"securityAnswer", "" ,"Field cannot be empty.");
			if (!userDto.getSecurityAnswer().isEmpty() && !userRepo.findByUsername(EducationalGameApplication.getPasswordResetUsername()).getSecurityAnswer().equals(userDto.getSecurityAnswer())) {
				errors.rejectValue("securityAnswer","","Answer was incorrect.");
			}
		} else if (EducationalGameApplication.getPasswordResetSection() == 2) {// On {// On the last password reset screen
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "" ,"Field cannot be empty.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password2", "" ,"Field cannot be empty.");
			if ((!userDto.getPassword().equals(userDto.getPassword2())) && 
					!userDto.getPassword().isEmpty() && !userDto.getPassword2().isEmpty() ) {
				
				
				errors.rejectValue("password", "","Passwords must match.");
			} else {
				if (userDto.passwordFormatTest(userDto.getPassword()) == false) {
					errors.rejectValue("password", "", "4-8 characters, no numbers or symbols.");
				}
			}
		}
		
		
		
		
		
		
	}

}
