package com.sharingsugar.authenticationservice.model.Service;

import com.sharingsugar.authenticationservice.application.Request.LogingRequest;
import com.sharingsugar.authenticationservice.application.Request.PassWordResetRequest;
import com.sharingsugar.authenticationservice.application.Request.PassWordResetRequestDto;
import com.sharingsugar.authenticationservice.application.Response.LoginUserDto;
import com.sharingsugar.authenticationservice.application.Response.UserInfoDto;
import com.sharingsugar.authenticationservice.model.Beans.FeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.StringBufferInputStream;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private FeignProxy feignProxy;

    public UserInfoDto tryFeign(String username){
        return feignProxy.getUserInfoDto(username);
    }

    public Boolean isAuthenticated(LogingRequest logingRequest){
        Authentication authenticate = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(
                logingRequest.getUserName(),logingRequest.getPassWord()));
        return authenticate.isAuthenticated();
    }
    public String getToken(LogingRequest logingRequest){
       String token= jwtService.generateToken(logingRequest.getUserName());
       return  token;
    }
    public LoginUserDto getLoginUserDto(String userName) throws RuntimeException{
         var loginUserDto = feignProxy.getLoginUserDto(userName);
         if(loginUserDto==null){
             throw new UsernameNotFoundException("User not found with name : "+userName);
         }
         if(loginUserDto!=null){
             return loginUserDto;
         }
         return null;
    }

    public void resetPassWord(PassWordResetRequestDto passWordResetRequestDto)throws RuntimeException{
        //try {

            feignProxy.resetPassWord(passWordResetRequestDto);
//        }
//        catch (Exception e){
//            throw new RuntimeException(e.getMessage());
//        }

    }

    public Boolean isValidated(String token){
        return jwtService.validateTokenBool(token);
    }

    public Boolean isExpired(String token){
       return jwtService.IstokenExpired(token);
    }

    public String getUserNameByToken(String token){
        return jwtService.getUsername(token);
    }

}
