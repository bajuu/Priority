package com.priority.priority.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Requester {

    @Id
    private String requesterId;
    private String name;
    private String mobileNumber;
    private String email;
    private String address;
}
