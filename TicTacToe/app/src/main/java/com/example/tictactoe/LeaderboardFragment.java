package com.example.tictactoe;

        import android.content.Context;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Button;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;
        import androidx.lifecycle.Observer;
        import androidx.lifecycle.ViewModelProvider;

        import java.util.ArrayList;
        import java.util.List;

public class LeaderboardFragment extends Fragment {
    RecyclerView recyclerView;
    List<Item> items = new ArrayList<>();

    public LeaderboardFragment() {
        // Required empty public constructor
    }

    // Method to add player data dynamically
    public void addPlayerData(String name, String score, int image, int gamesPlayed, int gamesWon, double winRate) {
        // Check if the player with the same name exists in the list
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                // Player with the same name found, replace the data
                items.set(i, new Item(name, score, image, gamesPlayed, gamesWon, winRate));
                // Notify the adapter that data has been updated
                recyclerView.getAdapter().notifyItemChanged(i);
                return; // Exit the method
            }
        }

        // If the player name is not found, add a new item to the list
        items.add(new Item(name, score, image, gamesPlayed, gamesWon, winRate));
        // Notify the adapter that data has been added
        recyclerView.getAdapter().notifyItemInserted(items.size() - 1);
    }
    // how to use in other code:
    // LeaderboardFragment leaderboardFragment = new LeaderboardFragment();
    // leaderboardFragment.addPlayerData("New Player", "5678", R.drawable.player_image, 50, 25, 50.0);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);

        items.add(new Item("John wick", "12345", R.drawable.gigachad, 100, 50, 50.0));
        items.add(new Item("Robert j", "12345", R.drawable.pepe1, 100, 50, 60.0));
        items.add(new Item("James Gunn", "12345", R.drawable.wojak, 100, 50, 60.0));
        items.add(new Item("Ricky tales", "12345", R.drawable.crown, 100, 50, 60.0));
        items.add(new Item("Micky mose", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Pick War", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Leg piece", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Apple Mac", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("John wick", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Robert j", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("James Gunn", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Ricky tales", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Micky mose", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Pick War", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Leg piece", "12345", R.drawable.gigachad, 100, 50, 60.0));
        items.add(new Item("Apple Mac", "12345", R.drawable.gigachad, 100, 50, 60.0));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAdapter(getContext(), items));

        Button backBut = rootView.findViewById(R.id.buttonBack);

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainActivityDataViewModel != null) {
                    mainActivityDataViewModel.setClickedValue("loadMenuFragment()");
                }
            }
        });

        return rootView;
    }

    public static LeaderboardFragment newInstance() {
        return new LeaderboardFragment();
    }

    public class Item {
        String name;
        String scores;
        int image;
        int gamesPlayed;
        int gamesWon;
        double winRate;

        public Item(String name, String score, int image, int gamesPlayed, int gamesWon, double winRate) {
            this.name = name;
            this.scores = score;
            this.image = image;
            this.gamesPlayed = gamesPlayed;
            this.gamesWon = gamesWon;
            this.winRate = winRate;
        }

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

        public int getGamesPlayed() {
            return gamesPlayed;
        }

        public void setGamesPlayed(int gamesPlayed) {
            this.gamesPlayed = gamesPlayed;
        }

        public int getGamesWon() {
            return gamesWon;
        }

        public void setGamesWon(int gamesWon) {
            this.gamesWon = gamesWon;
        }

        public double getWinRate() {
            return winRate;
        }

        public void setWinRate(double winRate) {
            this.winRate = winRate;
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
            holder.scoreView.setText("score: " + items.get(position).getScore());
            holder.imageView.setImageResource(items.get(position).getImage());

            holder.gamesPlayedView.setText("Games played: " + items.get(position).getGamesPlayed());
            holder.gamesWonView.setText("Games won: " + items.get(position).getGamesWon());
            holder.winRateView.setText("Win rate: " + items.get(position).getWinRate() + "%");
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView nameView, scoreView;
            TextView gamesPlayedView, gamesWonView, winRateView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageview);
                nameView = itemView.findViewById(R.id.name);
                scoreView = itemView.findViewById(R.id.score);

                gamesPlayedView = itemView.findViewById(R.id.gamesPlayed);
                gamesWonView = itemView.findViewById(R.id.gamesWon);
                winRateView = itemView.findViewById(R.id.winRate);
            }
        }
    }
}

