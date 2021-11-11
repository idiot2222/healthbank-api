package com.pps.util;

import com.pps.data.EvaluationDto;
import com.pps.entity.Evaluation;
import org.springframework.stereotype.Component;

@Component
public class EvaluationMapper {

    public Evaluation evaluationDtoToEvaluation(EvaluationDto evaluationDto) {
        return Evaluation.builder()
                .id(evaluationDto.getId())
                .itemId(evaluationDto.getItemId())
                .userId(evaluationDto.getUserId())
                .rating(evaluationDto.getRating())
                .build();
    }

    public EvaluationDto evaluationToEvaluationDto(Evaluation evaluation) {
        return evaluation.convertToEvaluationDto();
    }

}
