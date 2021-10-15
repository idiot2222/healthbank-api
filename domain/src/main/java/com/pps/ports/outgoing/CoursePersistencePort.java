package com.pps.ports.outgoing;

import com.pps.data.CourseDto;

import java.util.List;

public interface CoursePersistencePort {

    CourseDto createCourse(CourseDto courseDto);

    CourseDto getCourseById(Long courseId);

    List<CourseDto> getAllCourseList(Long courseId);

    List<CourseDto> getCourseListByUserId(Long userId);

    List<CourseDto> getCourseListByTrainerId(Long trainerId);

    CourseDto updateCourse(CourseDto courseDto);

    void deleteCourse(Long courseId);

}
