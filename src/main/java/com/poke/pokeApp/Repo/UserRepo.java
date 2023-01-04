
package com.poke.pokeApp.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poke.pokeApp.Models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE username = ?1 AND password = ?2 LIMIT 1", nativeQuery = true)
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
