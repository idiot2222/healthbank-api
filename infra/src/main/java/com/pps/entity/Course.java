package com.pps.entity;

import com.pps.data.CourseDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private int limit;

    private Long trainerId;



    @Builder
    public Course(String title, String description, int limit, Long trainerId) {
        this.title  = title;
        this.description = description;
        this.limit = limit;
        this.trainerId = trainerId;
    }

    public CourseDto convertToCourseDto() {
        CourseDto dto = new CourseDto();
        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setDescription(this.description);
        dto.setLimit(this.limit);
        dto.setTrainerId(this.trainerId);

        return dto;
    }

}
