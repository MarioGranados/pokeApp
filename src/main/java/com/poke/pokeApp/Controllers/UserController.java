package com.poke.pokeApp.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poke.pokeApp.Models.User;
import com.poke.pokeApp.Repo.UserRepo;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class UserController {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // /user
    @GetMapping("/users")
    List<User> allUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/login")
    User userLogin(@PathVariable String username, @PathVariable String password) {
        return userRepo.findUserByUsernameAndPassword(username, password);
    }
    
    @PostMapping("/sign-up")
    User newUser(@RequestBody User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        return userRepo.save(user);
    }

    @GetMapping("/users/{id}")
    Optional<User> user(@PathVariable Long id) {
        return userRepo.findById(id);
    }

    @PutMapping("/users/{id}")
    User user(@RequestBody User user) {
        return userRepo.save(user);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }

}
