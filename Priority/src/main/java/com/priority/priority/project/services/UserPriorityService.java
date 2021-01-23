package com.priority.priority.project.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.priority.priority.project.dto.UserPriorityRequest;
import com.priority.priority.project.models.UserPriority;
import com.priority.priority.project.repository.UserPriorityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserPriorityService {

    private final UserPriorityRepository userPriorityRepository;

    public ResponseEntity createUserPriority(List<UserPriorityRequest> request, String requesterId) {
        if (request == null || CollectionUtils.isEmpty(request)) {
            log.error("Empty request received" + requesterId);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Map<Long, UserPriority> userPriorityMap = getAllUserPriority(requesterId);
        request.forEach(priority -> {
            try {
                UserPriority userPriority;
                if (!userPriorityMap.containsKey(priority.getMasterId())) {
                    userPriority = new UserPriority();
                    userPriority.setMasterId(priority.getMasterId());
                    userPriority.setPriority(priority.getPriority());
                    userPriority.setRequesterId(requesterId);
                    userPriority.setSatisfaction(priority.getSatisfaction());
                } else {
                    userPriority = userPriorityMap.get(priority.getMasterId());
                    userPriority.setMasterId(priority.getMasterId());
                    userPriority.setPriority(priority.getPriority());
                    userPriority.setRequesterId(requesterId);
                    userPriority.setSatisfaction(priority.getSatisfaction());
                }
                userPriorityRepository.save(userPriority);
            } catch (Exception e) {
                log.error("Bad request " + e);
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Map<Long, UserPriority> getAllUserPriority(String requesterId) {
        Map<Long, UserPriority> userPriorityMap = new HashMap<>();
        List<UserPriority> priorities = userPriorityRepository
            .findByRequesterIdOrderByPriorityAsc(requesterId);
        priorities.forEach(priority -> {
            userPriorityMap.put(priority.getMasterId(), priority);
        });
        return userPriorityMap;
    }

    public List<UserPriority> getUsersPriority(String requesterId) {
        return userPriorityRepository.findByRequesterIdOrderByPriorityAsc(requesterId);
    }
}
