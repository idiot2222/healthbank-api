package com.pps.util;

import com.pps.data.RegistrationDto;
import com.pps.entity.Course;
import com.pps.entity.Registration;
import com.pps.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RegistrationMapper {

    private final CourseRepository courseRepository;

    public Registration registrationDtoToRegistration(RegistrationDto registrationDto) {
        Course course = courseRepository.findById(registrationDto.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid course id."));

        return Registration.builder()
                .userId(registrationDto.getUserId())
                .course(course)
                .build();
    }

    public RegistrationDto registrationToRegistrationDto(Registration registration) {
        return registration.convertToRegistrationDto();
    }

}
