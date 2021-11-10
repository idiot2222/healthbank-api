package com.pps.ports.outgoing;

import com.pps.data.RegistrationDto;

public interface RegistrationPersistencePort {

    RegistrationDto registerUser(RegistrationDto registrationDto);

    void unregisterUser(RegistrationDto registrationDto);

    Object findByRegistrationByCourseIdAndUserId(Long courseId, Long userId);
}
