package eduGameApp.controllers;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;

public class UserSignupValidator implements Validator{
	UserRepo userRepo;
	
	
	public UserSignupValidator(UserRepo userRepository) {
		this.userRepo = userRepository;
	}
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		User userDto= (User) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName", "" ,"Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName", "" ,"Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "" ,"Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "" ,"Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password2", "" ,"Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"securityAnswer", "" ,"Field cannot be empty.");
		
		if (userDto.nameFormatTest(userDto.getFirstName()) == false && !userDto.getFirstName().isEmpty()) {
			errors.rejectValue("firstName", "", "Use just letters.");
		}
		if (userDto.nameFormatTest(userDto.getLastName()) == false && !userDto.getLastName().isEmpty()) {
			errors.rejectValue("lastName", "", "Use just letters.");
		}
		if (userDto.getSecurityQuestion().equals("----------")) {
			errors.rejectValue("securityQuestion", "", "Please select a security question.");
		}
		
		
		if ((!userDto.getPassword().equals(userDto.getPassword2())) && 
				!userDto.getPassword().isEmpty() && !userDto.getPassword2().isEmpty() ) {
			
			
			errors.rejectValue("password", "","Passwords must match.");
		} else {
			if (userDto.passwordFormatTest(userDto.getPassword()) == false) {
				errors.rejectValue("password", "", "4-8 characters, no numbers or symbols.");
			}
		}
		
		
		if (userRepo.findByUsername(userDto.getUsername()) != null && !userDto.getUsername().toLowerCase().equals("guest")) {
			errors.rejectValue("username", "","Username already exists.");
		}
		if (userDto.getUsername().toLowerCase().equals("guest") || userDto.getUsername().toLowerCase().contains("guest")) {
			errors.rejectValue("username", "","Cannot use username "+userDto.getUsername()+".");
		}
		if (userDto.usernameFormatTest(userDto.getUsername()) == false) {
			errors.rejectValue("username", "","4-12 characters or numbers, no symbols");
		}
	
		
		
		
		
	}

}
