package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class GameSettingsPlay extends Fragment {
    public GameSettingsPlay() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game_settings_play, container, false);

        TextView gameSettingsPlayTitle = view.findViewById(R.id.textView1);
        TextView gameSettingsPlayBoardSizeTitle = view.findViewById(R.id.textView2);
        TextView gameSettingsPlayStreaksToWinTitle = view.findViewById(R.id.textView3);

        Button gameSettingsPlay3x3 = view.findViewById(R.id.butBoard1);
        Button gameSettingsPlay4X4 = view.findViewById(R.id.butBoard2);
        Button gameSettingsPlay5x5 = view.findViewById(R.id.butBoard3);

        Button gameSettingsPlayStreaks3 = view.findViewById(R.id.butStreak1);
        Button gameSettingsPlayStreak4 = view.findViewById(R.id.butStreak2);
        Button gameSettingsPlayStreak5 = view.findViewById(R.id.butStreak3);

        Button gameSettingsPlayReturn = view.findViewById(R.id.butReturn);
        Button gameSettingsPlayGame = view.findViewById(R.id.butPlayGame);

        return view;
    }
}