package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements UserDetailsService
{

    private final static String USER_NOT_FOUND_MSG =
              "user with email %s not found";
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return studentRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

}
