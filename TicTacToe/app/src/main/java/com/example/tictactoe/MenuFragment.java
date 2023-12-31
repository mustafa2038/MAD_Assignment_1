package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuFragment extends Fragment {
    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        TextView menuTitle = view.findViewById(R.id.menuTitle);

        Button singlePlayerButton = view.findViewById(R.id.singlePlayerButton);
        Button multiplayerButton = view.findViewById(R.id.multiplayerButton);
        Button personalisationButton = view.findViewById(R.id.personalisationButton);
        Button leaderBoardButton = view.findViewById(R.id.leaderboardButton);

        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setGameMode("Singleplayer");
                mainActivityDataViewModel.setClickedValue("loadPlayGameSettingsFragment()");
            }
        });

        multiplayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setGameMode("Multiplayer");
                mainActivityDataViewModel.setClickedValue("loadPlayGameSettingsFragment()");
            }
        });

        personalisationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        leaderBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadLeaderboardFragment()");
            }
        });

        return view;
    }
}