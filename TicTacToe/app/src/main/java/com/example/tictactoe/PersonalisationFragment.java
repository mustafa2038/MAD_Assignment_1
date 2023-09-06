package com.example.tictactoe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalisationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalisationFragment extends Fragment {
    EditText player1Name;
    EditText player2Name;
    public PersonalisationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personalisation, container, false);

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        TextView title = view.findViewById(R.id.personalisationTitle);
        player1Name = view.findViewById(R.id.player1Text);
        player2Name = view.findViewById(R.id.player2Text);
        ImageView player1Avatar = (ImageView) view.findViewById(R.id.player1Avatar);
        ImageView player2Avatar = (ImageView) view.findViewById(R.id.player2Avatar);
        ImageView player1Marker = view.findViewById(R.id.player1Marker);
        ImageView player2Marker = view.findViewById(R.id.player2Marker);
        Button personalisationSaveButton = view.findViewById(R.id.personalisationSave);

        mainActivityDataViewModel.clickedValue.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String string) {

                String player1NameString = mainActivityDataViewModel.getPlayer1Name();
                String player2NameString = mainActivityDataViewModel.getPlayer2Name();

                Drawable player1AvatarDrawable = mainActivityDataViewModel.getPlayer1AvatarDrawable();
                Drawable player2AvatarDrawable = mainActivityDataViewModel.getPlayer2AvatarDrawable();

                Drawable player1MarkerDrawable = mainActivityDataViewModel.getPlayer1MarkerDrawable();
                Drawable player2MarkerDrawable = mainActivityDataViewModel.getPlayer2MarkerDrawable();


                player1Name.setText(player1NameString);
                player2Name.setText(player2NameString);

                player1Avatar.setImageDrawable(player1AvatarDrawable);
                player2Avatar.setImageDrawable(player2AvatarDrawable);

                player1Marker.setImageDrawable(player1MarkerDrawable);
                player2Marker.setImageDrawable(player2MarkerDrawable);
            }
        });

        personalisationSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1Name(player1Name.getText().toString());
                mainActivityDataViewModel.setPlayer2Name(player2Name.getText().toString());
                mainActivityDataViewModel.setClickedValue("loadMenuFragment()");
            }
        });

        player1Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1Name(player1Name.getText().toString());
                mainActivityDataViewModel.setPlayer2Name(player2Name.getText().toString());
                mainActivityDataViewModel.setClickedValue("loadAvatarListFragment()");
            }
        });

        player2Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1Name(player1Name.getText().toString());
                mainActivityDataViewModel.setPlayer2Name(player2Name.getText().toString());
                mainActivityDataViewModel.setClickedValue("loadAvatarListFragmentPlayer2()");
            }
        });

        player1Marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1Name(player1Name.getText().toString());
                mainActivityDataViewModel.setPlayer2Name(player2Name.getText().toString());
                mainActivityDataViewModel.setClickedValue("loadMarkerListFragment()");
            }
        });

        player2Marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1Name(player1Name.getText().toString());
                mainActivityDataViewModel.setPlayer2Name(player2Name.getText().toString());
                mainActivityDataViewModel.setClickedValue("loadMarkerListFragmentPlayer2()");
            }
        });

        return view;
    }
}