package com.sharingsugar.centraldatabaseservice.application.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String userFullName;
    private String userEmail;
    private String userPhoneNumber;
    private String userOrgName;
    private String userPassword;
    private String userProfileImgUrl;

    //private MultipartFile userProfileImgFile;
    private Long locationId;
    private Long statusId;


}
