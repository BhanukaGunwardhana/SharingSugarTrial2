package com.sharingsugar.authenticationservice.application.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInUserRetrieveDto {
    private long user_id;
    private String full_name;
    private String profile_img_url;
    private String organization_name;
    private String accesToken;


}
