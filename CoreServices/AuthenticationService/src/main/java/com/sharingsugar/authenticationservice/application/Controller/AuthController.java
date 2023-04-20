package com.sharingsugar.authenticationservice.application.Controller;

import com.sharingsugar.authenticationservice.application.Request.ForgotPassWordRequest;
import com.sharingsugar.authenticationservice.application.Request.LogingRequest;
import com.sharingsugar.authenticationservice.application.Request.PassWordResetRequest;
import com.sharingsugar.authenticationservice.application.Request.PassWordResetRequestDto;
import com.sharingsugar.authenticationservice.application.Response.Response;
import com.sharingsugar.authenticationservice.application.Response.UserInfoDto;
import com.sharingsugar.authenticationservice.model.Service.AuthUserService;
import com.sharingsugar.authenticationservice.model.Service.AuthenticationService;
import com.sharingsugar.authenticationservice.model.Service.MailSendingService;
import com.sharingsugar.authenticationservice.model.Service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MappingService mappingService;

    @Autowired
    private MailSendingService mailSendingService;

    @Autowired
    private AuthUserService authUserService;


    @GetMapping("/tryfeign/userName/{username}")
    public UserInfoDto tryfeign(@PathVariable String username){
        return authenticationService.tryFeign(username);
    }

    // create authUser when signUp
    @PostMapping("/createAuthUser")
    public void createAuthUser(@RequestBody LogingRequest logingRequest){
        authUserService.saveAuthUser(logingRequest);
    }


    //to loging purpose
    @PostMapping("/login")
    public ResponseEntity<Object> userLogging(@RequestBody @Valid LogingRequest logingRequest){
        String token=null;
        //authenticating the user before generating token
//        if(authenticationService.isAuthenticated(logingRequest)){
        try {
            if(authenticationService.isAuthenticated(logingRequest)){
                System.out.println("authenticated");
                token= authenticationService.getToken(logingRequest);
                System.out.println("took a token");
                //return ResponseEntity.ok(token);
                var logingUserDto=authenticationService.getLoginUserDto(logingRequest.getUserName());

                var loginUserRetrieveDto= mappingService.maptoLoginUserRetrieveDto(logingUserDto);
                loginUserRetrieveDto.setAccesToken(token);

                return ResponseEntity.status(HttpStatus.OK).body(loginUserRetrieveDto);
            }
            Response response=new Response();
            response.setStatus("401");
            response.setMessage("Invalid username or password");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }
        catch (Exception e){
            Response errorResponse=new Response();
            errorResponse.setStatus("400");
            errorResponse.setMessage("Username or password is incorrect");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }



//        }
//        ErrorResponse errorResponse=new ErrorResponse();
//        errorResponse.setStatus("401");
//        errorResponse.setMessage("Invalid username or password");
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    //to send temporary access token to email, when forgot the password
    @PostMapping("/forgot-password")
    public ResponseEntity<Object> forgotPassWord(@RequestBody @Valid ForgotPassWordRequest forgotPassWordRequest){
        try {
            String userName=forgotPassWordRequest.getUserName();
            String token=mailSendingService.sendMailForForgotPassWord(userName);
            Response response=new Response();
            response.setStatus("200");
            response.setMessage(token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        catch (Exception e){
            Response response=new Response();
            response.setStatus("404");
            response.setMessage("Username not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }
    //to reset the password with valid token
    @PutMapping("/reset-password")
    public ResponseEntity<Object> resetPassWord(@RequestBody PassWordResetRequest passWordResetRequest){
        try {
            String token= passWordResetRequest.getToken();
            String userName=authenticationService.getUserNameByToken(token);
            PassWordResetRequestDto passWordResetRequestDto=new PassWordResetRequestDto();
            passWordResetRequestDto.setUserName(userName);
            passWordResetRequestDto.setPassWord(passWordResetRequest.getPassWord());

            authenticationService.resetPassWord(passWordResetRequestDto);
            authUserService.resetAuthUserPassWord(passWordResetRequestDto);
            Response response=new Response();
            response.setStatus("200");
            response.setMessage("password has been reset successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        catch (Exception e){
            Response response=new Response();
            response.setStatus("401");
            response.setMessage("token is incorrect or expired");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }
    //validating the token, for local use
    @GetMapping("/validate/token")
    public Boolean validateToken(@RequestParam("token") String token){
        return authenticationService.isValidated(token);
    }

    //check for expiration, for local use
    @GetMapping("/isExpired/token")
    public Boolean isExpiredToken(@RequestParam("token") String token){
        return authenticationService.isExpired(token);
    }

    // get username by token, for local use
    @GetMapping("/getUserNameByToken/token")
    public String getUserNameByToken(@RequestParam("token") String token){
        return authenticationService.getUserNameByToken(token);
    }




}
