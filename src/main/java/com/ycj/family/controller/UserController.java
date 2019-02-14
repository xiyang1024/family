package com.ycj.family.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author chuanjieyang
 * @since Feb 14, 2019 10:36:35 AM
 */
@Controller
public class UserController {

    @GetMapping
    public String list(){
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return "";
    }
}
