package com.pps.entity;

import com.pps.data.RegistrationDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;
    private Long trainerId;



    @Builder
    public Registration(Long userId, Long trainerId) {
        this.userId = userId;
        this.trainerId = trainerId;
    }

    public RegistrationDto convertToRegistrationDto() {
        RegistrationDto dto = new RegistrationDto();
        dto.setUserId(this.userId);
        dto.setTrainerId(this.trainerId);

        return dto;
    }
}
