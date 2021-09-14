package com.example.demo.registration;

import com.example.demo.CollegeAdmin.CollegeAdmin;
import com.example.demo.CollegeAdmin.CollegeAdminRepository;
import com.example.demo.Company.Company;
import com.example.demo.Company.CompanyRepository;
import com.example.demo.DTO.APIErrorsHandler;

import com.example.demo.Student.Student;
import com.example.demo.Student.StudentRepository;
import com.example.demo.appuser.AppUserRepository;
import com.example.demo.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RegistrationService {

    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CollegeAdminRepository collegeAdminRepository;

    public ResponseEntity<Object> StudentRegister(Student request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Not a Valid Email","error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
        }

        boolean userExists = appUserRepository
        .findByEmail(request.getEmail())
        .isPresent();

        if(userExists){
            APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Email already Registered","error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
        }
        else{
            String access_token = confirmationTokenService.SignUpStudent(request);
            request.setToken(access_token);
            studentRepository.save(request);
            return ResponseEntity.status(HttpStatus.OK).body(request);
            }
    }
    public ResponseEntity<Object> CompanyRegister(Company request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Not a Valid Email","error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
        }

        boolean userExists = appUserRepository
        .findByEmail(request.getEmail())
        .isPresent();

        if(userExists){
            APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Email already Registered","error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
        }
        else{
            String access_token = confirmationTokenService.SignUpCompany(request);
            request.setToken(access_token);
            companyRepository.save(request);
            return ResponseEntity.status(HttpStatus.OK).body(request);
            }
    }
           
    public ResponseEntity<Object> CollegeAdminRegister(CollegeAdmin request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Not a Valid Email","error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
        }

        boolean userExists = appUserRepository
        .findByEmail(request.getEmail())
        .isPresent();

        if(userExists){
            APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Email already Registered","error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
        }
        else{
            String access_token = confirmationTokenService.SignUpCollege(request);
            request.setToken(access_token);
            collegeAdminRepository.save(request);
            return ResponseEntity.status(HttpStatus.OK).body(request);
            }
    }
        

        // String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        // emailSender.send(
        //         request.getEmail(),
        //         buildEmail(request.getFirstName(), link));

        // return token;

    // @Transactional
    // public String confirmToken(String token) {
    //     ConfirmationToken confirmationToken = confirmationTokenService
    //             .getToken(token)
    //             .orElseThrow(() ->
    //                     new IllegalStateException("token not found"));

    //     if (confirmationToken.getConfirmedAt() != null) {
    //         throw new IllegalStateException("email already confirmed");
    //     }

    //     LocalDateTime expiredAt = confirmationToken.getExpiresAt();

    //     if (expiredAt.isBefore(LocalDateTime.now())) {
    //         throw new IllegalStateException("token expired");
    //     }

    //     confirmationTokenService.setConfirmedAt(token);
    //     appUserService.enableAppUser(
    //             confirmationToken.getAppUser().getEmail());
    //     return "confirmed";
    // }
    }