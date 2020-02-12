package com.ferreirae.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    static final String TAG = "mnf.Settings";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RadioGroup radioGroup = findViewById(R.id.colorRadioGroup);
        // option 1: on change, save to sharedprefs
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d(TAG, "user picked a new color");
                // figure out which one they picked
                String colorPicked = "default";
                if(checkedId == R.id.redRadioButton) {
                    // they picked red
                    colorPicked = "red";
                } else if(checkedId == R.id.yellowRadioButton) {
                    // they picked yellow
                    colorPicked = "yellow";
                }
                // save it to sharedprefs
                // https://developer.android.com/training/data-storage/shared-preferences
                SharedPreferences p =
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = p.edit();
                editor.putString("color", colorPicked);
                editor.apply();
            }
        });

        // option 2: when the user navigates away from the settings page, save to sharedprefs
    }
}
