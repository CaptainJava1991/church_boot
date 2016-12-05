package com.church.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String>{
	  
	  public void initialize(ValidName constraintAnnotation) { }
	  
	  private boolean validateName(String name) {
		  if(name != null){
			  for(int i = 0; i < name.length(); i++){
				  if(Character.isLetter(name.charAt(i)) 
						  || name.charAt(i) == '-'
					  	   || name.charAt(i) == ' '){
					  		   
				   }else{
					   return false;
				   }
			  }
		  }
		  return true;
	  }
	  


	public boolean isValid(String name, ConstraintValidatorContext context) {
		
		return (validateName(name));
	}
}