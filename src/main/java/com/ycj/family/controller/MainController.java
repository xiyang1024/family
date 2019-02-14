package com.ycj.family.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 用于处理整个系统的主要控制
 * @author chuanjieyang
 * @since Feb 13, 2019 11:50:12 AM
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(){
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        authorities.forEach(System.out::println);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       /* Object credentials = authentication.getCredentials();
        System.out.println(credentials.toString());*/
        String s = authentication.getDetails().toString();
        System.out.println(s);
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        System.out.println(userDetails.getAuthorities());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.isAccountNonExpired());
        System.out.println(userDetails.isEnabled());

        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
