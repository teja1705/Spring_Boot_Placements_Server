package com.example.demo.appuser;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.registration.token.ConfirmationToken;
import com.example.demo.registration.token.ConfirmationTokenRepository;
import com.example.demo.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

private static final Logger logger = LoggerFactory.getLogger(AppUserService.class);

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    @Autowired    
    private AppUserRepository appUserRepository;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Autowired
    org.springframework.security.crypto.password.PasswordEncoder encoder
   = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
   @Autowired
   private ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = encoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public ResponseEntity<LoginDTO> IsValidUser(String token,LoginDTO loginDTO) throws IllegalStateException{
        AppUser list = appUserRepository.findById(loginDTO.getId()).get();
        ConfirmationToken ctList = confirmationTokenRepository.findById(loginDTO.getId()).get();
        Boolean passwordMatch = encoder.matches(loginDTO.getPassword(), list.getPassword());
        if(list.getEnabled()){
                if(ctList.getToken().equals(token)){
                        if(loginDTO.getEmail().equals(list.getEmail()) && passwordMatch){
                                loginDTO.setIsValidUser(true);
                                return ResponseEntity.status(HttpStatus.OK).body(loginDTO);
                                }
                        else{
                                throw new IllegalAccessError("Incorrect Email/Password");
                        }
                }
                else{
                        throw new IllegalAccessError("wrong token");
                }
        }
        else{
            throw new IllegalStateException("User is Disabled");
        }
    }

}
