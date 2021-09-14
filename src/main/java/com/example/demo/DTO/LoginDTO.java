package com.example.demo.DTO;

public class LoginDTO {
    private String email;
    private String password;
    private Long id;
    private Boolean isValidUser = false;
    private String token;
    private String user;
    public String getEmail() {
        return email;
    }
    public LoginDTO(String email, String password, Boolean isValidUser,String user) {
        this.email = email;
        this.password = password;
        this.isValidUser = isValidUser;
        this.user = user;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public LoginDTO(String email, String password, Long id, Boolean isValid) {
        this.email = email;
        this.password = password;
        this.id = id;
        this.isValidUser = false;
    }
    public LoginDTO() {
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getIsValidUser() {
        return isValidUser;
    }
    public void setIsValidUser(Boolean isValid) {
        this.isValidUser = isValid;
    }

    
    
}
