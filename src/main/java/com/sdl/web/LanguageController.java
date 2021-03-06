package com.sdl.web;

import com.sdl.web.domain.Language;
import com.sdl.web.domain.Languages;
import com.sdl.web.repository.BaseRepository;
import com.sdl.web.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by bcorpade on 4/30/2014.
 */
@Controller
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private BaseRepository baseRepository;
    @Autowired
    private LanguageService languageService;

    @RequestMapping("/save")
    @ResponseBody
    Language saveLanguage(@Valid Language language) {
        return languageService.saveLanguage(language);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    Languages findAll() {
        return languageService.searchLanguages(null);
    }

    @RequestMapping(headers ={"Accept=application/json"}, value = "/searchLanguages")
    @ResponseBody
    Languages searchLanguages(@RequestParam(value="val1", required=false) String mydata) {
            return languageService.searchLanguages(mydata);
    }
}
