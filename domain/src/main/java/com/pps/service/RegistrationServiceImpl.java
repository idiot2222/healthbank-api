package com.pps.service;

import com.pps.data.RegistrationDto;
import com.pps.ports.incoming.RegistrationServicePort;
import com.pps.ports.outgoing.RegistrationPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationServicePort {

    private final RegistrationPersistencePort persistencePort;

    @Override
    public void registerUser(RegistrationDto registrationDto) {
        persistencePort.registerUser(registrationDto);
    }

    @Override
    public void unregisterUser(RegistrationDto registrationDto) {
        persistencePort.unregisterUser(registrationDto);
    }

    @Override
    public Object findByRegistrationByCourseIdAndUserId(Long courseId, Long userId) {
        return persistencePort.findByRegistrationByCourseIdAndUserId(courseId, userId);
    }
}
