package com.validator;

import com.model.Test;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TestFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Test.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
