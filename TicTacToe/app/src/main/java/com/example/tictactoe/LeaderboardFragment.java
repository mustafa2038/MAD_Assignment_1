package com.example.tictactoe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardFragment extends Fragment {

    public LeaderboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<>();
        items.add(new Item("John wick", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Robert j", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("James Gunn", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Ricky tales", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Micky mose", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Pick War", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Leg piece", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Apple Mac", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("John wick", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Robert j", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("James Gunn", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Ricky tales", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Micky mose", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Pick War", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Leg piece", "Score: 12345", R.drawable.gigachad));
        items.add(new Item("Apple Mac", "Score: 12345", R.drawable.gigachad));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAdapter(getContext(), items));

        return rootView;
    }

    public static LeaderboardFragment newInstance() {
        return new LeaderboardFragment();
    }

    public class Item {

        String name;
        String scores;
        int image;

        public Item(String name, String score, int image) {
            this.name = name;
            this.scores = score;
            this.image = image;
        }

        // Getter and setter methods
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return scores;
        }

        public void setScore(String score) {
            this.scores = score;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        Context context;
        List<Item> items;

        public MyAdapter(Context context, List<Item> items) {
            this.context = context;
            this.items = items;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_leaderboard_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.nameView.setText(items.get(position).getName());
            holder.scoreView.setText(items.get(position).getScore());
            holder.imageView.setImageResource(items.get(position).getImage());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView nameView, scoreView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageview);
                nameView = itemView.findViewById(R.id.name);
                scoreView = itemView.findViewById(R.id.score);
            }
        }
    }
}
