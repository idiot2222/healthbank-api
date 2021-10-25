package com.pps.ports.outgoing;

import com.pps.data.RegistrationDto;

public interface RegistrationPersistencePort {

    RegistrationDto registerUser(RegistrationDto registrationDto);

    void unregisterUser(Long registrationId);

}
