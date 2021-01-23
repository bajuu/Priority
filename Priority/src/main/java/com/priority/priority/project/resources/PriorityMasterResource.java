package com.priority.priority.project.resources;

import java.util.List;

import javax.validation.Valid;

import com.priority.priority.project.dto.PriorityMasterRequest;
import com.priority.priority.project.models.PriorityMaster;
import com.priority.priority.project.services.PriorityMasterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/priority/master")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PriorityMasterResource {

    private final PriorityMasterServices priorityMasterServices;

    @PostMapping()
    public PriorityMaster createPriorityMaster(@Valid @RequestBody PriorityMasterRequest request) {
        return priorityMasterServices.createPriorityMaster(request);
    }

    @GetMapping()
    public List<PriorityMaster> getAllPriorityMaster() {
        return priorityMasterServices.getAllPriorityMaster();
    }
}
