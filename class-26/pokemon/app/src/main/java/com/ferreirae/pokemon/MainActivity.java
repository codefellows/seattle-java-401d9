package com.ferreirae.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "resumed");
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
}

//class CoolClickLisener implements View.OnClickListener {
//    @Override
//    public void onClick(View v) {
//        Log.i(MainActivity.TAG, "Button was clicked!");
//    }
//}
