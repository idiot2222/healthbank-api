package com.pps.service;

import com.pps.data.EvaluationDto;
import com.pps.ports.incoming.EvaluationServicePort;
import com.pps.ports.outgoing.EvaluationsPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationServicePort {

    private final EvaluationsPersistencePort persistencePort;

    @Override
    public List<EvaluationDto> getAllEvaluations() {
        return persistencePort.getAllEvaluations();
    }

    @Override
    public void addEvaluation(EvaluationDto evaluationDto) {
        persistencePort.addEvaluation(evaluationDto);
    }

}
