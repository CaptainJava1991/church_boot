package com.church.validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    
	  public void initialize(ValidEmail constraintAnnotation) { }
	  
	  private boolean validateEmail(String mail) {
		  if(mail != null){
			try {
				InternetAddress internetAddresse = new InternetAddress(mail);
				internetAddresse.validate();
				 return true;
			} catch (AddressException e) {
				return false;
			}
		  }
		  return true;
	  }
	  
	  public boolean isValid(String mail, ConstraintValidatorContext context) {
		return (validateEmail(mail));
	  }
	  
	  
	  
}
