package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameSettingsInGame#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameSettingsInGame extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GameSettingsInGame() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameSettings.
     */
    // TODO: Rename and change types and number of parameters
    public static GameSettingsInGame newInstance(String param1, String param2) {
        GameSettingsInGame fragment = new GameSettingsInGame();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_settings_in_game, container, false);
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        Button returnBut = rootView.findViewById(R.id.butReturn);
        Button endGameBut = rootView.findViewById(R.id.butEndGame);
        Button streakBut1 = rootView.findViewById(R.id.butStreak1);
        Button streakBut2 = rootView.findViewById(R.id.butStreak2);
        Button streakBut3 = rootView.findViewById(R.id.butStreak3);

        endGameBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadExitGameConfirmFragment()");
            }
        });
        returnBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setBoardInfoPresent(true);

                if(mainActivityDataViewModel.getGameMode().equals("gameFragmentMP1")) {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentMP1()");
                } else if(mainActivityDataViewModel.getGameMode().equals("gameFragmentMP2")) {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentMP2()");
                } else if(mainActivityDataViewModel.getGameMode().equals("gameFragmentMP3")) {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentMP3()");
                } else if(mainActivityDataViewModel.getGameMode().equals("gameFragmentSP1")) {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentSP1()");
                } else if(mainActivityDataViewModel.getGameMode().equals("gameFragmentSP2")) {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentSP2()");
                } else if(mainActivityDataViewModel.getGameMode().equals("gameFragmentSP3")) {
                    mainActivityDataViewModel.setClickedValue("loadGameFragmentSP3()");
                }

            }
        });

        streakBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setStreak("3");
            }
        });

        streakBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setStreak("4");
            }
        });

        streakBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setStreak("5");
            }
        });

        return rootView;
    }
}