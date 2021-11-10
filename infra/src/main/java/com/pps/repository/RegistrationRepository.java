package com.pps.repository;

import com.pps.entity.Course;
import com.pps.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Registration findByCourseAndUserId(Course course, Long userId);

}
