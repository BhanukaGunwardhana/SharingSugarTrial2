package com.sharingsugar.centraldatabaseservice.model.Bean;


import com.sharingsugar.centraldatabaseservice.application.Request.AuthUserCreateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//@FeignClient(name = "AuthenticationService", url = "localhost:8085")
@FeignClient(name = "AuthenticationService")
public interface FeignProxy {
//    @GetMapping("/api/user/getUser/userName/{userName}")
//    public UserInfoDto getUserInfoDto(@PathVariable String userName);
//
//    @GetMapping("/api/user/getLogingUser/userName/{userName}")
//    public LoginUserDto getLoginUserDto(@PathVariable String userName);
//
//    @PutMapping("/api/user/resetPassWord")
//    public void resetPassWord(@RequestBody PassWordResetRequestDto passWordResetRequestDto);

    @PostMapping("/api/auth/createAuthUser")
    public void createAuthUser(@RequestBody AuthUserCreateRequest authUserCreateRequest);

}
