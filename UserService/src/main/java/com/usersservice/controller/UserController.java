package com.usersservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usersservice.models.User;
import com.usersservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable String  id){
		System.out.println("===============");
		return ResponseEntity.ok(service.getUser(id));
	}
	@GetMapping
    public List<User> getAllUsers() {
		System.out.println("+++++++++++++++++");
        return service.getAllUser();
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok(service.createUser(user));
    }
    @PostMapping("/all")
    public ResponseEntity<String> createAllUser(@RequestBody List<User> user) {
        return ResponseEntity.ok(service.saveAllUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
