package com.pps.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluationDto {

    private Long id;

    private long userId;
    private long itemId;
    private float rating;

}
