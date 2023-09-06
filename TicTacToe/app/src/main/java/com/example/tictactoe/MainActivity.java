package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    MenuFragment menuFragment = new MenuFragment();
    GameFragment gameFragment = new GameFragment();
    GameSettingsPlay gameSettingsPlay = new GameSettingsPlay();
    GameSettingsInGame gameSettingsInGame = new GameSettingsInGame();
    PersonalisationFragment personalisationFragment = new PersonalisationFragment();
    AvatarListFragment avatarListFragment = new AvatarListFragment();
    AvatarListFragmentPlayer2 avatarListFragmentPlayer2 = new AvatarListFragmentPlayer2();
    MarkerListFragment markerListFragment = new MarkerListFragment();
    MarkerListFragmentPlayer2 markerListFragmentPlayer2 = new MarkerListFragmentPlayer2();
    LeaderboardFragment leaderboardFragment = new LeaderboardFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMenuFragment();


        MainActivityData mainActivityDataViewModel = new ViewModelProvider(this).get(MainActivityData.class);
        mainActivityDataViewModel.clickedValue.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String str) {
                if(mainActivityDataViewModel.getClickedValue().equals("loadPlayGameSettingsFragment()")) {
                    loadPlayGameSettingsFragment();
                } else if(mainActivityDataViewModel.getClickedValue().equals("loadPersonalisationFragment()")) {
                    loadPersonalisationFragment();
                } else if(mainActivityDataViewModel.getClickedValue().equals("loadLeaderboardFragment()")) {
                    loadLeaderboardFragment();
                } else if(mainActivityDataViewModel.getClickedValue().equals("loadMenuFragment()")) {
                    loadMenuFragment();
                } else if(mainActivityDataViewModel.getClickedValue().equals("loadAvatarListFragment()")) {
                    loadAvatarListFragment();
                } else if(mainActivityDataViewModel.getClickedValue().equals("loadAvatarListFragmentPlayer2()")) {
                    loadAvatarListFragmentPlayer2();
                } else if(mainActivityDataViewModel.getClickedValue().equals("loadMarkerListFragment()")) {
                    loadMarkerListFragment();
                } else if(mainActivityDataViewModel.getClickedValue().equals("loadMarkerListFragmentPlayer2()")) {
                    loadMarkerListFragmentPlayer2();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadInGameSettingsFragment()")) {
                    loadInGameSettingsFragment();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadGameFragment()")) {
                    loadGameFragment();
                }
            }
        });
    }

    public void loadMenuFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment menuFrag = fm.findFragmentById(R.id.main_container);

        if(menuFrag == null) {
            fm.beginTransaction().add(R.id.main_container, menuFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, menuFragment).commit();
        }
    }

    public void loadPlayGameSettingsFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment playGameSettingsFrag = fm.findFragmentById(R.id.main_container);

        if(playGameSettingsFrag == null) {
            fm.beginTransaction().add(R.id.main_container, gameSettingsPlay).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, gameSettingsPlay).commit();
        }
    }

    public void loadInGameSettingsFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment playGameSettingsFrag = fm.findFragmentById(R.id.main_container);

        if(playGameSettingsFrag == null) {
            fm.beginTransaction().add(R.id.main_container, gameSettingsInGame).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, gameSettingsInGame).commit();
        }
    }

    public void loadMarkerListFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment markerListFrag = fm.findFragmentById(R.id.main_container);

        if(markerListFrag == null) {
            fm.beginTransaction().add(R.id.main_container, markerListFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, markerListFragment).commit();
        }
    }

    public void loadMarkerListFragmentPlayer2() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment markerListFragPlayer2 = fm.findFragmentById(R.id.main_container);

        if(markerListFragPlayer2 == null) {
            fm.beginTransaction().add(R.id.main_container, markerListFragmentPlayer2).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, markerListFragmentPlayer2).commit();
        }
    }

    public void loadAvatarListFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment avatarListFrag = fm.findFragmentById(R.id.main_container);

        if(avatarListFrag == null) {
            fm.beginTransaction().add(R.id.main_container, avatarListFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, avatarListFragment).commit();
        }
    }

    public void loadAvatarListFragmentPlayer2() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment avatarListFragPlayer2 = fm.findFragmentById(R.id.main_container);

        if(avatarListFragPlayer2 == null) {
            fm.beginTransaction().add(R.id.main_container, avatarListFragmentPlayer2).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, avatarListFragmentPlayer2).commit();
        }
    }

    public void loadPersonalisationFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment personalisationFrag = fm.findFragmentById(R.id.main_container);

        if(personalisationFrag == null) {
            fm.beginTransaction().add(R.id.main_container, personalisationFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, personalisationFragment).commit();
        }
    }

    public void loadGameFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment gameFrag = fm.findFragmentById(R.id.main_container);

        if(gameFrag == null) {
            fm.beginTransaction().add(R.id.main_container, gameFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, gameFragment).commit();
        }
    }

    public void loadLeaderboardFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment playGameSettingsFrag = fm.findFragmentById(R.id.main_container);

        if(playGameSettingsFrag == null) {
            fm.beginTransaction().add(R.id.main_container, leaderboardFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, leaderboardFragment).commit();
        }
    }
}