package com.sharingsugar.centraldatabaseservice.application.Controller;

import com.sharingsugar.centraldatabaseservice.application.Request.AuthUserCreateRequest;
import com.sharingsugar.centraldatabaseservice.application.Request.PassWordResetRequestDto;
import com.sharingsugar.centraldatabaseservice.application.Request.UpdateUserDto;
import com.sharingsugar.centraldatabaseservice.application.Request.UserDto;
import com.sharingsugar.centraldatabaseservice.application.Response.LoginUserDto;
import com.sharingsugar.centraldatabaseservice.application.Response.UserInfoDto;
import com.sharingsugar.centraldatabaseservice.model.Bean.FeignProxy;
import com.sharingsugar.centraldatabaseservice.model.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/CentralDataBaseService/user")
public class UserDataController {

    @Autowired
    private UserService userService;
    @Autowired
    private FeignProxy feignProxy;

    //for local use (from UserService through feign client)
    @PostMapping("/signup")
    public void postUser(@RequestBody UserDto userDto){
        try {
            AuthUserCreateRequest authUserCreateRequest=new AuthUserCreateRequest();
            authUserCreateRequest.setUserName(userDto.getUserEmail());
            authUserCreateRequest.setPassWord(userDto.getUserPassword());
            feignProxy.createAuthUser(authUserCreateRequest);
            userService.saveUser(userDto);
            //return ResponseEntity.status(HttpStatus.CREATED).body("The user created successfully");
        }
        catch (Exception e){
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    // for local use (from UserService through feign client)
    @PutMapping("/user-details")
    public void updateUserDetails(@RequestBody UpdateUserDto updateUserDto){
        userService.updateUserDetails(updateUserDto);
    }


    // for local use (from Authentication service through feign client)
    @GetMapping("/getUser/userName/{userName}")
    public UserInfoDto getUserInfoByUserName(@PathVariable String userName){
        //System.out.println(userName);
       return userService.getUserInfoByUSerName(userName);
    }
    // for local use (from Authentication service through feign client)
    @GetMapping("/getLogingUser/userName/{userName}")
    public LoginUserDto getLoginUserByUSerName(@PathVariable String userName){
        return userService.getLoginUserByUserName(userName);
    }
    // for local use (from Authentication service through feign client)
    @PutMapping("/resetPassWord")
    public void resetPassWord(@RequestBody PassWordResetRequestDto passWordResetRequestDto){
        userService.resetPassWord(passWordResetRequestDto);
    }

}
