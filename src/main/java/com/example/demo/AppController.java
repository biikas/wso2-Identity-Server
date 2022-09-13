package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.converter.ClaimConversionService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public  class AppController {

    @GetMapping("/")
    public String getProfile(Model model, Authentication authentication) {

        if (authentication != null && authentication.isAuthenticated()) {
            DefaultOidcUser userDetails = (DefaultOidcUser) authentication.getPrincipal();
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("userName", userDetails.getName());
            model.addAttribute("IDTokenClaims", userDetails);
            model.addAttribute("AccessToken ", authentication.getCredentials());
            System.out.println("UserDetails: "+userDetails);
            System.out.println("Family Name "+userDetails.getFamilyName());
            System.out.println("eid "+userDetails.getClaims().get("eid"));
        }
        return "home";

    }


}
