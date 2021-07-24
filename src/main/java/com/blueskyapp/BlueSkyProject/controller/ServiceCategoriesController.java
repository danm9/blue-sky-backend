package com.blueskyapp.BlueSkyProject.controller;

import com.blueskyapp.BlueSkyProject.model.ServiceCategories;
import com.blueskyapp.BlueSkyProject.service.ServiceCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/serviceCategories")
public class ServiceCategoriesController {
    @Autowired
    ServiceCategoriesService serviceCategoriesService;

    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @GetMapping("")
    public List<ServiceCategories> list() {
        return serviceCategoriesService.listAllServiceCategories();
    }
    
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceCategories> get(@PathVariable Integer serviceId) {
        try {
        	ServiceCategories serviceCategories = serviceCategoriesService.getServiceCategories(serviceId);
            return new ResponseEntity<ServiceCategories>(serviceCategories, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ServiceCategories>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @PostMapping("/")
    public void add(@RequestBody ServiceCategories serviceCategories) {
    	serviceCategoriesService.saveServiceCategories(serviceCategories);
    }
    @PutMapping("/{serviceId}")
    public ResponseEntity<?> update(@RequestBody ServiceCategories serviceCategories, @PathVariable Integer serviceId) {
        try {
        	ServiceCategories existServiceCategories= serviceCategoriesService.getServiceCategories(serviceId);
        	serviceCategories.setServiceId(serviceId);
        	serviceCategoriesService.saveServiceCategories(serviceCategories);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{serviceId}")
    public void delete(@PathVariable Integer serviceId) {

    	serviceCategoriesService.deleteServiceCategories(serviceId);
    }
}
