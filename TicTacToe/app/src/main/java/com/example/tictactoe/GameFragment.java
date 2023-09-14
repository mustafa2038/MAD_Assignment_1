package com.example.tictactoe;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameFragment extends Fragment {
    Player player1;
    Player player2;
    boolean player1active = true;
    boolean player2active = false;

    int player1markerid = R.drawable.circle;
    int player2markerid = R.drawable.cross;
    private Handler timerHandler;
    private Runnable timerRunnable;
    private boolean timerPaused = false;
    private List<String> boardInfo =  new ArrayList<>();

    private int timerCount = 10;
    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        boardInfo = mainActivityDataViewModel.getBoardInfo();

        timerHandler = new Handler(Looper.getMainLooper());
        timerCount = 10;

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


        timerRunnable = new Runnable() {
            @Override
            public void run() {
                if (!timerPaused) { // Check if the timer is not paused
                    // Update the timerCountTextView
                    timerCountTextView.setText(String.valueOf(timerCount));

                    // Decrement the timer count
                    timerCount--;

                    // Check if the timer has reached 0
                    if (timerCount >=0) {
                        // Schedule the next update in 1 second
                        timerHandler.postDelayed(this, 1000);
                    } else {
                        if(player1active) {
                            player1active = false;
                            player2active = true;
                            playerIndicatorTextView.setText("Player 2 Turn");
                        } else {
                            player2active = false;
                            player1active = true;
                            playerIndicatorTextView.setText("Player 1 Turn");
                        }
                        timerCount = 10;
                        timerHandler.postDelayed(this, 1000);
                    }
                } else {
                    // Timer is paused, do nothing for now
                }
            }
        };
        timerHandler.postDelayed(timerRunnable, 1000);

        if(mainActivityDataViewModel.getBoardInfoPresent())
        {
            for (int i = 0; i < boardInfo.size(); i++) {
                String element = boardInfo.get(i);
                if (element.equals("p1")) {
                    if (i == 0) {
                        button0.setImageResource(player1markerid);
                    } else if (i == 1) {
                        button1.setImageResource(player1markerid);
                    } else if (i == 2) {
                        button2.setImageResource(player1markerid);
                    } else if (i == 3) {
                        button3.setImageResource(player1markerid);
                    } else if (i == 4) {
                        button4.setImageResource(player1markerid);
                    } else if (i == 5) {
                        button5.setImageResource(player1markerid);
                    } else if (i == 6) {
                        button6.setImageResource(player1markerid);
                    } else if (i == 7) {
                        button7.setImageResource(player1markerid);
                    } else if (i == 8) {
                        button8.setImageResource(player1markerid);
                    }
                } else if (element.equals("p2")) {
                    if (i == 0) {
                        button0.setImageResource(player2markerid);
                    } else if (i == 1) {
                        button1.setImageResource(player2markerid);
                    } else if (i == 2) {
                        button2.setImageResource(player2markerid);
                    } else if (i == 3) {
                        button3.setImageResource(player2markerid);
                    } else if (i == 4) {
                        button4.setImageResource(player2markerid);
                    } else if (i == 5) {
                        button5.setImageResource(player2markerid);
                    } else if (i == 6) {
                        button6.setImageResource(player2markerid);
                    } else if (i == 7) {
                        button7.setImageResource(player2markerid);
                    } else if (i == 8) {
                        button8.setImageResource(player2markerid);
                    }
                }
            }
        }



        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardInfo(boardInfo);
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
                turnCountTextView.setText("5");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button0.setImageResource(player1markerid);
                    boardInfo.set(0,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button0.setImageResource(player2markerid);
                    boardInfo.set(0,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button1.setImageResource(player1markerid);
                    boardInfo.set(1,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button1.setImageResource(player2markerid);
                    boardInfo.set(1,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button2.setImageResource(player1markerid);
                    boardInfo.set(2,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button2.setImageResource(player2markerid);
                    boardInfo.set(2,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button3.setImageResource(player1markerid);
                    boardInfo.set(3,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button3.setImageResource(player2markerid);
                    boardInfo.set(3,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button4.setImageResource(player1markerid);
                    boardInfo.set(4,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button4.setImageResource(player2markerid);
                    boardInfo.set(4,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button5.setImageResource(player1markerid);
                    boardInfo.set(5,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button5.setImageResource(player2markerid);
                    boardInfo.set(5,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button6.setImageResource(player1markerid);
                    boardInfo.set(6,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button6.setImageResource(player2markerid);
                    boardInfo.set(6,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button7.setImageResource(player1markerid);
                    boardInfo.set(7,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button7.setImageResource(player2markerid);
                    boardInfo.set(7,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerCount = 10;

                if(player1active) {
                    button8.setImageResource(player1markerid);
                    boardInfo.set(8,"p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");
                } else {
                    button8.setImageResource(player2markerid);
                    boardInfo.set(8,"p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");
                }
            }
        });






        return view;
    }
}