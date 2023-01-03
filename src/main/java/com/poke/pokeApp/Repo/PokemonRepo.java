package com.poke.pokeApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poke.pokeApp.Models.Pokemon;



@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Long> {

}