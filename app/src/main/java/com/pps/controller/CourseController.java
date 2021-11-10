package com.pps.controller;

import com.pps.data.CourseDto;
import com.pps.data.RegistrationDto;
import com.pps.entity.Registration;
import com.pps.ports.incoming.CourseServicePort;
import com.pps.ports.incoming.RegistrationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseServicePort courseServicePort;
    private final RegistrationServicePort registrationServicePort;

    @PostMapping("/create")
    public void createCourse(@RequestBody CourseDto courseDto) {
        courseServicePort.createCourse(courseDto);
    }

    @GetMapping("/info/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return courseServicePort.getCourseById(id);
    }

    @GetMapping("/list")
    public List<CourseDto> getCourseList() {
        return courseServicePort.getAllCourseList();
    }

    @PutMapping("/update/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        CourseDto course = courseServicePort.getCourseById(id);
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setLimitCount(courseDto.getLimitCount());
        course.setTrainerId(courseDto.getTrainerId());

        courseServicePort.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseServicePort.deleteCourse(id);
    }

    @PostMapping("/register/{courseId}/{userId}")
    public void registerCourse(@PathVariable Long courseId, @PathVariable Long userId) {
        RegistrationDto dto = RegistrationDto.builder()
                .courseId(courseId)
                .userId(userId)
                .build();

        registrationServicePort.registerUser(dto);
    }

    @PostMapping("/unregister/{courseId}/{userId}")
    public void unregisterCourse(@PathVariable Long courseId, @PathVariable Long userId) {
        Registration registration = (Registration) registrationServicePort.findByRegistrationByCourseIdAndUserId(courseId, userId);

        registrationServicePort.unregisterUser(registration.convertToRegistrationDto());
    }

}
