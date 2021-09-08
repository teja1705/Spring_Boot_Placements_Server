// package com.example.demo.User;

// import javax.persistence.CascadeType;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToOne;
// import javax.persistence.Table;

// import com.example.demo.appuser.AppUser;
// import com.example.demo.registration.token.ConfirmationToken;


// import lombok.Data;

// @Data
// @Entity
// @Table(name = "UserCredentials")
// public class UserCredentials {

//     @Id
//     private Long id;
//     private String token;
//     private String email;

//     @OneToOne(cascade = CascadeType.ALL)
//     @JoinColumn(
//             nullable = false,
//             name = "password"
//     )
//     private AppUser appUser;

//     public UserCredentials(){
//     }


// }