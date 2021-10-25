package com.pps.adapter;

import com.pps.data.RegistrationDto;
import com.pps.entity.Registration;
import com.pps.ports.outgoing.RegistrationPersistencePort;
import com.pps.repository.RegistrationRepository;
import com.pps.util.RegistrationMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationJpaAdapter implements RegistrationPersistencePort {

    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    @Override
    public RegistrationDto registerUser(RegistrationDto registrationDto) {
        Registration registration = registrationMapper.registrationDtoToRegistration(registrationDto);

        Registration savedRegistration = registrationRepository.save(registration);

        return registrationMapper.registrationToRegistrationDto(savedRegistration);
    }

    @Override
    public void unregisterUser(Long registrationId) {
        registrationRepository.findById(registrationId)
                              .orElseThrow(() -> new IllegalArgumentException("Invalid registration id."));
    }

}
