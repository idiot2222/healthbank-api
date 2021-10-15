package com.pps.ports.incoming;

import com.pps.data.CourseDto;

import java.util.List;

public interface CourseServicePort {

    CourseDto createCourse(CourseDto courseDto);

    CourseDto getCourseById(Long courseId);

    List<CourseDto> getAllCourseList();

    List<CourseDto> getCourseListByUserId(Long userId);

    List<CourseDto> getCourseListByTrainerId(Long trainerId);

    CourseDto updateCourse(CourseDto courseDto);

    void deleteCourse(Long courseId);

}
