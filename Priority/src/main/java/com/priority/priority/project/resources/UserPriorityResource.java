package com.priority.priority.project.resources;

import java.util.List;

import javax.validation.Valid;

import com.priority.priority.project.dto.UserPriorityRequest;
import com.priority.priority.project.models.UserPriority;
import com.priority.priority.project.services.UserPriorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/priority")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserPriorityResource {

    private final UserPriorityService userPriorityService;

    @PostMapping()
    public ResponseEntity createUserPriority(@Valid @RequestBody List<UserPriorityRequest> request,
                                             @RequestParam(value = "requester_id") String requesterId) {
        //RequesterId stands for unique id from request entity
        return userPriorityService.createUserPriority(request, requesterId);
    }

    @GetMapping()
    public List<UserPriority> getUsersPriority(@RequestParam(value = "requester_id") String requesterId) {
        return userPriorityService.getUsersPriority(requesterId);
    }
}
