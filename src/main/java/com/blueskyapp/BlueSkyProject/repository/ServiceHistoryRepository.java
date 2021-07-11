package com.blueskyapp.BlueSkyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blueskyapp.BlueSkyProject.model.ServiceHistory;

public interface ServiceHistoryRepository extends JpaRepository<ServiceHistory, Integer> {

}
