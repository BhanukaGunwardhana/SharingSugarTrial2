package com.sharingsugar.authenticationservice.model.Service;

import com.sharingsugar.authenticationservice.application.Request.LogingRequest;
import com.sharingsugar.authenticationservice.application.Request.PassWordResetRequestDto;
import com.sharingsugar.authenticationservice.application.Response.LoginUserDto;
import com.sharingsugar.authenticationservice.application.Response.UserInfoDto;
import com.sharingsugar.authenticationservice.external.AuthUserRepository.AuthUserRepository;
import com.sharingsugar.authenticationservice.model.Beans.FeignProxy;
import com.sharingsugar.authenticationservice.model.Entity.AuthUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {
    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FeignProxy feignProxy;
    public void saveAuthUser(LogingRequest logingRequest){
        AuthUserEntity authUserEntity=new AuthUserEntity();
        authUserEntity.setUserName(logingRequest.getUserName());
        authUserEntity.setPassWord(passwordEncoder.encode(logingRequest.getPassWord()));
        authUserRepository.save(authUserEntity);

    }
    public UserInfoDto tryFeign(String username){
        return feignProxy.getUserInfoDto(username);
    }

    public void resetAuthUserPassWord(PassWordResetRequestDto passWordResetRequestDto){
        for (var authUser: authUserRepository.findAll()){
            if(authUser.getUserName().equals(passWordResetRequestDto.getUserName())){
                authUser.setPassWord(passwordEncoder.encode(passWordResetRequestDto.getPassWord()));
                authUserRepository.save(authUser);
            }
        }
    }
}
