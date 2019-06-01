package eduGameApp.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;

public class indexValidator implements Validator {

	UserRepo userRepo;
	
	public indexValidator(UserRepo userRepository) {
		this.userRepo = userRepository;
	}
	public boolean supports(Class<?> clazz) {
		return IndexFormDto.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		IndexFormDto userDto = (IndexFormDto) target;
		if (userDto.getUsername().toLowerCase().equals("guest")) {
			errors.rejectValue("username","",userDto.getUsername() + " is not a valid login.");
		} else {
			User actualUser = userRepo.findByUsername(userDto.getUsername());
			
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "" ,"Field cannot be empty.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "" ,"Field cannot be empty.");
		
			
			
			if (actualUser == null && !userDto.getPassword().isEmpty() && !userDto.getUsername().isEmpty()){
				errors.rejectValue("username", "", "User not found");
			} else if (!userDto.getUsername().isEmpty() && !userDto.getPassword().isEmpty()
					&& (!actualUser.getPassword().equals(userDto.getPassword()))
				) {
				
				errors.rejectValue("username","","Wrong username or password.");
			}
		}
		
		
		
	}
}
