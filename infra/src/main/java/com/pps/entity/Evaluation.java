package com.pps.entity;

import com.pps.data.EvaluationDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long userId;
    private long itemId;
    private float rating;

    @Builder
    public Evaluation(Long id, long userId, long itemId, float rating) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.rating = rating;
    }

    public EvaluationDto convertToEvaluationDto() {
        EvaluationDto dto = new EvaluationDto();

        dto.setId(this.id);
        dto.setItemId(this.itemId);
        dto.setUserId(this.userId);
        dto.setRating(this.rating);

        return dto;
    }
}
