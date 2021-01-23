package com.priority.priority.project.repository;

import java.util.List;

import com.priority.priority.project.models.UserPriority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPriorityRepository extends JpaRepository<UserPriority, Long> {

    List<UserPriority> findByRequesterIdOrderByPriorityAsc(String requesterId);
}
