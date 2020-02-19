package com.ferreirae.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ferreirae.pokemon.room.AppDatabase;
import com.ferreirae.pokemon.room.PokemonDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static String TAG = "mnf.main";
    @Override
    // Bundle
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // actually set the contents to be whatever's in the XML file called activity_main
        setContentView(R.layout.activity_main);
        // setup work
        // logging: verbose, debug, info, warning, error, wtf
        Log.d(TAG, "we are in onCreate");

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pokemon")
                .allowMainThreadQueries()
                .build();
        PokemonDAO dao = db.pokemonDAO();
//        Pokemon p = new Pokemon(100, "fire", "Charizard");
//        dao.addPokemon(p);
        List<Pokemon> pokemonList = dao.getAll();
        Log.i(TAG, pokemonList.toString());

        View b = findViewById(R.id.button);
        // anonymous inner class: define a class that implements View.OnClickListener, right here inline
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                b.setBackgroundColor(getResources().getColor(R.color.red));
//            }
//        });

        // lambda: looks like an arrow function
        // the view passed in as v is whatever view was clicked... in this case, the button
        b.setOnClickListener( (v) -> {
            v.setBackgroundColor(getResources().getColor(R.color.red));
            // go to the catch pokemon activity
            // thanks to https://developer.android.com/training/basics/firstapp/starting-activity
            // I intend to go from this activity to the CatchPokemon activity
            Intent i = new Intent(this, CatchPokemon.class);
            // Dear Android, actually start the activity based on what the intent says
            startActivity(i);
        });
    }

    public void onSettingsButtonPressed(View v) {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "resumed");

        // set color scheme of the TextView
        TextView helloWorldTextView = findViewById(R.id.textView);

        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String pickedColor = sharedPreferences.getString("color", "default");
        if (pickedColor.equals("red")) {
            helloWorldTextView.setBackgroundColor(getResources().getColor(R.color.red));
        } else if (pickedColor.equals("yellow")) {
            helloWorldTextView.setBackgroundColor(getResources().getColor(R.color.yellow));
        } else {
            helloWorldTextView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "destroyed");
    }
}

//class CoolClickLisener implements View.OnClickListener {
//    @Override
//    public void onClick(View v) {
//        Log.i(MainActivity.TAG, "Button was clicked!");
//    }
//}
