package com.example.demo.Company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String dateOfVisit;
    private Long ctc;
    private Long stipend;
    private String eligibleBranches;
    private Long eligibleCGPA;
    private String email;
    private String password; 
    private String token;

    
    public Company(String companyName, String dateOfVisit, Long ctc, Long stipend, String eligibleBranches,
            Long eligibleCGPA, String email, String password) {
        this.companyName = companyName;
        this.dateOfVisit = dateOfVisit;
        this.ctc = ctc;
        this.stipend = stipend;
        this.eligibleBranches = eligibleBranches;
        this.eligibleCGPA = eligibleCGPA;
        this.email = email;
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getArrival() {
        return dateOfVisit;
    }
    public void setArrival(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }
    public Long getCtc() {
        return ctc;
    }
    public void setCtc(Long ctc) {
        this.ctc = ctc;
    }
    public Long getStipend() {
        return stipend;
    }
    public void setStipend(Long stipend) {
        this.stipend = stipend;
    }
    public String getEligibleBranches() {
        return eligibleBranches;
    }
    public void setEligibleBranches(String eligibleBranches) {
        this.eligibleBranches = eligibleBranches;
    }
    public Long getEligibleCGPA() {
        return eligibleCGPA;
    }
    public void setEligibleCGPA(Long eligibleCGPA) {
        this.eligibleCGPA = eligibleCGPA;
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
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    
    
}
