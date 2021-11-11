package com.pps.adapter;

import com.pps.data.CourseDto;
import com.pps.entity.Course;
import com.pps.ports.outgoing.CoursePersistencePort;
import com.pps.repository.CourseRepository;
import com.pps.util.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseJpaAdapter implements CoursePersistencePort {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.courseDtoToCourse(courseDto);

        Course savedCourse = courseRepository.save(course);

        return courseMapper.courseToCourseDto(savedCourse);
    }

    @Override
    public CourseDto getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId)
                                        .orElseThrow(() -> new IllegalArgumentException("Invalid course id."));

        return courseMapper.courseToCourseDto(course);
    }

    @Override
    public List<CourseDto> getAllCourseList() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCourseListByTrainerId(Long trainerId) {
        return courseRepository.findAllByTrainerId(trainerId)
                .stream()
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateCourse(CourseDto courseDto) {
        createCourse(courseDto);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                                        .orElseThrow(() -> new IllegalArgumentException("Invalid course id."));

        courseRepository.delete(course);
    }

}
