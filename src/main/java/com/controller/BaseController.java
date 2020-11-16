/*
@author Andrei Gorevoi
*/
package com.controller;

import com.model.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {

    public AppUser getCurrentUser(){
        return (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
