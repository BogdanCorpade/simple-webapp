package com.sdl.web.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by bcorpade on 4/30/2014.
 */
public class Language {

    private String id;

    @NotNull
    @Size(min=1)
    private String name;
    @NotNull
    @Size(min=1, max = 3)
    private String code3;

/*
    @Override
    public boolean supports(Class<?> aClass) {
        return this.getClass().equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "code3", "code3.empty");
    }
*/
    @Override
    public String toString() {
        return "Language{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code3='" + code3 + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

}
