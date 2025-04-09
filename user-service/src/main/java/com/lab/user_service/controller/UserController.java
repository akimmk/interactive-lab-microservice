package com.lab.user_service.controller;

import com.lab.user_service.model.Users;
import com.lab.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id){
        Optional<Users> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        System.out.println(user);
        Users savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
