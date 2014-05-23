package com.sdl.web;

import com.sdl.web.domain.Language;
import com.sdl.web.domain.MenuItemsList;
import com.sdl.web.repository.BaseRepository;
import com.sdl.web.service.MenuCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by bcorpade on 4/30/2014.
 */
@Controller
@RequestMapping("/menu")
public class MenuOrderController {
    @Autowired
    private MenuCollectionService menuCollectionService;

    @RequestMapping(headers ={"Accept=application/json"}, value = "/saveOrder", method = RequestMethod.POST)
    @ResponseBody
    MenuItemsList saveMenuItemsList(@RequestParam(value="val1", required=false) List<String>  menuCollection) {
        return menuCollectionService.saveMenuItems(menuCollection);
    }

}
