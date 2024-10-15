package com.dut.doctorcare.controller;

import com.dut.doctorcare.dto.request.AuthenticationRequest;
import com.dut.doctorcare.dto.request.IntrospecRequest;
import com.dut.doctorcare.dto.response.ApiResponse;
import com.dut.doctorcare.dto.response.AuthenticationResponse;
import com.dut.doctorcare.dto.response.IntrospecResponse;
import com.dut.doctorcare.service.iface.AuthenticationService;
import com.dut.doctorcare.service.impl.AuthenticationServiceImpl;
import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/auth")

public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        AuthenticationResponse result = authenticationService.authenticate(authenticationRequest);
        return ApiResponse.<AuthenticationResponse>builder().data(result).status(200).message("Authentication successful").build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospecResponse> authenticate(@RequestBody IntrospecRequest introspecRequest) throws ParseException, JOSEException {

        var result = ((AuthenticationServiceImpl)authenticationService).introspect(introspecRequest);
        return ApiResponse.<IntrospecResponse>builder().data(result).status(200).build();
    }
}
