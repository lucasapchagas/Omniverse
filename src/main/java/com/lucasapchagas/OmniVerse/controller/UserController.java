package com.lucasapchagas.OmniVerse.controller;

import com.lucasapchagas.OmniVerse.entities.user.User;
import com.lucasapchagas.OmniVerse.entities.user.UserCreateRecord;
import com.lucasapchagas.OmniVerse.entities.user.UserRepository;
import com.lucasapchagas.OmniVerse.entities.user.UserUpdateRecord;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerUser(@RequestBody @Valid UserCreateRecord data) {
        User user = new User(data);
        userRepository.save(user);
        URI uri =
                UriComponentsBuilder.fromPath("/medicos/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateUser(@RequestBody UserUpdateRecord data) {
        User user = userRepository.getReferenceById(data.id());
        user.update(data);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity user(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.getReferenceById(id));
    }
}
