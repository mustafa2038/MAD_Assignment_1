package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ExitGameConfirmFragment extends Fragment {
    public ExitGameConfirmFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exit_game_confirm, container, false);

        TextView exitGameTitle1 = view.findViewById(R.id.exitGameTitle1);
        TextView exitGameTitle2 = view.findViewById(R.id.exitGameTitle2);
        Button endGameButton = view.findViewById(R.id.endGameButton);
        Button cancelButton = view.findViewById(R.id.cancelButton);

        return view;
    }
}