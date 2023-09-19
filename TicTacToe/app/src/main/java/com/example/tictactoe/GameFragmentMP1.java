package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameFragmentMP1 extends Fragment {
    Player player1;
    Player player2;
    boolean player1active = true;
    boolean player2active = false;

    int player1markerid = R.drawable.circle;
    int player2markerid = R.drawable.cross;
    private Handler timerHandler;
    private Runnable timerRunnable;
    private boolean timerPaused = false;
    private int turnCount;
    private List<String> boardInfo =  new ArrayList<>();
    private final List<String> boardInfoReset = Arrays.asList("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");

    private int timerCount = 10;

    private int STREAK_NUMBER = 3; // Set the streak number

    public GameFragmentMP1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        boardInfo = mainActivityDataViewModel.getBoardInfo();

        mainActivityDataViewModel.setGameMode("gameFragmentMP1");

        timerHandler = new Handler(Looper.getMainLooper());
        timerCount = 10;
        turnCount = 1;
        mainActivityDataViewModel.setTurnCount(1);

        player1 = new Player(mainActivityDataViewModel.getPlayer1Name(), mainActivityDataViewModel.getPlayer1AvatarDrawable(),
                mainActivityDataViewModel.getPlayer1MarkerDrawable(), mainActivityDataViewModel.getPlayer1markerName());
        player2 = new Player(mainActivityDataViewModel.getPlayer1Name(), mainActivityDataViewModel.getPlayer2AvatarDrawable(),
                mainActivityDataViewModel.getPlayer2MarkerDrawable(), mainActivityDataViewModel.getPlayer2markerName());

        mainActivityDataViewModel.setWinner(null);


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

                            turnCount++;
                            turnCountTextView.setText(Integer.toString(turnCount));
                            mainActivityDataViewModel.setTurnCount(turnCount);
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
                turnCount = 1;
                turnCountTextView.setText(Integer.toString(turnCount));
                mainActivityDataViewModel.setTurnCount(turnCount);

                boardInfo = boardInfoReset;
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button0.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button0.setImageResource(player1markerid);
                    boardInfo.set(0, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button0.setImageResource(player2markerid);
                    boardInfo.set(0, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button1.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button1.setImageResource(player1markerid);
                    boardInfo.set(1, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button1.setImageResource(player2markerid);
                    boardInfo.set(1, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button2.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button2.setImageResource(player1markerid);
                    boardInfo.set(2, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button2.setImageResource(player2markerid);
                    boardInfo.set(2, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button3.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button3.setImageResource(player1markerid);
                    boardInfo.set(3, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button3.setImageResource(player2markerid);
                    boardInfo.set(3, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button4.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button4.setImageResource(player1markerid);
                    boardInfo.set(4, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button4.setImageResource(player2markerid);
                    boardInfo.set(4, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button5.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button5.setImageResource(player1markerid);
                    boardInfo.set(5, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button5.setImageResource(player2markerid);
                    boardInfo.set(5, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button6.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button6.setImageResource(player1markerid);
                    boardInfo.set(6, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button6.setImageResource(player2markerid);
                    boardInfo.set(6, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button7.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button7.setImageResource(player1markerid);
                    boardInfo.set(7, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button7.setImageResource(player2markerid);
                    boardInfo.set(7, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button8.getDrawable() == null) {
                    timerCount = 10;
                }

                if (player1active) {
                    button8.setImageResource(player1markerid);
                    boardInfo.set(8, "p1");
                    player1active = false;
                    player2active = true;
                    playerIndicatorTextView.setText("Player 2 Turn");

                    if (checkForWin("p1")) {
                        mainActivityDataViewModel.setWinner(player1);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    } else if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                } else if (player2active) {
                    button8.setImageResource(player2markerid);
                    boardInfo.set(8, "p2");
                    player2active = false;
                    player1active = true;
                    playerIndicatorTextView.setText("Player 1 Turn");

                    turnCount++;
                    turnCountTextView.setText(Integer.toString(turnCount));
                    mainActivityDataViewModel.setTurnCount(turnCount);

                    if (checkForWin("p2")) {
                        mainActivityDataViewModel.setWinner(player2);
                        ((MainActivity) requireActivity()).loadEndScreenFragment();
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        boardInfo = mainActivityDataViewModel.getBoardInfo();
    }

    private boolean checkForWin(String playerMarker) {
        // Define the winning combinations
        int[][] winCombinations;

        // Choose the winning combinations based on STREAK_NUMBER
        if (STREAK_NUMBER == 3) {
            winCombinations = new int[][]{
                    // Rows
                    {0, 1, 2}, {3, 4, 5}, {6, 7, 8},

                    // Columns
                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8},

                    // Diagonals
                    {0, 4, 8}, {2, 4, 6}
            };
        } else if (STREAK_NUMBER == 4) {
            winCombinations = new int[][]{
                    // Rows
                    {0, 1, 2, 12}, {3, 4, 5, 13}, {6, 7, 8, 14}, {9, 10, 11, 15},

                    // Columns
                    {0, 3, 6, 9}, {1, 4, 7, 10}, {2, 5, 8, 11}, {12, 13, 14, 15},

                    // Diagonals
                    {0, 4, 8, 15}, {9, 7, 5, 12}
            };
        } else if (STREAK_NUMBER == 5) {
            winCombinations = new int[][]{
                    // Rows
                    {0, 1, 2, 12, 20}, {3, 4, 5, 13, 21}, {6, 7, 8, 14, 22},
                    {9, 10, 11, 15, 23}, {16, 17, 18, 19, 24},

                    // Columns
                    {0, 3, 6, 9, 16}, {1, 4, 7, 10, 17}, {2, 5, 8, 11, 18},
                    {12, 13, 14, 15, 19}, {20, 21, 22, 23, 24},

                    // Diagonals
                    {6, 10, 8, 13, 20}, {0, 4, 8, 15, 24}                                            // Diagonals
            };
        } else {
            return false; // Invalid STREAK_NUMBER
        }

        // Check each winning combination
        for (int[] combination : winCombinations) {
            boolean hasWon = true;
            for (int cell : combination) {
                if (!boardInfo.get(cell).equals(playerMarker)) {
                    hasWon = false;
                    break; // No need to check the rest of the cells in this combination
                }
            }
            if (hasWon) {
                return true; // Player has won
            }
        }

        return false; // No winning combination found
    }

}