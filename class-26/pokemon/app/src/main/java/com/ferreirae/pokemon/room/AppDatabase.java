package com.ferreirae.pokemon.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ferreirae.pokemon.Pokemon;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonDAO pokemonDAO();
}
