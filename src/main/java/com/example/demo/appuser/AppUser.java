package com.example.demo.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser{


    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private String email;
    private String password;
    private String Token;
    public AppUser(AppUserRole appUserRole,String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        Token = token;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        this.Token = token;
    }

    public AppUser(){

    }

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     SimpleGrantedAuthority authority =
    //             new SimpleGrantedAuthority(appUserRole.name());
    //     return Collections.singletonList(authority);
    // }

    // @Override
    // public String getPassword() {
    //     return password;
    // }

    // @Override
    // public String getUsername() {
    //     return email;
    // }

    public Long getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    // @Override
    // public boolean isAccountNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //     return !locked;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isEnabled() {
    //     return enabled;
    // }
}
