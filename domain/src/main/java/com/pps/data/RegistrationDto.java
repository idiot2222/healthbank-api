package com.pps.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RegistrationDto {

    private Long id;

    private Long userId;
    private Long courseId;

    @Builder
    public RegistrationDto(Long id, Long courseId, Long userId) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
    }
}
