package com.example.tictactoe;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class EndScreen extends Fragment {

    private TextView winnerText;
    private ImageView winnerImage;
    private TextView scoreValue;

    public EndScreen() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_end_screen, container, false);

        // Initialize UI elements
        winnerText = view.findViewById(R.id.winnerText);
        winnerImage = view.findViewById(R.id.winnerImage);
        scoreValue = view.findViewById(R.id.scoreValue);

        // Get player data (replace with your actual player data retrieval logic)
        //Player winner = getPlayerData(); // Replace with actual logic to get the winner
        //int score = winner.getScore(); // Replace with logic to get the score

        // Set winner text
        //winnerText.setText(winner.getName() + " wins!");

        // Set winner image (assuming you have a drawable resource ID for the winner's image)
        //winnerImage.setImageResource(winner.getImageResourceId());

        // Set score
        //scoreValue.setText(String.valueOf(score));

        return view;
    }

    // Replace this method with actual logic to get player data
    //private Player getPlayerData() {
        // Example: Create a player with name, image resource ID, and score
        //return new Player("Player X", R.drawable.player_x, 100);
    //}
}
