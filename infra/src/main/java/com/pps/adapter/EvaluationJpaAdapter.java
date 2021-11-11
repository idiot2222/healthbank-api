package com.pps.adapter;

import com.pps.data.EvaluationDto;
import com.pps.ports.outgoing.EvaluationsPersistencePort;
import com.pps.repository.EvaluationRepository;
import com.pps.util.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationJpaAdapter implements EvaluationsPersistencePort {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private EvaluationMapper evaluationMapper;

    @Override
    public List<EvaluationDto> getAllEvaluations() {
        return evaluationRepository.findAll().stream()
                .map(x -> evaluationMapper.evaluationToEvaluationDto(x))
                .collect(Collectors.toList());
    }

    @Override
    public void addEvaluation(EvaluationDto evaluationDto) {
        evaluationRepository.save(evaluationMapper.evaluationDtoToEvaluation(evaluationDto));
    }
}
