package com.sdl.web.service;

import com.sdl.web.domain.Language;
import com.sdl.web.domain.Languages;
import com.sdl.web.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bcorpade on 4/30/2014.
 */
@Service
public class LanguageService {
    @Autowired
    private BaseRepository baseRepository;

    public Languages findLanguages(){
        Languages languages = new Languages();
        List<Language> languageList = baseRepository.finaAll(Language.class);
        languages.setLanguageList(languageList);
        return languages;
    }
}
