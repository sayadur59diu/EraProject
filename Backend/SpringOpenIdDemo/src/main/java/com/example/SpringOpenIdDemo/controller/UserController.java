package com.example.SpringOpenIdDemo.controller;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public OidcUser getUser(OidcUser oidcUser) {
        return oidcUser; // Contains sub, email, name, etc.
    }

    @GetMapping("/principal")
    public Principal getPrincipal(Principal principal) {
        return principal; // Simpler view
    }
}