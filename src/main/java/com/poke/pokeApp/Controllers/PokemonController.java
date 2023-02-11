package com.poke.pokeApp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poke.pokeApp.Models.Pokemon;
import com.poke.pokeApp.Repo.PokemonRepo;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api")
public class PokemonController {
    private final PokemonRepo pokemonRepo;

    PokemonController(PokemonRepo pokemonRepo) {
        this.pokemonRepo = pokemonRepo;
    }

    @GetMapping("/pokemon")
    List<Pokemon> allPokemon() {
        return pokemonRepo.findAll();
    }

    @PostMapping("/pokemon")
    Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        return pokemonRepo.save(pokemon);
    }
}
