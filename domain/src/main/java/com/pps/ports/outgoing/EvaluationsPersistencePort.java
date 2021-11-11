package com.pps.ports.outgoing;

import com.pps.data.EvaluationDto;

import java.util.List;

public interface EvaluationsPersistencePort {

    List<EvaluationDto> getAllEvaluations();

    void addEvaluation(EvaluationDto evaluationDto);

}
