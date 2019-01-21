package com.cn.authn_demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenController {
    public  final String string1="hui1";
    public  final String string2="hui2";
    public  final String string3="hui3";
    @GetMapping("/")
    public  String home(){
        return "home";
    }

    @GetMapping("/ghost/1")
    public String yi_1(){
        return string1+"/1";
    }
    @GetMapping("/ghost/2")
    public String yi_2(){
        return string1+"/2";
    }

    @GetMapping("/ghost/3")
    public String yi_3(){
        return string1+"/3";
    }

    @GetMapping("/ghost1/1")
    public String er_1(){
        return string2+"/1";
    }

    @GetMapping("/ghost1/2")
    public String er_2(){
        return string2+"/2";
    }

    @GetMapping("/ghost1/3")
    public String er_3(){
        return string2+"/3";
    }

    @GetMapping("/ghost2/1")
    public String san_1(){
        return string3+"/1";
    }

    @GetMapping("/ghost2/2")
    public String san_2(){
        return string3+"/2";
    }

    @GetMapping("/ghost2/3")
    public String san_3(){
        return string3+"/3";
    }


    @GetMapping("/userLogin")
    public String userLogin(){
        return "login";
    }

}
