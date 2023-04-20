package com.sharingsugar.authenticationservice.application.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto {
    //username must be mail

    private String username;
    private String password;



}
