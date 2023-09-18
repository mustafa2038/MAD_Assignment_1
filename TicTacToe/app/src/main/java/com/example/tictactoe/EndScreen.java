package com.example.tictactoe;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);
        Player winner = mainActivityDataViewModel.getWinner();
        int score = mainActivityDataViewModel.getTurnCount();

        // Update UI elements in the end screen
        TextView winnerText = view.findViewById(R.id.winnerText);
        TextView scoreValue = view.findViewById(R.id.scoreValue);
        ImageView winnerImage = view.findViewById(R.id.winnerImage);

        // Set the winner text
        winnerText.setText(String.format("%s wins!", winner.getPlayerName()));
        scoreValue.setText(Integer.toString(score));

        // Set the winner image (replace R.drawable.WinnerImage with your actual image resource)
        winnerImage.setImageDrawable(winner.getPlayerAvatar());

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
