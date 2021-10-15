package com.pps.util;

import com.pps.data.CourseDto;
import com.pps.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course courseDtoToCourse(CourseDto courseDto) {
        return Course.builder()
                .title(courseDto.getTitle())
                .description(courseDto.getDescription())
                .limit(courseDto.getLimit())
                .trainerId(courseDto.getTrainerId())
                .build();
    }

    public CourseDto courseToCourseDto(Course course) {
        return course.convertToCourseDto();
    }
}