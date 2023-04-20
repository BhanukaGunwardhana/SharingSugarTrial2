package com.sharingsugar.centraldatabaseservice.application.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    private long userId;
    private String userFullName;
    private String userOrgName;
    private String userProfileImgUrl;


}
