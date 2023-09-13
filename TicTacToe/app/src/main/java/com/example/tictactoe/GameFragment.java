package com.example.tictactoe;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameFragment extends Fragment {
    Player player1;
    Player player2;
    boolean player1active = true;
    boolean player2active = false;

    int player1markerid = R.drawable.circle;
    int player2markerid = R.drawable.cross;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        player1 = new Player(mainActivityDataViewModel.getPlayer1Name(), mainActivityDataViewModel.getPlayer1AvatarDrawable(),
                mainActivityDataViewModel.getPlayer1MarkerDrawable(), mainActivityDataViewModel.getPlayer1markerName());
        player2 = new Player(mainActivityDataViewModel.getPlayer1Name(), mainActivityDataViewModel.getPlayer2AvatarDrawable(),
                mainActivityDataViewModel.getPlayer2MarkerDrawable(), mainActivityDataViewModel.getPlayer2markerName());


        if(player1.getPlayerMarkerName().equals("circle")) {
            player1markerid = R.drawable.circle;
        } else if(player1.getPlayerMarkerName().equals("cross")) {
            player1markerid = R.drawable.cross;
        } else if(player1.getPlayerMarkerName().equals("crown")) {
            player1markerid = R.drawable.crown;
        } else if(player1.getPlayerMarkerName().equals("sword")) {
            player1markerid = R.drawable.sword;
        }

        if(player2.getPlayerMarkerName().equals("circle")) {
            player2markerid = R.drawable.circle;
        } else if(player2.getPlayerMarkerName().equals("cross")) {
            player2markerid = R.drawable.cross;
        } else if(player2.getPlayerMarkerName().equals("crown")) {
            player2markerid = R.drawable.crown;
        } else if(player2.getPlayerMarkerName().equals("sword")) {
            player2markerid = R.drawable.sword;
        }

        ImageButton button0 = view.findViewById(R.id.button0);
        ImageButton button1 = view.findViewById(R.id.button1);
        ImageButton button2 = view.findViewById(R.id.button2);
        ImageButton button3 = view.findViewById(R.id.button3);
        ImageButton button4 = view.findViewById(R.id.button4);
        ImageButton button5 = view.findViewById(R.id.button5);
        ImageButton button6 = view.findViewById(R.id.button6);
        ImageButton button7 = view.findViewById(R.id.button7);
        ImageButton button8 = view.findViewById(R.id.button8);

        TextView playerIndicatorTextView = view.findViewById(R.id.playerIndicatorTextView);
        TextView timerTextView = view.findViewById(R.id.timerTextView);
        TextView timerCountTextView = view.findViewById(R.id.timerCountTextView);
        TextView turnTextView = view.findViewById(R.id.turnTextView);
        TextView turnCountTextView = view.findViewById(R.id.turnCountTextView);

        Button undoButton = view.findViewById(R.id.undoButton);
        Button settingButton = view.findViewById(R.id.settingButton);
        Button restartButton = view.findViewById(R.id.restartButton);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadInGameSettingsFragment()");
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button0.setImageResource(android.R.color.transparent);
                button1.setImageResource(android.R.color.transparent);
                button2.setImageResource(android.R.color.transparent);
                button3.setImageResource(android.R.color.transparent);
                button4.setImageResource(android.R.color.transparent);
                button5.setImageResource(android.R.color.transparent);
                button6.setImageResource(android.R.color.transparent);
                button7.setImageResource(android.R.color.transparent);
                button8.setImageResource(android.R.color.transparent);

                playerIndicatorTextView.setText("Player 1 Turn");

                timerCountTextView.setText("0:10");
                turnCountTextView.setText("5");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button0.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button0.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button1.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button1.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button2.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button2.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button3.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button3.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button4.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button4.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button5.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button5.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button6.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button6.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button7.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button7.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1active) {
                    button8.setImageResource(player1markerid);
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button8.setImageResource(player2markerid);
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });






        return view;
    }
}