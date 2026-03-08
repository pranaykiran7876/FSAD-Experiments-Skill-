package com.klu.controller;

import com.klu.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")  
public class UserRestController 
{

    // GET   http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return new User(id, "Lakshmi");
    }

    // POST   http://localhost:8080/api/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return user;
    }

    // PUT 		http://localhost:8080/api/users/2
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        return user;
    }

    // DELETE 	http://localhost:8080/api/users/1
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return "User with ID " + id + " deleted";
    }
}
