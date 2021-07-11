package com.blueskyapp.BlueSkyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blueskyapp.BlueSkyProject.model.ServiceHistory;
import com.blueskyapp.BlueSkyProject.repository.ServiceHistoryRepository;

import java.util.List;
import javax.transaction.Transactional;
@Service
@Transactional
public class ServiceHistoryService {
    @Autowired
    private ServiceHistoryRepository serviceHistoryRepository;
    public List<ServiceHistory> listAllServiceHistory() {
        return serviceHistoryRepository.findAll();
    }
    
    public void saveServiceHistory(ServiceHistory serviceHistory) {
    	serviceHistoryRepository.save(serviceHistory);
    }

    public ServiceHistory getServiceHistory(Integer historyId) {
        return serviceHistoryRepository.findById(historyId).get();
    }
    
    public void deleteServiceHistory(Integer historyId) {
    	serviceHistoryRepository.deleteById(historyId);
    }
}
