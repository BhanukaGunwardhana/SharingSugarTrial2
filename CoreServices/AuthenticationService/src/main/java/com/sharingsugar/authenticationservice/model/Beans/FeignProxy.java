package com.sharingsugar.authenticationservice.model.Beans;

import com.sharingsugar.authenticationservice.application.Request.PassWordResetRequestDto;
import com.sharingsugar.authenticationservice.application.Response.LoginUserDto;
import com.sharingsugar.authenticationservice.application.Response.UserInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "CentralDataBaseService", url = "localhost:8081")
public interface FeignProxy {
    @GetMapping("/api/CentralDataBaseService/user/getUser/userName/{userName}")
    public UserInfoDto getUserInfoDto(@PathVariable String userName);

    @GetMapping("/api/CentralDataBaseService/user/getLogingUser/userName/{userName}")
    public LoginUserDto getLoginUserDto(@PathVariable String userName);

    @PutMapping("/api/CentralDataBaseService/user/resetPassWord")
    public void resetPassWord(@RequestBody PassWordResetRequestDto passWordResetRequestDto);
}
