package com.sharingsugar.centraldatabaseservice.application.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserDto {

    private String userNameFromAccessToken;
    private String userFullName;
    private String userEmail;
    private String userPhoneNumber;
    private String userOrgName;
    private String userPassword;
    private String userProfileImgUrl;
    private Long locationId;
    private Long statusId;
}
