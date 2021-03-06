package com.example.demo.token;
import com.example.demo.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;


public LocalDateTime getExpiresAt() {
        return expiresAt;
}

public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
}

public LocalDateTime getConfirmedAt() {
        return confirmedAt;
}

public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
}

public AppUser getAppUser() {
        return appUser;
}

public Long getId() {
        return id;
}

public void setId(Long id) {
        this.id = id;
}

public String getToken() {
        return token;
}

public void setToken(String token) {
        this.token = token;
}

public LocalDateTime getCreatedAt() {
        return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
}

public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
}

public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.appUser = appUser;
    }

    public ConfirmationToken(){}
}
