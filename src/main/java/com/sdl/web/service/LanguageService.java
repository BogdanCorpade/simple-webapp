package com.sdl.web.service;

import com.sdl.web.domain.Language;
import com.sdl.web.domain.Languages;
import com.sdl.web.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by bcorpade on 4/30/2014.
 */
@Service
public class LanguageService {
    @Autowired
    private BaseRepository baseRepository;

    public Languages findLanguages() {
        Languages languages = new Languages();
        List<Language> languageList = baseRepository.findAll(Language.class);
        languages.setLanguageList(languageList);
        return languages;
    }

    public Languages searchLanguages(String search) {
        Languages languages = new Languages();
        List<Language> languageList = baseRepository.searchLanguages(Language.class, search);
        languages.setLanguageList(languageList);
        System.out.println(languageList);
        return languages;
    }

    public Language saveLanguage(Language language) {
        baseRepository.saveOrUpdate(language);
        return language;
    }

}
