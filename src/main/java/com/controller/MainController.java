package com.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {


    @GetMapping("/")
    public String getIndexPage() {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if(authorities.size()==1){
            switch (authorities.get(0).getAuthority()){
                case "ROLE_USER":
                    return  "redirect:/user/main";
                case "ROLE_ADMIN":
                    return "redirect:/admin";
                case "ROLE_TUTOR":
                    return "/indexTutor";
            }
        }
        if(authorities.size()==2){
            int user =0;
            int tutor=0;
            int admin=0;
            for (GrantedAuthority authority : authorities) {
                if(authority.getAuthority().equals("ROLE_USER")){
                    user=1;
                }else if(authority.getAuthority().equals("ROLE_TUTOR")){
                    tutor=1;
                }else if(authority.getAuthority().equals("ROLE_ADMIN")){
                    admin=1;
                }
            }
            if(user==1 && tutor==1){
                return "/indexUserTutor";
            }else if(user==1 && admin==1){
                return "/indexAdminUser";
            }else {
                return "/indexTutorAdmin";
            }
        }
        if(authorities.size()==3){
            return "/indexAll";
        }

        return null;

    }


}