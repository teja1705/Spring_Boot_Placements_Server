package com.example.demo.CollegeAdmin;

import com.example.demo.registration.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/collegeadmin-register")
@AllArgsConstructor
public class CollegeAdminController {


    @Autowired
    private RegistrationService registrationService;

    @PostMapping(path = "")
    public ResponseEntity<Object> RegisterCollegeAdmin(@RequestBody CollegeAdmin collegeAdmin) {
        return registrationService.CollegeAdminRegister(collegeAdmin);
    }
    
}
