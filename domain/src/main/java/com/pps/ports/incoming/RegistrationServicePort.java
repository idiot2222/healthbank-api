package com.pps.ports.incoming;

import com.pps.data.RegistrationDto;

public interface RegistrationServicePort {

    RegistrationDto registerUser(RegistrationDto registrationDto);

    void unregisterUser(Long registrationId);

}
