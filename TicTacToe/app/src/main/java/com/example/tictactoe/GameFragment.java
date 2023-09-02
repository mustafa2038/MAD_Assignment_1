package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameFragment extends Fragment {
    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        Button button0 = view.findViewById(R.id.button0);
        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);
        Button button4 = view.findViewById(R.id.button4);
        Button button5 = view.findViewById(R.id.button5);
        Button button6 = view.findViewById(R.id.button6);
        Button button7 = view.findViewById(R.id.button7);
        Button button8 = view.findViewById(R.id.button8);

        TextView playerIndicatorTextView = view.findViewById(R.id.playerIndicatorTextView);
        TextView timerTextView = view.findViewById(R.id.timerTextView);
        TextView timerCountTextView = view.findViewById(R.id.timerCountTextView);
        TextView turnTextView = view.findViewById(R.id.turnTextView);
        TextView turnCountTextView = view.findViewById(R.id.turnCountTextView);

        Button undoButton = view.findViewById(R.id.undoButton);
        Button settingButton = view.findViewById(R.id.settingButton);
        Button restartButton = view.findViewById(R.id.restartButton);

        return view;
    }
}