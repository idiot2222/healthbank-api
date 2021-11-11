package com.pps.service;

import com.pps.data.CourseDto;
import com.pps.ports.incoming.CourseServicePort;
import com.pps.ports.outgoing.CoursePersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseServiceImpl implements CourseServicePort {

    private final CoursePersistencePort persistencePort;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        return persistencePort.createCourse(courseDto);
    }

    @Override
    public CourseDto getCourseById(Long courseId) {
        return persistencePort.getCourseById(courseId);
    }

    @Override
    public List<CourseDto> getAllCourseList() {
        return persistencePort.getAllCourseList();
    }

    @Override
    public List<CourseDto> getCourseListByTrainerId(Long trainerId) {
        return persistencePort.getCourseListByTrainerId(trainerId);
    }

    @Override
    public void updateCourse(CourseDto courseDto) {
        persistencePort.updateCourse(courseDto);
    }

    @Override
    public void deleteCourse(Long courseId) {
        persistencePort.deleteCourse(courseId);
    }

}
