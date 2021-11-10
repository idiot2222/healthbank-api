package com.pps.adapter;

import com.pps.data.RegistrationDto;
import com.pps.entity.Course;
import com.pps.entity.Registration;
import com.pps.ports.outgoing.RegistrationPersistencePort;
import com.pps.repository.CourseRepository;
import com.pps.repository.RegistrationRepository;
import com.pps.util.RegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationJpaAdapter implements RegistrationPersistencePort {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public RegistrationDto registerUser(RegistrationDto registrationDto) {
        Registration registration = registrationMapper.registrationDtoToRegistration(registrationDto);

        Registration savedRegistration = registrationRepository.save(registration);

        return registrationMapper.registrationToRegistrationDto(savedRegistration);
    }

    @Override
    public void unregisterUser(RegistrationDto registrationDto) {
        Registration registration = registrationMapper.registrationDtoToRegistration(registrationDto);

        registrationRepository.delete(registration);
    }

    @Override
    public Object findByRegistrationByCourseIdAndUserId(Long courseId, Long userId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Course id."));

        return registrationRepository.findByCourseAndUserId(course, userId);
    }

}
