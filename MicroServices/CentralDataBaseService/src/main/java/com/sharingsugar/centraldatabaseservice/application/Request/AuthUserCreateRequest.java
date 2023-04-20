package com.sharingsugar.centraldatabaseservice.application.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUserCreateRequest {
    private String userName;
    private String passWord;
}
