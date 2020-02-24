package com.ferreirae.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import javax.annotation.Nonnull;

import type.CreatePokemonInput;

public class CatchPokemon extends AppCompatActivity {

    private static String TAG = "mnf.catch";
    private AWSAppSyncClient mAWSAppSyncClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_pokemon);

        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getApplicationContext())
                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
                .build();
    }

    public void potato(View v) {
        EditText t = findViewById(R.id.pokemonName);
        Log.i("mnf.CatchPokemon", t.getText().toString());
        // kill the current activity
        this.finish();
    }

    public void viewPokemon(View v) {
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
