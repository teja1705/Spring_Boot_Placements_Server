package com.example.demo.CollegeAdmin;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

import com.example.demo.appuser.AppUserRole;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class CollegeAdmin {

    @Id
    @GeneratedValue
    private Long id;
    private String collegeName;
    private String email;
    private String password;
    private AppUserRole appUserRole;
    private String token;

    public CollegeAdmin() {
    }

    public CollegeAdmin(String collegeName, String email, String password,String role) {
        this.collegeName = collegeName;
        this.email = email;
        this.password = password;
        this.appUserRole = AppUserRole.COLLEGEADMIN;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCollegeName() {
        return collegeName;
    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    public String getEmail() {
        return email;
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

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }
    
}
