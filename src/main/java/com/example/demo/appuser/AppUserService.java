package com.example.demo.appuser;

import com.example.demo.DTO.APIErrorsHandler;

import lombok.AllArgsConstructor;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService{

// private static final Logger logger = LoggerFactory.getLogger(AppUserService.class);


    @Autowired    
    private AppUserRepository appUserRepository;

    @Autowired
    org.springframework.security.crypto.password.PasswordEncoder encoder
        = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();


    public ResponseEntity<Object> LoginUser(AppUser appUser) {
        Boolean Is_A_Valid_User = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if(Is_A_Valid_User){
        AppUser user = appUserRepository.findByEmail(appUser.getEmail()).get();
        Boolean passwordMatch = encoder.matches(appUser.getPassword(), user.getPassword());
                if(appUser.getAppUserRole().equals(user.getAppUserRole())){
                        if(passwordMatch){
                                return ResponseEntity.status(HttpStatus.OK).body(user);
                        }
                        else{
                                APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Incorrect Password","error");
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
                        }
                }
                else{
                        APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Invalid User","error");
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
                }
        }
        else{
                APIErrorsHandler apiErrorsHandler= new APIErrorsHandler(HttpStatus.BAD_REQUEST,"Incorrect Email","error");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorsHandler);
        }
    }
}
