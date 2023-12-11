package com.sms.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//public interface EmailConstraint {
//
//}

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)

public @interface EmailConstraint{
	String message() default "Invalid email address";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}