package com.example.tictactoe;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameFragmentSP3 extends Fragment {
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
    private List<ImageButton> buttonsList = new ArrayList<>();

    private int timerCount = 10;
    public GameFragmentSP3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game_s_p3, container, false);

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
        ImageButton button9 = view.findViewById(R.id.button9);
        ImageButton button10 = view.findViewById(R.id.button10);
        ImageButton button11 = view.findViewById(R.id.button11);
        ImageButton button12 = view.findViewById(R.id.button12);
        ImageButton button13 = view.findViewById(R.id.button13);
        ImageButton button14 = view.findViewById(R.id.button14);
        ImageButton button15 = view.findViewById(R.id.button15);
        ImageButton button16 = view.findViewById(R.id.button16);
        ImageButton button17 = view.findViewById(R.id.button17);
        ImageButton button18 = view.findViewById(R.id.button18);
        ImageButton button19 = view.findViewById(R.id.button19);
        ImageButton button20 = view.findViewById(R.id.button20);
        ImageButton button21 = view.findViewById(R.id.button21);
        ImageButton button22 = view.findViewById(R.id.button22);
        ImageButton button23 = view.findViewById(R.id.button23);
        ImageButton button24 = view.findViewById(R.id.button24);


        buttonsList.add(button0);
        buttonsList.add(button1);
        buttonsList.add(button2);
        buttonsList.add(button3);
        buttonsList.add(button4);
        buttonsList.add(button5);
        buttonsList.add(button6);
        buttonsList.add(button7);
        buttonsList.add(button8);
        buttonsList.add(button9);
        buttonsList.add(button10);
        buttonsList.add(button11);
        buttonsList.add(button12);
        buttonsList.add(button13);
        buttonsList.add(button14);
        buttonsList.add(button15);
        buttonsList.add(button16);
        buttonsList.add(button17);
        buttonsList.add(button18);
        buttonsList.add(button19);
        buttonsList.add(button20);
        buttonsList.add(button21);
        buttonsList.add(button22);
        buttonsList.add(button23);
        buttonsList.add(button24);


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
                        computerTurn(player2markerid, playerIndicatorTextView);
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
                    } else if (i == 9) {
                        button9.setImageResource(player1markerid);
                    } else if (i == 10) {
                        button10.setImageResource(player1markerid);
                    } else if (i == 11) {
                        button11.setImageResource(player1markerid);
                    } else if (i == 12) {
                        button12.setImageResource(player1markerid);
                    } else if (i == 13) {
                        button13.setImageResource(player1markerid);
                    } else if (i == 14) {
                        button14.setImageResource(player1markerid);
                    } else if (i == 15) {
                        button15.setImageResource(player1markerid);
                    } else if (i == 16) {
                        button1.setImageResource(player1markerid);
                    } else if (i == 17) {
                        button2.setImageResource(player1markerid);
                    } else if (i == 18) {
                        button3.setImageResource(player1markerid);
                    } else if (i == 19) {
                        button4.setImageResource(player1markerid);
                    } else if (i == 20) {
                        button5.setImageResource(player1markerid);
                    } else if (i == 21) {
                        button6.setImageResource(player1markerid);
                    } else if (i == 22) {
                        button7.setImageResource(player1markerid);
                    } else if (i == 23) {
                        button8.setImageResource(player1markerid);
                    } else if (i == 24) {
                        button9.setImageResource(player1markerid);
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
                    } else if (i == 9) {
                        button9.setImageResource(player1markerid);
                    } else if (i == 10) {
                        button10.setImageResource(player1markerid);
                    } else if (i == 11) {
                        button11.setImageResource(player1markerid);
                    } else if (i == 12) {
                        button12.setImageResource(player1markerid);
                    } else if (i == 13) {
                        button13.setImageResource(player1markerid);
                    } else if (i == 14) {
                        button14.setImageResource(player1markerid);
                    } else if (i == 15) {
                        button15.setImageResource(player1markerid);
                    } else if (i == 16) {
                        button1.setImageResource(player1markerid);
                    } else if (i == 17) {
                        button2.setImageResource(player1markerid);
                    } else if (i == 18) {
                        button3.setImageResource(player1markerid);
                    } else if (i == 19) {
                        button4.setImageResource(player1markerid);
                    } else if (i == 20) {
                        button5.setImageResource(player1markerid);
                    } else if (i == 21) {
                        button6.setImageResource(player1markerid);
                    } else if (i == 22) {
                        button7.setImageResource(player1markerid);
                    } else if (i == 23) {
                        button8.setImageResource(player1markerid);
                    } else if (i == 24) {
                        button9.setImageResource(player1markerid);
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
                button9.setImageResource(android.R.color.transparent);
                button10.setImageResource(android.R.color.transparent);
                button11.setImageResource(android.R.color.transparent);
                button12.setImageResource(android.R.color.transparent);
                button13.setImageResource(android.R.color.transparent);
                button14.setImageResource(android.R.color.transparent);
                button15.setImageResource(android.R.color.transparent);
                button16.setImageResource(android.R.color.transparent);
                button17.setImageResource(android.R.color.transparent);
                button18.setImageResource(android.R.color.transparent);
                button19.setImageResource(android.R.color.transparent);
                button20.setImageResource(android.R.color.transparent);
                button21.setImageResource(android.R.color.transparent);
                button22.setImageResource(android.R.color.transparent);
                button23.setImageResource(android.R.color.transparent);
                button24.setImageResource(android.R.color.transparent);

                playerIndicatorTextView.setText("Player 1 Turn");
                turnCountTextView.setText("5");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button0.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button0.setImageResource(player1markerid);
                        boardInfo.set(0, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button0.setImageResource(player2markerid);
                        boardInfo.set(0, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button1.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button1.setImageResource(player1markerid);
                        boardInfo.set(1, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button1.setImageResource(player2markerid);
                        boardInfo.set(1, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button2.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button2.setImageResource(player1markerid);
                        boardInfo.set(2, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button2.setImageResource(player2markerid);
                        boardInfo.set(2, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button3.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button3.setImageResource(player1markerid);
                        boardInfo.set(3, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button3.setImageResource(player2markerid);
                        boardInfo.set(3, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button4.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button4.setImageResource(player1markerid);
                        boardInfo.set(4, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button4.setImageResource(player2markerid);
                        boardInfo.set(4, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button5.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button5.setImageResource(player1markerid);
                        boardInfo.set(5, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button5.setImageResource(player2markerid);
                        boardInfo.set(5, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button6.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button6.setImageResource(player1markerid);
                        boardInfo.set(6, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button6.setImageResource(player2markerid);
                        boardInfo.set(6, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button7.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button7.setImageResource(player1markerid);
                        boardInfo.set(7, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button7.setImageResource(player2markerid);
                        boardInfo.set(7, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button8.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button8.setImageResource(player1markerid);
                        boardInfo.set(8, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button8.setImageResource(player2markerid);
                        boardInfo.set(8, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button9.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button9.setImageResource(player1markerid);
                        boardInfo.set(9, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button9.setImageResource(player2markerid);
                        boardInfo.set(9, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button10.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button10.setImageResource(player1markerid);
                        boardInfo.set(10, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button10.setImageResource(player2markerid);
                        boardInfo.set(8, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button11.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button11.setImageResource(player1markerid);
                        boardInfo.set(11, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button11.setImageResource(player2markerid);
                        boardInfo.set(11, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button12.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button12.setImageResource(player1markerid);
                        boardInfo.set(12, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button12.setImageResource(player2markerid);
                        boardInfo.set(12, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button13.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button13.setImageResource(player1markerid);
                        boardInfo.set(13, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button13.setImageResource(player2markerid);
                        boardInfo.set(13, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button14.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button14.setImageResource(player1markerid);
                        boardInfo.set(14, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button14.setImageResource(player2markerid);
                        boardInfo.set(14, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button15.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button15.setImageResource(player1markerid);
                        boardInfo.set(15, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button15.setImageResource(player2markerid);
                        boardInfo.set(15, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button16.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button16.setImageResource(player1markerid);
                        boardInfo.set(16, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button16.setImageResource(player2markerid);
                        boardInfo.set(16, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button17.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button17.setImageResource(player1markerid);
                        boardInfo.set(17, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button17.setImageResource(player2markerid);
                        boardInfo.set(17, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button18.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button18.setImageResource(player1markerid);
                        boardInfo.set(18, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button18.setImageResource(player2markerid);
                        boardInfo.set(18, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button19.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button19.setImageResource(player1markerid);
                        boardInfo.set(19, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button19.setImageResource(player2markerid);
                        boardInfo.set(19, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button20.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button20.setImageResource(player1markerid);
                        boardInfo.set(20, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button20.setImageResource(player2markerid);
                        boardInfo.set(20, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button21.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button21.setImageResource(player1markerid);
                        boardInfo.set(21, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button21.setImageResource(player2markerid);
                        boardInfo.set(21, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button22.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button22.setImageResource(player1markerid);
                        boardInfo.set(22, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button21.setImageResource(player2markerid);
                        boardInfo.set(22, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button23.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button23.setImageResource(player1markerid);
                        boardInfo.set(23, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button23.setImageResource(player2markerid);
                        boardInfo.set(23, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button24.getDrawable() == null) {
                    timerCount = 10;

                    if (player1active) {
                        button24.setImageResource(player1markerid);
                        boardInfo.set(24, "p1");
                        player1active = false;
                        player2active = true;
                        playerIndicatorTextView.setText("Player 2 Turn");

                        if (checkForWin("p1")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        } else {
                            computerTurn(player2markerid, playerIndicatorTextView);
                        }
                    } else if (player2active) {
                        button24.setImageResource(player2markerid);
                        boardInfo.set(24, "p2");
                        player2active = false;
                        player1active = true;
                        playerIndicatorTextView.setText("Player 1 Turn");

                        if (checkForWin("p2")) {
                            ((MainActivity) requireActivity()).loadEndScreenFragment();
                        }
                    }
                }
            }
        });

        return view;
    }

    private void computerTurn(int player2MarkerId, TextView playerIndicatorTextView)
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                List<ImageButton> shuffledButtons = new ArrayList<>(buttonsList);
                Collections.shuffle(shuffledButtons);

                for (ImageButton button : shuffledButtons)
                {
                    if (button.getDrawable() == null)
                    {
                        int originalIndex = buttonsList.indexOf(button);

                        button.setImageResource(player2MarkerId);
                        boardInfo.set(originalIndex, "p2");

                        player1active = true;
                        player2active = false;
                        playerIndicatorTextView.setText("Player 1 Turn");
                        break;
                    }
                }
            }
        }, 1000);
    }

    private boolean checkForWin(String playerMarker) {
        // Define the winning combinations for a 5x5 grid
        int[][] winCombinations = {
                // Rows
                {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24},

                // Columns
                {0, 5, 10, 15, 20}, {1, 6, 11, 16, 21}, {2, 7, 12, 17, 22},
                {3, 8, 13, 18, 23}, {4, 9, 14, 19, 24},

                // Diagonals
                {0, 6, 12, 18, 24}, {4, 8, 12, 16, 20}
        };

        // Check each winning combination
        for (int[] combination : winCombinations) {
            boolean hasWon = true;

            for (int cell : combination) {
                if (!boardInfo.get(cell).equals(playerMarker)) {
                    hasWon = false;
                    break;
                }
            }

            if (hasWon) {
                return true; // Player has won
            }
        }

        return false; // No winning combination found
    }


}