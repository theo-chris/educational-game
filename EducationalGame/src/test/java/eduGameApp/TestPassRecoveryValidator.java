package eduGameApp;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.validation.BeanPropertyBindingResult;

import eduGameApp.EducationalGameApplication;
import eduGameApp.controllers.PassRecoveryValidator;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;

import static org.mockito.BDDMockito.given;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
public class TestPassRecoveryValidator {
	 @MockBean
	  private UserRepo repository;
	 @Test 
	  public void usernameFieldEmpty(){
		 given(repository.findByUsername("Username"))
         .willReturn(null);
		 EducationalGameApplication.setPasswordResetSection(0);
		 User userToValidate = new User();    
		    userToValidate.setUsername("");
		    
		    PassRecoveryValidator v = new PassRecoveryValidator(repository);  
		    BeanPropertyBindingResult errors = 
		    		new BeanPropertyBindingResult(userToValidate, "userToValidate");
		    v.validate(userToValidate, errors);
		    assertTrue(errors.hasErrors());
	 }
	 @Test 
	  public void usernameNotFound(){
		 given(repository.findByUsername("Username")).willReturn(null);
		 
		 EducationalGameApplication.setPasswordResetSection(0);
		 User userToValidate = new User();    		   
		    userToValidate.setUsername("non-existingUsername");
		    
		    PassRecoveryValidator v = new PassRecoveryValidator(repository);  
		    BeanPropertyBindingResult errors = 
		    		new BeanPropertyBindingResult(userToValidate, "userToValidate");
		    v.validate(userToValidate, errors);
		    assertTrue(errors.hasErrors());
	 }
	 @Test 
	  public void securityAnswerFieldEmpty(){
		 
		 
		 User userToCompare = new User();    		   
		 userToCompare.setUsername("username");
		 userToCompare.setSecurityAnswer("wrongAnswer");
		 
		 User userToValidate = new User();    		   
		 userToValidate.setUsername("username");
		 userToValidate.setSecurityAnswer("answer");
		 
		 given(repository.findByUsername("username")).willReturn(userToCompare);
		 EducationalGameApplication.setPasswordResetSection(1);
		 EducationalGameApplication.setPasswordResetUsername("username");
		 
		    
		 PassRecoveryValidator v = new PassRecoveryValidator(repository);  
		 BeanPropertyBindingResult errors = 
		    new BeanPropertyBindingResult(userToValidate, "userToValidate" );
		 v.validate(userToValidate, errors);
		 assertTrue(errors.hasErrors());
	 }
	 
	 @Test 
	  public void newPasswordsNotMatching(){
		 EducationalGameApplication.setPasswordResetSection(2);
		 
		 User userToValidate = new User();    		   
		 userToValidate.setUsername("username");
		 userToValidate.setPassword("password");
		 userToValidate.setPassword2("notMatchingPassword");
		 userToValidate.setSecurityAnswer("answer");

		 PassRecoveryValidator v = new PassRecoveryValidator(repository);  
		 BeanPropertyBindingResult errors = 
		  	new BeanPropertyBindingResult(userToValidate, "userToValidate" );
		 v.validate(userToValidate, errors);
		 assertTrue(errors.hasErrors());
	 }
	 
	 @Test 
	  public void newPasswordsNotMeetingTheCriteria(){
		 EducationalGameApplication.setPasswordResetSection(2);
		 
		 User userToValidate = new User();    		   
		 userToValidate.setUsername("username");
		 userToValidate.setPassword("PasswordNotMatchingTheCriteria!!22");
		 userToValidate.setPassword2("PasswordNotMatchingTheCriteria!!22");
		 userToValidate.setSecurityAnswer("answer");
		 		    
		 PassRecoveryValidator v = new PassRecoveryValidator(repository);  
		 BeanPropertyBindingResult errors = 
		  	new BeanPropertyBindingResult(userToValidate, "userToValidate" );
		 v.validate(userToValidate, errors);
		 assertTrue(errors.hasErrors());
	 }
}
