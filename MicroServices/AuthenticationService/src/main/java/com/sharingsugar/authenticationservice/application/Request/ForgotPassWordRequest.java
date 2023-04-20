package com.sharingsugar.authenticationservice.application.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPassWordRequest {
    @Email
    private String userName;
}
