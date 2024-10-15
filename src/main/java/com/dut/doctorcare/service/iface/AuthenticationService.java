package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.request.AuthenticationRequest;
import com.dut.doctorcare.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
