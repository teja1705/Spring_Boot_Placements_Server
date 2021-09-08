// package com.example.demo.User;


// import com.example.demo.appuser.AppUserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class UserCredentialsService {
//     @Autowired
//     private UserCredentialsRepository userrepo;

//     public UserCredentialsService() {
//     }


//     @Autowired
//     private AppUserRepository appRepo;

//     public UserCredentialsService(UserCredentialsRepository userrepo, AppUserRepository appRepo) {
//         this.userrepo = userrepo;
//         this.appRepo = appRepo;
//     }


//     public Boolean IsValidUser(String token, String email, String password, Long id) throws IllegalAccessError{
//         if(!appRepo.isEnabled(id)){
//             throw new IllegalAccessError("User is Disabled");
//         }
//         else{
//             if(userrepo.findUser(id,email,password,token)){
//                 return true;
//             }
//             else{
//                 throw new IllegalAccessError("User is Disabled");
//             }
//         }

//     } 

    
// }
