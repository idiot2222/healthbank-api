package com.pps.util;

import com.pps.data.RegistrationDto;
import com.pps.entity.Registration;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {

    public Registration registrationDtoToRegistration(RegistrationDto registrationDto) {
        return Registration.builder()
                .userId(registrationDto.getUserId())
                .trainerId(registrationDto.getTrainerId())
                .build();
    }

    public RegistrationDto registrationToRegistrationDto(Registration registration) {
        return registration.convertToRegistrationDto();
    }

}
