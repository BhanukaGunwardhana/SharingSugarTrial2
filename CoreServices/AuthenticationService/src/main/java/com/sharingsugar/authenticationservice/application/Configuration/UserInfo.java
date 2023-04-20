package com.sharingsugar.authenticationservice.application.Configuration;

import com.sharingsugar.authenticationservice.application.Response.UserInfoDto;
import com.sharingsugar.authenticationservice.model.Entity.AuthUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;


public class UserInfo implements UserDetails {

    private String userName;
    private String passWord;

    public UserInfo(AuthUserEntity authUserEntity){
        this.userName=authUserEntity.getUserName();
        this.passWord=authUserEntity.getPassWord();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
