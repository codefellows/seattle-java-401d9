package com.ferreirae.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pokemon);

        String pokemonToView = getIntent().getStringExtra("pokemonName");
        TextView pokemonTextView = findViewById(R.id.pokemonName);
        pokemonTextView.setText(pokemonToView);
    }
}
