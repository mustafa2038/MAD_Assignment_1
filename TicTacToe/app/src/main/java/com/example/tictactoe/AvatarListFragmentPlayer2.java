package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class AvatarListFragmentPlayer2 extends Fragment {
    public AvatarListFragmentPlayer2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_avatar_list_player2, container, false);

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        Button avatarSaveButton = view.findViewById(R.id.avatarSaveButton);
        Button avatarBackButton = view.findViewById(R.id.avatarBackButton);
        ImageView gigachadAvatar = view.findViewById(R.id.gigachadAvatar);
        ImageView laughingAvatar = view.findViewById(R.id.laughingAvatar);
        ImageView wojakAvatar = view.findViewById(R.id.wojakAvatar);
        ImageView pepeAvatar = view.findViewById(R.id.pepeAvatar);

        gigachadAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer2AvatarDrawable(gigachadAvatar.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        laughingAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer2AvatarDrawable(laughingAvatar.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        wojakAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer2AvatarDrawable(wojakAvatar.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        pepeAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer2AvatarDrawable(pepeAvatar.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        return view;
    }
}