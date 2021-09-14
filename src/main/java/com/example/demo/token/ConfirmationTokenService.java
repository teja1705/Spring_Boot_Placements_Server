package com.example.demo.token;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.CollegeAdmin.CollegeAdmin;
import com.example.demo.Company.Company;
import com.example.demo.Student.Student;
import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRepository;
import com.example.demo.appuser.AppUserRole;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    org.springframework.security.crypto.password.PasswordEncoder encoder
        = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired

    public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
    
    public String SignUpStudent(Student student) {
    String encodedPassword = encoder.encode(student.getPassword());
    student.setPassword(encodedPassword);
    
    String token = UUID.randomUUID().toString();

    AppUser appUser = new AppUser(student.getAppUserRole(),student.getEmail(),student.getPassword(),token);
    appUserRepository.save(appUser);

    ConfirmationToken confirmationToken = new ConfirmationToken(
            token,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(30),
            appUser
    );

    confirmationTokenRepository.save(confirmationToken);

    //        TODO: SEND EMAIL

    return token;
}
public String SignUpCompany(Company company) {
    String encodedPassword = encoder.encode(company.getPassword());
    company.setPassword(encodedPassword);
    
    String token = UUID.randomUUID().toString();

    AppUser appUser = new AppUser(AppUserRole.COMPANY,company.getEmail(),company.getPassword(),token);
    appUserRepository.save(appUser);


    ConfirmationToken confirmationToken = new ConfirmationToken(
            token,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(30),
            appUser
    );

    confirmationTokenRepository.save(confirmationToken);

    //        TODO: SEND EMAIL

    return token;
}

public String SignUpCollege(CollegeAdmin college) {
    String encodedPassword = encoder.encode(college.getPassword());
    college.setPassword(encodedPassword);
    
    String token = UUID.randomUUID().toString();

    AppUser appUser = new AppUser(AppUserRole.COLLEGEADMIN,college.getEmail(),college.getPassword(),token);
    appUserRepository.save(appUser);


    ConfirmationToken confirmationToken = new ConfirmationToken(
            token,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(30),
            appUser
    );

    confirmationTokenRepository.save(confirmationToken);

    //        TODO: SEND EMAIL

    return token;
}
}
