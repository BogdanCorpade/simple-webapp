package com.sdl.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by bcorpade on 4/30/2014.
 */
@org.springframework.stereotype.Repository
public class BaseRepository implements Validator {
    @Autowired
    protected MongoTemplate mongoTemplate;

    public <T> T saveOrUpdate(T entity) {
        mongoTemplate.save(entity);
        return entity;
    }


    public <T> List<T>  finaAll(Class<T> entityClass) {
        List<T> tList = mongoTemplate.findAll(entityClass);
        return tList;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return BaseRepository.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "code3", "code3.empty");
    }
}
