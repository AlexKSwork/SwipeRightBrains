package com.nsa.cubric.application.services.registrationUtils;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FirstFourLettersOfPostcodeValidator.class)
@Documented
public @interface FirstFourLettersPostCode {
    String message() default "Please provide your postcode in the correct format (EG 'AB12'";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
