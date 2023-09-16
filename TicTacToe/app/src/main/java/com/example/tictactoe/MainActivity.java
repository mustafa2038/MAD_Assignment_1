package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MenuFragment menuFragment = new MenuFragment();
    GameFragmentSP1 gameFragmentSP1 = new GameFragmentSP1();
    GameFragmentSP2 gameFragmentSP2 = new GameFragmentSP2();
    GameFragmentSP3 gameFragmentSP3 = new GameFragmentSP3();
    GameFragmentMP1 gameFragmentMP1 = new GameFragmentMP1();
    GameFragmentMP2 gameFragmentMP2 = new GameFragmentMP2();
    GameFragmentMP3 gameFragmentMP3 = new GameFragmentMP3();
    GameSettingsPlay gameSettingsPlay = new GameSettingsPlay();
    GameSettingsInGame gameSettingsInGame = new GameSettingsInGame();
    PersonalisationFragment personalisationFragment = new PersonalisationFragment();
    AvatarListFragment avatarListFragment = new AvatarListFragment();
    AvatarListFragmentPlayer2 avatarListFragmentPlayer2 = new AvatarListFragmentPlayer2();
    MarkerListFragment markerListFragment = new MarkerListFragment();
    MarkerListFragmentPlayer2 markerListFragmentPlayer2 = new MarkerListFragmentPlayer2();
    LeaderboardFragment leaderboardFragment = new LeaderboardFragment();
    ExitGameConfirmFragment exitGameConfirmFragment = new ExitGameConfirmFragment();
    EndScreen endScreenFragment = new EndScreen();

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
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadGameFragmentMP1()")) {
                    loadGameFragmentMP1();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadGameFragmentMP2()")) {
                    loadGameFragmentMP2();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadGameFragmentMP3()")) {
                    loadGameFragmentMP3();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadGameFragmentSP1()")) {
                    loadGameFragmentSP1();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadGameFragmentSP2()")) {
                    loadGameFragmentSP2();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadGameFragmentSP3()")) {
                    loadGameFragmentSP3();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadExitGameConfirmFragment()")) {
                    loadExitGameConfirmFragment();
                }else if(mainActivityDataViewModel.getClickedValue().equals("loadEndScreenFragment()")) {
                    loadEndScreenFragment();
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

    public void loadGameFragmentMP1() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment gameFrag = fm.findFragmentById(R.id.main_container);
        GameFragmentMP1 newGameFragmentMP1 = new GameFragmentMP1();

        if(gameFrag == null) {
            fm.beginTransaction().add(R.id.main_container, newGameFragmentMP1).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, newGameFragmentMP1).commit();
        }
    }

    public void loadGameFragmentMP2() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment gameFrag = fm.findFragmentById(R.id.main_container);
        GameFragmentMP2 newGameFragmentMP2 = new GameFragmentMP2();

        if(gameFrag == null) {
            fm.beginTransaction().add(R.id.main_container, newGameFragmentMP2).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, newGameFragmentMP2).commit();
        }
    }

    public void loadGameFragmentMP3() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment gameFrag = fm.findFragmentById(R.id.main_container);
        GameFragmentMP3 newGameFragmentMP3 = new GameFragmentMP3();

        if(gameFrag == null) {
            fm.beginTransaction().add(R.id.main_container, newGameFragmentMP3).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, newGameFragmentMP3).commit();
        }
    }

    public void loadGameFragmentSP1() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment gameFrag = fm.findFragmentById(R.id.main_container);
        GameFragmentSP1 newGameFragmentSP1 = new GameFragmentSP1();

        if(gameFrag == null) {
            fm.beginTransaction().add(R.id.main_container, newGameFragmentSP1).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, newGameFragmentSP1).commit();
        }
    }

    public void loadGameFragmentSP2() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment gameFrag = fm.findFragmentById(R.id.main_container);
        GameFragmentSP2 newGameFragmentSP2 = new GameFragmentSP2();

        if(gameFrag == null) {
            fm.beginTransaction().add(R.id.main_container, newGameFragmentSP2).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, newGameFragmentSP2).commit();
        }
    }

    public void loadGameFragmentSP3() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment gameFrag = fm.findFragmentById(R.id.main_container);
        GameFragmentSP3 newGameFragmentSP3 = new GameFragmentSP3();

        if(gameFrag == null) {
            fm.beginTransaction().add(R.id.main_container, newGameFragmentSP3).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, newGameFragmentSP3).commit();
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

    public void loadExitGameConfirmFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment playGameSettingsFrag = fm.findFragmentById(R.id.main_container);

        if(playGameSettingsFrag == null) {
            fm.beginTransaction().add(R.id.main_container, exitGameConfirmFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, exitGameConfirmFragment).commit();
        }
    }

    public void loadEndScreenFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment playGameSettingsFrag = fm.findFragmentById(R.id.main_container);

        if(playGameSettingsFrag == null) {
            fm.beginTransaction().add(R.id.main_container, endScreenFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_container, endScreenFragment).commit();
        }
    }
}