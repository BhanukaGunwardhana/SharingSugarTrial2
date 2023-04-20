package com.sharingsugar.centraldatabaseservice.application.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassWordResetRequestDto {
    private String userName;
    private String passWord;
}
