package com.sharingsugar.authenticationservice.application.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.EAN;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogingRequest {
    @Email(message = "Enter valid email")
    private String userName;
    private String passWord;
}
