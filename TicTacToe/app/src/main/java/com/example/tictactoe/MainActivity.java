package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    MenuFragment menuFragment = new MenuFragment();
    GameFragment gameFragment = new GameFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMenuFragment();

    }

    public void loadMenuFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment menuFrag = fm.findFragmentById(R.id.menuFragmentId);

        if(menuFrag == null) {
            fm.beginTransaction().add(R.id.main_container, menuFragment).commit();
        } else {
            fm.beginTransaction().add(R.id.main_container, menuFragment).commit();
        }
    }

    public void loadGameFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment gameFrag = fm.findFragmentById(R.id.gameFragmentId);

        if(gameFrag == null) {
            fm.beginTransaction().add(R.id.main_container, gameFragment).commit();
        } else {
            fm.beginTransaction().add(R.id.main_container, gameFragment).commit();
        }
    }
}