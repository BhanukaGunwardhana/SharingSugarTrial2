package com.sharingsugar.authenticationservice.application.Configuration;

import com.sharingsugar.authenticationservice.application.Response.UserInfoDto;
import com.sharingsugar.authenticationservice.external.AuthUserRepository.AuthUserRepository;
import com.sharingsugar.authenticationservice.model.Beans.FeignProxy;
import com.sharingsugar.authenticationservice.model.Entity.AuthUserEntity;
import com.sharingsugar.authenticationservice.model.Service.AuthUserService;
import com.sharingsugar.authenticationservice.model.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserInfoService implements UserDetailsService {

    @Autowired
    private FeignProxy feignProxy;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthUserRepository authUserRepository;


//    @Autowired
//    private AuthenticationService authenticationService;

    @Autowired
    private AuthUserService authUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UserInfoDto userInfoDto=new UserInfoDto();
        AuthUserEntity authUserEntity=null;
        System.out.println("loadUserByuserName");
        for(var user: authUserRepository.findAll()){
            if(user.getUserName().equals(username)){
                System.out.println("userfounded");
                System.out.println(user.getUserName());
                System.out.println(user.getPassWord());
                return new UserInfo(user);


            }
        }
        //System.out.println("***");
        return new UserInfo(authUserEntity);


    }
}
