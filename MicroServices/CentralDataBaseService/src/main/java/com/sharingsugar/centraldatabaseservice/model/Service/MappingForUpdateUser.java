package com.sharingsugar.centraldatabaseservice.model.Service;

import com.sharingsugar.centraldatabaseservice.application.Request.UpdateUserDto;
import com.sharingsugar.centraldatabaseservice.application.Request.UserDto;
import com.sharingsugar.centraldatabaseservice.external.MasterDataRepository.LocationRepository;
import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.LocationEntity;
import com.sharingsugar.centraldatabaseservice.model.Entity.UserEntity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Data
@AllArgsConstructor
public class MappingForUpdateUser {


    private LocationRepository locationRepository;

    public UserEntity mappingForUpdateUser(UpdateUserDto userDto, UserEntity userEntity){
        if(userDto.getUserEmail()!=null){
            userEntity.setUserEmail(userDto.getUserEmail());
        }
        if(userDto.getUserOrgName()!=null){
            userEntity.setUserOrgName(userDto.getUserOrgName());
        }
        if(userDto.getUserFullName()!=null){
            userEntity.setUserFullName(userDto.getUserFullName());
        }
        if(userDto.getUserPhoneNumber()!=null){
            userEntity.setUserPhoneNumber(userDto.getUserPhoneNumber());
        }
        if(userDto.getLocationId()!=null){
            for(var location: locationRepository.findAll()){
                if(location.getLocationId()== userDto.getLocationId()){
                    userEntity.setLocation(location);
                }
            }

        }
        if(userDto.getUserProfileImgUrl()!=null){
            userEntity.setUserProfileImgUrl(userDto.getUserProfileImgUrl());
        }
        return  userEntity;
    }

}
