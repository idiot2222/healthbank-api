package com.pps.controller;

import com.pps.data.CourseDto;
import com.pps.ports.incoming.CourseServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseServicePort courseServicePort;

    @GetMapping("/list")
    public List<CourseDto> getCourseList() {
        return courseServicePort.getAllCourseList();
    }

}
