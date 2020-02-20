package com.ferreirae.pokemon;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amazonaws.amplify.generated.graphql.ListPokemonsQuery;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.ferreirae.pokemon.dummy.DummyContent;
import com.ferreirae.pokemon.dummy.DummyContent.DummyItem;
import com.ferreirae.pokemon.room.AppDatabase;
import com.ferreirae.pokemon.room.PokemonDAO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PokemonFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private AWSAppSyncClient mAWSAppSyncClient;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PokemonFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PokemonFragment newInstance(int columnCount) {
        PokemonFragment fragment = new PokemonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
        }
        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(view.getContext().getApplicationContext())
                .awsConfiguration(new AWSConfiguration(view.getContext().getApplicationContext()))
                .build();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        mAWSAppSyncClient.query(ListPokemonsQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.NETWORK_FIRST)
                .enqueue(new GraphQLCall.Callback<ListPokemonsQuery.Data>() {
                    @Override
                    public void onResponse(@Nonnull Response<ListPokemonsQuery.Data> response) {

                        Handler h = new Handler(Looper.getMainLooper()){
                            @Override
                            public void handleMessage(Message inputMessage) {
                                recyclerView.setAdapter(new MyPokemonRecyclerViewAdapter(response.data().listPokemons().items(), null));
                            }
                        };
                        h.obtainMessage().sendToTarget();
                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {

                    }
                });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
