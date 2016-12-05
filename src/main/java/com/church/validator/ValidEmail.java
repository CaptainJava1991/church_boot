package com.church.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Target({ ElementType.METHOD, ElementType.FIELD }) 
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail { 	
	
	String message() default "Mail Error";
    Class<?>[] groups() default {}; 
    Class<? extends Payload>[] payload() default {};
}
