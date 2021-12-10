package com.lukagajic.demoapp.validator;

public interface Validator<T> {
    boolean isValid(T t);
}
