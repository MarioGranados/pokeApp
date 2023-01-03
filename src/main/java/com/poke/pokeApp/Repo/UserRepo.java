
package com.poke.pokeApp.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poke.pokeApp.Models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    
}
