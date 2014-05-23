package com.sdl.web.service;

import com.sdl.web.domain.Language;
import com.sdl.web.domain.Languages;
import com.sdl.web.domain.MenuItemsList;
import com.sdl.web.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bcorpade on 5/22/2014.
 */
@Service
public class MenuCollectionService {
    @Autowired
    private BaseRepository baseRepository;

    public MenuItemsList findMenuItems() {
        MenuItemsList menuItemsList = new MenuItemsList();
        List<String> itemsFound = baseRepository.findAll(String.class);
        return menuItemsList;
    }

    public Languages findLanguages() {
        Languages languages = new Languages();
        List<Language> languageList = baseRepository.findAll(Language.class);
        languages.setLanguageList(languageList);
        return languages;
    }

    public MenuItemsList saveMenuItems(List<String> menuCollection) {
        MenuItemsList menuItemsList = new MenuItemsList();
        menuItemsList.setMenuItemsList(menuCollection);
        baseRepository.saveOrUpdate(menuCollection);
        return menuItemsList;
    }
}
