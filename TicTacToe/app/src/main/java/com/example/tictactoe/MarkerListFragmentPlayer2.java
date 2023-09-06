package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MarkerListFragmentPlayer2 extends Fragment {
    public MarkerListFragmentPlayer2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_marker_list_player2, container, false);

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        Button markerSaveButton = view.findViewById(R.id.markerSaveButton);
        Button markerBackButton = view.findViewById(R.id.markerBackButton);
        ImageView circleMarker = view.findViewById(R.id.circleMarker);
        ImageView crossMarker = view.findViewById(R.id.crossMarker);
        ImageView crownMarker = view.findViewById(R.id.crownMarker);
        ImageView swordMarker = view.findViewById(R.id.swordMarker);

        circleMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer2MarkerDrawable(circleMarker.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        crossMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer2MarkerDrawable(crossMarker.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        crownMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer2MarkerDrawable(crownMarker.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        swordMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer2MarkerDrawable(swordMarker.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        return view;
    }
}