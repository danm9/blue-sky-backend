package com.blueskyapp.BlueSkyProject.controller;

import com.blueskyapp.BlueSkyProject.model.User;
import com.blueskyapp.BlueSkyProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {  
    @Autowired
    UserService userService;
    
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @GetMapping("")
    public List<User> list() {
        return userService.listAllUser(); 
    }
    
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @PostMapping("/")
    public void add(@RequestBody User user) {
        userService.saveUser(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = userService.getUser(id);
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        userService.deleteUser(id);
    }
}
