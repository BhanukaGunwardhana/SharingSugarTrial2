package com.sharingsugar.centraldatabaseservice.model.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharingsugar.centraldatabaseservice.application.Request.PassWordResetRequestDto;
import com.sharingsugar.centraldatabaseservice.application.Request.UpdateUserDto;
import com.sharingsugar.centraldatabaseservice.application.Request.UserDto;
import com.sharingsugar.centraldatabaseservice.application.Response.LoginUserDto;
import com.sharingsugar.centraldatabaseservice.application.Response.UserInfoDto;
import com.sharingsugar.centraldatabaseservice.external.MasterDataRepository.LocationRepository;
import com.sharingsugar.centraldatabaseservice.external.UserRepository.UserRepository;
import com.sharingsugar.centraldatabaseservice.model.Entity.UserEntity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LocationRepository locationRepository;

    public UserDto saveUser(UserDto userDto) throws RuntimeException{
        try {
            UserEntity userEntity=objectMapper.convertValue(userDto, UserEntity.class);
            userEntity.setCreatedAt(LocalDateTime.now());
            userEntity.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
            //userEntity.setUserProfileImgUrl(profileImgUrl(userDto.getUserProfileImgFile()));
            userRepository.save(userEntity);
            return  userDto;
        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }
    public UserInfoDto getUserInfoByUSerName(String userName){
        log.debug("getUserInfobyUserName called");
        System.out.println("getUserInfobyUserName called");
        for (var user: userRepository.findAll()){
            if(user.getUserEmail().equals(userName)){
                UserInfoDto userInfoDto=new UserInfoDto();
                userInfoDto.setUsername(userName);
                userInfoDto.setPassword(user.getUserPassword());
                return userInfoDto;
            }
        }
        return null;
    }

    public LoginUserDto getLoginUserByUserName(String userName){
        for (var user: userRepository.findAll()){
            if(user.getUserEmail().equals(userName)){
                LoginUserDto loginUserDto=new LoginUserDto();
                loginUserDto.setUserFullName(user.getUserFullName());
                loginUserDto.setUserOrgName(user.getUserOrgName());
                loginUserDto.setUserId(user.getUserId());
                loginUserDto.setUserProfileImgUrl(user.getUserProfileImgUrl());
                return loginUserDto;
            }
        }
        return null;
    }

    public void resetPassWord(PassWordResetRequestDto passWordResetRequestDto){
        String userName= passWordResetRequestDto.getUserName();
        String passWord= passWordResetRequestDto.getPassWord();
        for (var user: userRepository.findAll()){
            if(user.getUserEmail().equals(userName)){
                user.setUserPassword(passwordEncoder.encode(passWord));
                userRepository.save(user);
            }
        }
    }

    public void updateUserDetails(UpdateUserDto updateUserDto){
        String userName= updateUserDto.getUserNameFromAccessToken();
        for (var user: userRepository.findAll()){
            if(user.getUserEmail().equals(userName)){
               MappingForUpdateUser mappingForUpdateUserObject=new MappingForUpdateUser(locationRepository);
               UserEntity userEntity= mappingForUpdateUserObject.mappingForUpdateUser(updateUserDto,user);
               userRepository.save(userEntity);
            }
        }
    }

    //to upload profile img to s3 bucket and send return the img url
    public String profileImgUrl(MultipartFile file){
        return null;
    }
}
