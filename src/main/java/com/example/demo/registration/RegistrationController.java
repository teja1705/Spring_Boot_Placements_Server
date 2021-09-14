package com.example.demo.registration;

import lombok.AllArgsConstructor;

import com.example.demo.Company.Company;
import com.example.demo.Student.Student;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/")
@AllArgsConstructor
public class RegistrationController {

    // private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(path = "student-registration")
    public ResponseEntity<Object> studentRegister(@RequestBody Student studentData) {
        return registrationService.StudentRegister(studentData);
    }

    @PostMapping(path = "company-registration")
    public ResponseEntity<Object> compnayRegister(@RequestBody Company company) {
        return registrationService.CompanyRegister(company);
    }
}
