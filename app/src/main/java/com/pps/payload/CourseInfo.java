package com.pps.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseInfo {

    private Long id;
    private String title;
    private String description;
    private int limit;
    private Long trainerId;

    @Builder
    public CourseInfo(Long id, String title, String description, int limit, Long trainerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.limit = limit;
        this.trainerId = trainerId;
    }

}
