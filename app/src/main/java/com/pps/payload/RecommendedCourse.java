package com.pps.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendedCourse {

    private Long id;
    private String title;
    private String description;
    private Long trainerId;

}
