package com.rizki.mufrizal.belajar.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,@RequestParam(value = "error", required = false)String error,
                        @RequestParam(value = "logout", required = false)String logout){
        if(error!=null){
            model.addAttribute("error","Username dan Password Masih Salah");
        }
        if(logout!=null){
            model.addAttribute("logout","Anda Berhasil Logout");
        }
        return "login";
    }

}
