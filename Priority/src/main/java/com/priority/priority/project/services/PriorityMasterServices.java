package com.priority.priority.project.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.priority.priority.project.dto.PriorityMasterRequest;
import com.priority.priority.project.models.PriorityMaster;
import com.priority.priority.project.repository.PriorityMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PriorityMasterServices {

    private static final List<String> PRIORITY_LIST = Arrays.asList("Connection", "Relationships", "Career", "Wealth");
    private final PriorityMasterRepository priorityMasterRepository;

    public PriorityMaster createPriorityMaster(PriorityMasterRequest request) {
        //Admin can add priority as much as he want
        PriorityMaster master = new PriorityMaster();
        master.setPriorityName(request.getPriorityName());
        master.setDescription(request.getDescription());
        return priorityMasterRepository.save(master);
    }

    public List<PriorityMaster> getAllPriorityMaster() {
        List<PriorityMaster> masterList = priorityMasterRepository.findAll();
        if (masterList == null || CollectionUtils.isEmpty(masterList)) {
            // Adding default priorities in db if master table is empty
            return saveDefaultPriorityMasterInDb();
        }
        return masterList;
    }


    private List<PriorityMaster> saveDefaultPriorityMasterInDb() {
        List<PriorityMaster> masterList = new ArrayList<>();
        PRIORITY_LIST.forEach(p -> {
            PriorityMaster master = new PriorityMaster();
            master.setPriorityName(p);
            master.setDescription(p);
            masterList.add(priorityMasterRepository.save(master));
        });
        return masterList;
    }
}
