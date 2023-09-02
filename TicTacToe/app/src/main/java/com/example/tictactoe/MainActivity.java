package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    MenuFragment menuFragment = new MenuFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMenuFragment();
    }

    public void loadMenuFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment menuFrag = fm.findFragmentById(R.id.container);

        if(menuFrag == null) {
            fm.beginTransaction().add(R.id.container, menuFragment).commit();
        } else {
            fm.beginTransaction().add(R.id.container, menuFragment).commit();
        }
    }
}