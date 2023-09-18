package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
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
        View rootView = inflater.inflate(R.layout.fragment_game_settings_play, container, false);
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        Button returnBut = rootView.findViewById(R.id.butReturn);
        Button playBut = rootView.findViewById(R.id.butPlayGame);
        Button boardBut1 = rootView.findViewById(R.id.butBoard1);
        Button boardBut2 = rootView.findViewById(R.id.butBoard2);
        Button boardBut3 = rootView.findViewById(R.id.butBoard3);
        Button streakBut1 = rootView.findViewById(R.id.butStreak1);
        Button streakBut2 = rootView.findViewById(R.id.butStreak2);
        Button streakBut3 = rootView.findViewById(R.id.butStreak3);



        mainActivityDataViewModel.boardClicked.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String str) {
                if(mainActivityDataViewModel.getBoardClicked().equals("T") && mainActivityDataViewModel.getStreakClicked().equals("T")) {
                    playBut.setVisibility(View.VISIBLE);
                } else {
                    playBut.setVisibility(View.INVISIBLE);
                }
            }
        });

        mainActivityDataViewModel.streakClicked.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String str) {
               if(mainActivityDataViewModel.getBoardClicked().equals("T") && mainActivityDataViewModel.getStreakClicked().equals("T")) {
                    playBut.setVisibility(View.VISIBLE);
                } else {
                    playBut.setVisibility(View.INVISIBLE);
                }
            }
        });

        returnBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadMenuFragment()");
            }
        });
        playBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardClicked("F");
                mainActivityDataViewModel.setStreakClicked("F");
                mainActivityDataViewModel.setBoardInfoPresent(false);
                mainActivityDataViewModel.resetBoardInfo();
               // mainActivityDataViewModel.setClickedValue("loadGameFragment()");
                if(mainActivityDataViewModel.getGameMode().equals("Singleplayer") && mainActivityDataViewModel.getBoardSize().equals("3x3"))
                {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentSP1()");
                }else if(mainActivityDataViewModel.getGameMode().equals("Singleplayer") && mainActivityDataViewModel.getBoardSize().equals("4x4"))
                {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentSP2()");
                }else if(mainActivityDataViewModel.getGameMode().equals("Singleplayer") && mainActivityDataViewModel.getBoardSize().equals("5x5"))
                {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentSP3()");
                }else if(mainActivityDataViewModel.getGameMode().equals("Multiplayer")&& mainActivityDataViewModel.getBoardSize().equals("3x3"))
                {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentMP1()");
                }else if(mainActivityDataViewModel.getGameMode().equals("Multiplayer")&& mainActivityDataViewModel.getBoardSize().equals("4x4"))
                {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentMP2()");
                }else if(mainActivityDataViewModel.getGameMode().equals("Multiplayer")&& mainActivityDataViewModel.getBoardSize().equals("5x5"))
                {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentMP3()");
                }

            }
        });
        boardBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardSize("3x3");
                mainActivityDataViewModel.setBoardClicked("T");
                streakBut1.setVisibility(View.VISIBLE);
                streakBut2.setVisibility(View.GONE);
                streakBut3.setVisibility(View.GONE);
            }
        });
        boardBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardSize("4x4");
                mainActivityDataViewModel.setBoardClicked("T");
                streakBut1.setVisibility(View.VISIBLE);
                streakBut2.setVisibility(View.VISIBLE);
                streakBut3.setVisibility(View.GONE);
            }
        });
        boardBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardSize("5x5");
                mainActivityDataViewModel.setBoardClicked("T");
                streakBut1.setVisibility(View.VISIBLE);
                streakBut2.setVisibility(View.VISIBLE);
                streakBut3.setVisibility(View.VISIBLE);
            }
        });
        streakBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setStreak("3");
                mainActivityDataViewModel.setStreakClicked("T");
            }
        });

        streakBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setStreak("4");
                mainActivityDataViewModel.setStreakClicked("T");
            }
        });

        streakBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setStreak("5");
                mainActivityDataViewModel.setStreakClicked("T");
            }
        });



        return rootView;
    }
}