package com.example.tictactoe;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityData extends ViewModel {
    public MutableLiveData<String> clickedValue = new MutableLiveData<>();
    public MutableLiveData<String> player1Name = new MutableLiveData<>();
    public MutableLiveData<String> player2Name = new MutableLiveData<>();

    public MainActivityData() {
        clickedValue.setValue("");
    }

    public String getClickedValue() {
        return clickedValue.getValue();
    }

    public void setClickedValue(String value) {
        clickedValue.setValue(value);
    }

    public String getPlayer1Name() {
        return player1Name.getValue();
    }

    public void setPlayer1Name(String value) {
        this.player1Name.setValue(value);
    }

    public String getPlayer2Name() {
        return player2Name.getValue();
    }

    public void setPlayer2Name(String value) {
        this.player2Name.setValue(value);
    }
}
