package com.example.tictactoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AvatarListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AvatarListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AvatarListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AvatarMarkerListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AvatarListFragment newInstance(String param1, String param2) {
        AvatarListFragment fragment = new AvatarListFragment();
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
        View view = inflater.inflate(R.layout.fragment_avatar_list, container, false);

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
                mainActivityDataViewModel.setPlayer1AvatarDrawable(gigachadAvatar.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        laughingAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1AvatarDrawable(laughingAvatar.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        wojakAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1AvatarDrawable(wojakAvatar.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        pepeAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setPlayer1AvatarDrawable(pepeAvatar.getDrawable());
                mainActivityDataViewModel.setClickedValue("loadPersonalisationFragment()");
            }
        });

        return view;
    }
}