package com.sharingsugar.authenticationservice.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "AuthUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long AuthUserId;
    private String userName;
    private String passWord;
}
