package com.sdl.web.service;

import com.sdl.web.domain.Language;
import com.sdl.web.domain.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bcorpade on 4/30/2014.
 */
@Service
public class LanguageService {
    @Autowired
    GenericRequest genericRequest;

    public Languages searchLanguages(String search) {
        System.out.println("searchLanguages: "+ search);
        return genericRequest.callMateApi("/language/searchLanguages",search,Languages.class);
    }

    public Language saveLanguage(Language language) {
        System.out.println("searchLanguages: "+ language);

        return genericRequest.callMateApi("/language/save",language,Language.class);
    }

}
