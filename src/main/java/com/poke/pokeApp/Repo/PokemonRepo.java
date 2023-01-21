package com.poke.pokeApp.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poke.pokeApp.Models.Pokemon;



@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Long> {
    @Query(value = "SELECT * FROM pokemon WHERE user_id = ?1", nativeQuery = true)
    Optional<Pokemon> findAllByUserId(@Param("user_id") Long userId);
    
}