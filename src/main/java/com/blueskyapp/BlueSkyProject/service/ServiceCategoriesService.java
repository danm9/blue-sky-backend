package com.blueskyapp.BlueSkyProject.service;

import com.blueskyapp.BlueSkyProject.model.ServiceCategories;
import com.blueskyapp.BlueSkyProject.repository.ServiceCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;
@Service
@Transactional
public class ServiceCategoriesService {
    @Autowired
    private ServiceCategoriesRepository serviceCategoriesRepository;
    public List<ServiceCategories> listAllServiceCategories() {
        return serviceCategoriesRepository.findAll();
    }

    public void saveServiceCategories(ServiceCategories serviceCategories) {
    	serviceCategoriesRepository.save(serviceCategories);
    }

    public ServiceCategories getServiceCategories(Integer serviceId) {
        return serviceCategoriesRepository.findById(serviceId).get();
    }

    public void deleteServiceCategories(Integer serviceId) {
    	serviceCategoriesRepository.deleteById(serviceId);
    }
}
