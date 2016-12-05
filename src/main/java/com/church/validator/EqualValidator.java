package com.church.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualValidator implements ConstraintValidator<ValidEqual, String>{

	private String value;
	
	public void initialize(ValidEqual equalvalues) {
		value = equalvalues.value();
	}

	public boolean isValid(String compare, ConstraintValidatorContext context) {
		return compare.equals(value);
	}

}
