package com.example.tictactoe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersonalisationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonalisationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalisationFragment newInstance(String param1, String param2) {
        PersonalisationFragment fragment = new PersonalisationFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personalisation, container, false);

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        TextView title = view.findViewById(R.id.personalisationTitle);
        EditText player1Name = view.findViewById(R.id.player1Text);
        EditText player2Name = view.findViewById(R.id.player2Text);
        ImageView player1Avatar = (ImageView) view.findViewById(R.id.player1Avatar);
        ImageView player2Avatar = (ImageView) view.findViewById(R.id.player2Avatar);
        ImageView player1Marker = view.findViewById(R.id.player1Marker);
        ImageView player2Marker = view.findViewById(R.id.player2Marker);
        Button personalisationSaveButton = view.findViewById(R.id.personalisationSave);
        Button personalisationBackButton = view.findViewById(R.id.personalisationBack);

        mainActivityDataViewModel.clickedValue.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String string) {

                String player1NameString = mainActivityDataViewModel.getPlayer1Name();
                String player2NameString = mainActivityDataViewModel.getPlayer2Name();
                Drawable player1AvatarDrawable = mainActivityDataViewModel.getPlayer1AvatarDrawable();
                //ImageView player2AvatarSelection = mainActivityDataViewModel.getPlayer2AvatarDrawable();

                player1Name.setText(player1NameString);
                player2Name.setText(player2NameString);
                player1Avatar.setImageDrawable(player1AvatarDrawable);
            }
        });

        personalisationBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadMenuFragment()");
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
                mainActivityDataViewModel.setClickedValue("loadAvatarListFragment()");
            }
        });

        player2Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadAvatarListFragment()");
            }
        });

        player1Marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadMarkerListFragment()");
            }
        });

        player2Marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setClickedValue("loadMarkerListFragment()");
            }
        });

        return view;
    }
}