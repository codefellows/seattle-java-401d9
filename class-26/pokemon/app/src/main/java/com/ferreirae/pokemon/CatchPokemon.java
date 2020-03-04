package com.ferreirae.pokemon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amazonaws.amplify.generated.graphql.CreatePokemonMutation;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import javax.annotation.Nonnull;

import type.CreatePokemonInput;

public class CatchPokemon extends AppCompatActivity {

    private static String TAG = "mnf.catch";
    private AWSAppSyncClient mAWSAppSyncClient;

    private FusedLocationProviderClient fusedLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_pokemon);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getApplicationContext())
                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
                .build();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 73: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocationAndSave();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    public void potato(View v) {
        EditText t = findViewById(R.id.pokemonName);
        Log.i("mnf.CatchPokemon", t.getText().toString());
        // kill the current activity
        this.finish();
    }

    public void viewPokemon(View v) {



        boolean permissionAccessCoarseLocationApproved =ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED;
        if (!permissionAccessCoarseLocationApproved) {
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 73);
        } else {
            getLocationAndSave();
        }

    }

    public void getLocationAndSave() {
        Log.i(TAG, "going to get coordinates");
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Log.i(TAG, "got coordinates!");
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            Log.d(TAG, "Coords: " + location.getLatitude() + " " + location.getLongitude());
                            // next step: geocoding
                            // https://developer.android.com/reference/android/location/Geocoder
                            EditText pokemonNameEditText = findViewById(R.id.pokemonName);
                            String pokemonName = pokemonNameEditText.getText().toString();
                            int level = 1;
                            String type = "fire";
                            CreatePokemonInput input = CreatePokemonInput.builder()
                                    .level(level)
                                    .name(pokemonName)
                                    .type(type)
                                    .pokemonSquadId("c6a71067-fe5c-48c9-9171-f7f7f9d6d709")
                                    .build();
                            mAWSAppSyncClient.mutate(CreatePokemonMutation.builder().input(input).build()).enqueue(
                                    new GraphQLCall.Callback<CreatePokemonMutation.Data>() {
                                        @Override
                                        public void onResponse(@Nonnull Response<CreatePokemonMutation.Data> response) {
                                            Log.i(TAG, response.data().toString());
                                        }

                                        @Override
                                        public void onFailure(@Nonnull ApolloException e) {
                                            Log.w(TAG, "failure");
                                        }
                                    }
                            );
                        }
                    }
                })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });

    }
}
