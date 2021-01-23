package com.priority.priority.project.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserPriorityRequest {

    private Integer priority;
    private Long masterId;
    private int satisfaction;

}
