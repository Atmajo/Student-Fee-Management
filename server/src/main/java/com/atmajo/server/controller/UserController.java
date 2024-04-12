package com.atmajo.server.controller;

import com.atmajo.server.model.User;
import com.atmajo.server.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<String>("User Saved", HttpStatus.OK);
    }

    @PutMapping("{enrollment}")
    public String updateUser(@PathVariable("enrollment") Long enrollment, @RequestBody User user) {
        userService.updateUser(enrollment, user);
        return "Updates successfully";
    }

    @DeleteMapping("{enrollment}")
    public String deleteUser(@PathVariable("enrollment") Long enrollment) {
        userService.deleteUser(enrollment);
        return "Deleted successfully";
    }

    @GetMapping("{enrollment}")
    public User getUser(@PathVariable("enrollment") Long enrollment, @RequestParam("password") String password) {
        return userService.getUser(enrollment, password);
    }

    @GetMapping()
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

}
