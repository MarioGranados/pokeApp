package com.poke.pokeApp.Models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column
    //just call the pokemon api by pokenumber
    private Long pokedexNumber;

    @Column
    //this one is for search results
    private String pokemonName;

    @Column
    //have some sort of favorite method
    private boolean favorite;

    Pokemon() {
        //default
    }

    public Long getId() {
        return this.id;
    }

    public String getPokemonName() {
        return this.pokemonName;
    }

    public boolean favorite() {
        return this.favorite;
    }

    public void setPokemonName(String newPokemonName) {
        this.pokemonName = newPokemonName;
    }

    public void setFavorite(boolean isFavorite) {
        this.favorite = isFavorite;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
