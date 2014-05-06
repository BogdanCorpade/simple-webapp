package com.sdl.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * Created by bcorpade on 4/30/2014.
 */
@org.springframework.stereotype.Repository
public class BaseRepository {
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


}
