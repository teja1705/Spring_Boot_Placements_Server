// package com.example.demo.User;

// import javax.servlet.http.HttpServletResponse;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// import lombok.AllArgsConstructor;
// import lombok.Data;

// @RestController
// @RequestMapping("/api")
// @AllArgsConstructor
// public class UserCredentialsController {
//     @Autowired
//     private UserCredentialsService userCredentialsService;

//     public UserCredentialsController() {
//     }

//     @PostMapping(path = "login")
//     @RequestMapping(produces = "application/json", method = RequestMethod.POST, value = "data")
//     public Boolean login(HttpServletResponse headerData,@RequestBody String email,String password,Long id) {
//         return userCredentialsService.IsValidUser(headerData.getHeader("cookie"),email,password,id);
//     }

//     public UserCredentialsController(UserCredentialsService userCredentialsService) {
//         this.userCredentialsService = userCredentialsService;
//     }
    
// }
