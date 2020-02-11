package com.ferreirae.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CatchPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_pokemon);
    }

    public void potato(View v) {
        EditText t = findViewById(R.id.pokemonName);
        Log.i("mnf.CatchPokemon", t.getText().toString());
        // kill the current activity
        this.finish();
    }
}
