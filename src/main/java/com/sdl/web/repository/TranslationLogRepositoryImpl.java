package com.sdl.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TranslationLogRepositoryImpl implements TranslationLogRepository {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Override
    public <T> T log(T entity) {
        mongoTemplate.insert(entity);
        return entity;
    } 
    
}
