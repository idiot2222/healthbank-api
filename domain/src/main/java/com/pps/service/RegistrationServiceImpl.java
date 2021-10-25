package com.pps.service;

import com.pps.data.RegistrationDto;
import com.pps.ports.incoming.RegistrationServicePort;
import com.pps.ports.outgoing.RegistrationPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationServicePort {

    private final RegistrationPersistencePort persistencePort;

    @Override
    public RegistrationDto registerUser(RegistrationDto registrationDto) {
        return persistencePort.registerUser(registrationDto);
    }

    @Override
    public void unregisterUser(Long registrationId) {
        persistencePort.unregisterUser(registrationId);
    }
}
