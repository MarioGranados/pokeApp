package com.poke.pokeApp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;

    @Column
    private Long pokedexNumber;

    @Column
    private String pokemonName;

    @Column
    private String favorite;

    Pokemon() {
        //default
    }

    Pokemon(Long id, Long pokedexNumber, String pokemonName, String favorite) {
        this.id = id;
        this.pokedexNumber = pokedexNumber;
        this.pokemonName = pokemonName;
        this.favorite = favorite;
    }

    public Long getId() {
        return this.id;
    }

    public String getPokemonName() {
        return this.pokemonName;
    }

    public Long getPokedexNumber() {
        return this.pokedexNumber;
    }

    public String getFavorite() {
        return this.favorite;
    }

    public void setPokemonName(String newPokemonName) {
        this.pokemonName = newPokemonName;
    }

    public void setFavorite(String isFavorite) {
        this.favorite = isFavorite;
    }

    public void setPokedexNumber(Long pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
