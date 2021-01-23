package com.priority.priority.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserPriority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priorityId;
    private Integer priority;
    private Long masterId;
    @Min(1)
    @Max(5)
    @Column(name = "satisfaction")
    private Integer satisfaction;
    private String requesterId;
}
