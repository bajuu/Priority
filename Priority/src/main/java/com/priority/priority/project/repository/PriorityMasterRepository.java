package com.priority.priority.project.repository;

import com.priority.priority.project.models.PriorityMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityMasterRepository extends JpaRepository<PriorityMaster, Long> {

}
