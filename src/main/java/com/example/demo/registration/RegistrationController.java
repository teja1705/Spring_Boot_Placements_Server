package com.example.demo.registration;

import lombok.AllArgsConstructor;

import com.example.demo.DTO.AppUserDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.appuser.AppUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/")
@AllArgsConstructor
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private AppUserService appUserService;

    @PostMapping(path = "registration")
    public ResponseEntity<AppUserDTO> register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @PostMapping(path = "login")
    public ResponseEntity<LoginDTO> login(@RequestHeader String access_token, @RequestBody LoginDTO loginDTO) {
        return appUserService.IsValidUser(access_token,loginDTO);
    }


}
