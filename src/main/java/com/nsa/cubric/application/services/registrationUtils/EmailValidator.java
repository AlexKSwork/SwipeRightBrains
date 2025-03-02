package com.nsa.cubric.application.services.registrationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
        private Pattern pattern;
        private Matcher matcher;
        private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

        @Override
        public void initialize(ValidEmail constraintAnnotation) {
        }
//Provide constraints for email by making sure it has an @ on it
        @Override
        public boolean isValid(String email, ConstraintValidatorContext context){
            return (validateEmail(email));
        }
// Return whether the email matches or not and whether it meets requirements
        private boolean validateEmail(String email) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email);
            return matcher.matches();
        }
}
