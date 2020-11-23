package com.validator;

import com.dto.TestDto;
import com.service.test.TestDtoServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class TestFormValidator implements Validator {
    @Autowired
    private TestDtoServiceWrapper testDtoServiceWrapper;

    @Override
    public boolean supports(Class<?> aClass) {
        return TestDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TestDto test = (TestDto) o;

        if (testDtoServiceWrapper.getByName(test.getName()) != null) {
            errors.reject("name", "Valid.testForm.name");
        }

    }
}
