package com.pps.ports.incoming;

import com.pps.data.RegistrationDto;

public interface RegistrationServicePort {

    void registerUser(RegistrationDto registrationDto);

    void unregisterUser(RegistrationDto registrationDto);

    Object findByRegistrationByCourseIdAndUserId(Long courseId, Long userId);
}
