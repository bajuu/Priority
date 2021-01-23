package com.priority.priority.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PriorityMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long masterId;
    private String priorityName;
    private String description;
}
