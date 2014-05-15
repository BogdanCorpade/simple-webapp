package com.sdl.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by bcorpade on 4/30/2014.
 */
@org.springframework.stereotype.Repository
public class BaseRepository{
    @Autowired
    protected MongoTemplate mongoTemplate;

    public <T> T saveOrUpdate(T entity) {
        mongoTemplate.save(entity);
        return entity;
    }


    public <T> List<T> findAll(Class<T> entityClass) {
        List<T> tList = mongoTemplate.findAll(entityClass);
        return tList;
    }

    public <T> List<T> searchLanguages(Class<T> entityClass, String language) {
        Query query = new Query();

//        query.addCriteria(Criteria.where("code3").regex(language).orOperator(
//                Criteria.where("name").regex(language)
//        ));
        query.addCriteria(Criteria.where("name").regex(language).orOperator(
                Criteria.where("code3").regex(language)));

        List<T> tList = mongoTemplate.find(query, entityClass);

        return tList;
    }



}
