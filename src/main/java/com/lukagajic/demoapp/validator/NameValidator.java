package com.lukagajic.demoapp.validator;

public class NameValidator implements Validator<String> {

    @Override
    public boolean isValid(String name) {
        return name.length() >= 3;
    }
    
}
