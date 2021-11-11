package com.pps.ports.outgoing;

import com.pps.data.CourseDto;

import java.util.List;

public interface CoursePersistencePort {

    CourseDto createCourse(CourseDto courseDto);

    CourseDto getCourseById(Long courseId);

    List<CourseDto> getAllCourseList();

    List<CourseDto> getCourseListByTrainerId(Long trainerId);

    void updateCourse(CourseDto courseDto);

    void deleteCourse(Long courseId);

}
