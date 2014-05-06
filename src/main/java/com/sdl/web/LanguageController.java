package com.sdl.web;

import com.sdl.web.domain.Language;
import com.sdl.web.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by bcorpade on 4/30/2014.
 */
@Controller
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private BaseRepository baseRepository;


    @RequestMapping("/save")
    @ResponseBody
    Language savelanguage(Language language) {
        baseRepository.saveOrUpdate(language);
        return language;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    List<Language> findAll() {
        List<Language> languageList = baseRepository.finaAll(Language.class);
        return languageList;
    }
}
