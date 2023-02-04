package com.poke.pokeApp.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poke.pokeApp.Models.User;
import com.poke.pokeApp.Repo.UserRepo;

@Service
public class UserDetailsLoader implements UserDetailsService {
    @Autowired
    private final UserRepo userRepo;

    public UserDetailsLoader(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user== null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new User(user);
    }
}
