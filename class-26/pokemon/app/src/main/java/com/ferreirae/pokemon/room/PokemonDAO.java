package com.ferreirae.pokemon.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ferreirae.pokemon.Pokemon;

import java.util.List;

@Dao
public interface PokemonDAO {
    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAll();

    @Insert
    void addPokemon(Pokemon p);
}
