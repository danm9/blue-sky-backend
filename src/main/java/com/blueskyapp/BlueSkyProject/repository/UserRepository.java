package com.blueskyapp.BlueSkyProject.repository;

import com.blueskyapp.BlueSkyProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}
