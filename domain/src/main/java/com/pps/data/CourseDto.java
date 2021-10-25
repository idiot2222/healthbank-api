package com.pps.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {

    private Long id;

    private String title;
    private String description;
    private int limitCount;

    private Long trainerId;

}
