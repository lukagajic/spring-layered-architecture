package com.lukagajic.demoapp.validator;

import java.util.regex.Pattern;

public class EmailValidator implements Validator<String> {

    private static final String EMAIL_REGEX_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    @Override
    public boolean isValid(String email) {
        return Pattern.compile(EMAIL_REGEX_PATTERN, Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }
    
}
