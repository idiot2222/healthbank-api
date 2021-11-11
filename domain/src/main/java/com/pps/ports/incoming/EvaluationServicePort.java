package com.pps.ports.incoming;

import com.pps.data.EvaluationDto;

import java.util.List;

public interface EvaluationServicePort {

    List<EvaluationDto> getAllEvaluations();

    void addEvaluation(EvaluationDto evaluationDto);

}
