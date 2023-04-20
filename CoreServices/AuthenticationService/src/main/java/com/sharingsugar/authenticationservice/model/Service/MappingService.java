package com.sharingsugar.authenticationservice.model.Service;

import com.sharingsugar.authenticationservice.application.Response.LogInUserRetrieveDto;
import com.sharingsugar.authenticationservice.application.Response.LoginUserDto;
import org.springframework.stereotype.Service;

@Service
public class MappingService {
    public LogInUserRetrieveDto maptoLoginUserRetrieveDto(LoginUserDto loginUserDto){
        LogInUserRetrieveDto logInUserRetrieveDto=new LogInUserRetrieveDto();
        logInUserRetrieveDto.setUser_id(loginUserDto.getUserId());
        logInUserRetrieveDto.setFull_name(loginUserDto.getUserFullName());
        logInUserRetrieveDto.setOrganization_name(loginUserDto.getUserOrgName());
        logInUserRetrieveDto.setProfile_img_url(loginUserDto.getUserProfileImgUrl());

        return logInUserRetrieveDto;
    }
}
