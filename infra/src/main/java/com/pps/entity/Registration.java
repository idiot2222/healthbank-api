package com.pps.entity;

import com.pps.data.RegistrationDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    @ManyToOne
    private Course course;



    @Builder
    public Registration(Long userId, Course course) {
        this.userId = userId;
        this.course = course;
    }

    public RegistrationDto convertToRegistrationDto() {
        RegistrationDto dto = new RegistrationDto();
        dto.setUserId(this.userId);
        dto.setCourseId(this.course.convertToCourseDto().getId());

        return dto;
    }
}
