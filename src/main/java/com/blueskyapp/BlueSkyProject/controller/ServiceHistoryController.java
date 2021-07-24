package com.blueskyapp.BlueSkyProject.controller;

import com.blueskyapp.BlueSkyProject.model.ServiceHistory;
import com.blueskyapp.BlueSkyProject.service.ServiceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/serviceHistory")
public class ServiceHistoryController {
	@Autowired
	ServiceHistoryService serviceHistoryService;

	@CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
	@GetMapping("")
    public List<ServiceHistory> list() {
        return serviceHistoryService.listAllServiceHistory();
    }
	
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @GetMapping("/{id}")
    public ResponseEntity<ServiceHistory> get(@PathVariable Integer historyId) {
        try {
        	ServiceHistory serviceHistory = serviceHistoryService.getServiceHistory(historyId);
            return new ResponseEntity<ServiceHistory>(serviceHistory, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ServiceHistory>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @PostMapping("/")
    public void add(@RequestBody ServiceHistory serviceHistory) {
    	serviceHistoryService.saveServiceHistory(serviceHistory);
    }
    @PutMapping("/{historyId}")
    public ResponseEntity<?> update(@RequestBody ServiceHistory serviceHistory, @PathVariable Integer historyId) {
        try {
        	ServiceHistory existServiceHistory = serviceHistoryService.getServiceHistory(historyId);
        	serviceHistory.setHistoryId(historyId);
            serviceHistoryService.saveServiceHistory(serviceHistory);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{historyId}")
    public void delete(@PathVariable Integer historyId) {

    	serviceHistoryService.deleteServiceHistory(historyId);
    }
}
