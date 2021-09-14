package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/login")
@AllArgsConstructor
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping(path = "")
    public ResponseEntity<Object> loginUser(@RequestBody AppUser appUser) {
        return appUserService.LoginUser(appUser);
    }
    
}
