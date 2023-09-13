package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarkerListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarkerListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MarkerListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarkerListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarkerListFragment newInstance(String param1, String param2) {
        MarkerListFragment fragment = new MarkerListFragment();
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
        View view = inflater.inflate(R.layout.fragment_marker_list, container, false);

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
                mainActivityDataViewModel.setPlayer1MarkerDrawable(circleMarker.getDrawable());
                mainActivityDataViewModel.setPlayer1markerName("circle");
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        crossMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1MarkerDrawable(crossMarker.getDrawable());
                mainActivityDataViewModel.setPlayer1markerName("cross");
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        crownMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1MarkerDrawable(crownMarker.getDrawable());
                mainActivityDataViewModel.setPlayer1markerName("crown");
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        swordMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1MarkerDrawable(swordMarker.getDrawable());
                mainActivityDataViewModel.setPlayer1markerName("sword");
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        return view;
    }
}