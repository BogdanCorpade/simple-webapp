package com.sdl.web.domain;

import java.util.List;

/**
 * Created by bcorpade on 5/22/2014.
 */
public class MenuItemsList {
    List<String> menuItemsList;

    public List<String> getMenuItemsList() {
        return menuItemsList;
    }

    public void setMenuItemsList(List<String> menuItemsList) {
        this.menuItemsList = menuItemsList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuItemsList=" + menuItemsList +
                '}';
    }
}
