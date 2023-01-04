package com.poke.pokeApp.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poke.pokeApp.Models.User;
import com.poke.pokeApp.Repo.UserRepo;

@RestController
@CrossOrigin
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // /user
    @GetMapping("/users")
    List<User> allUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping("/users/{id}")
    Optional<User> user(@PathVariable Long id) {

        return userRepo.findById(id);
    }

    @GetMapping("/users/findUser/{username}+{password}")
    User userLogin(@RequestParam String username, @RequestParam String password) {
        return userRepo.findUserByUsernameAndPassword(username, password);
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
