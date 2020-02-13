package com.ferreirae.pokemon;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ferreirae.pokemon.PokemonFragment.OnListFragmentInteractionListener;
import com.ferreirae.pokemon.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPokemonRecyclerViewAdapter extends RecyclerView.Adapter<MyPokemonRecyclerViewAdapter.ViewHolder> {

    static final String TAG = "mnf.ViewAdapter";
    private final List<Pokemon> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyPokemonRecyclerViewAdapter(List<Pokemon> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    // creates a new row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pokemon, parent, false);
        return new ViewHolder(view);
    }

    // Given the holder and the position index, fill in that view with the right data for that position
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getName());
        holder.mLevelView.setText("" + mValues.get(position).getLevel());
        holder.mTypeView.setText(mValues.get(position).getType());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "it was clicked!");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mLevelView;
        public final TextView mTypeView;
        public Pokemon mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mLevelView = (TextView) view.findViewById(R.id.level);
            mTypeView = view.findViewById(R.id.type);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mLevelView.getText() + "'";
        }
    }
}
