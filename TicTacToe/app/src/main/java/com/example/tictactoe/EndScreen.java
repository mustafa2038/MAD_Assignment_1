package com.example.tictactoe;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EndScreen extends Fragment {
    private String playerName;
    private int playerImage;

    public EndScreen() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_end_screen, container, false);

        // Retrieve player name and player image from arguments
        Bundle args = getArguments();
        if (args != null) {
            playerName = args.getString("playerName", "");
            playerImage = args.getInt("playerImage", 0);
        }

        // Update UI elements in the end screen
        TextView winnerText = view.findViewById(R.id.winnerText);
        ImageView winnerImage = view.findViewById(R.id.winnerImage);

        // Set the winner text
        winnerText.setText(playerName + " wins!");

        // Set the winner image (replace R.drawable.WinnerImage with your actual image resource)
        winnerImage.setImageResource(playerImage);

        // Button to return to the menu fragment
        Button backButton = view.findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with the menu fragment
                ((MainActivity) requireActivity()).loadMenuFragment();
            }
        });

        return view;
    }

}
