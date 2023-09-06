package com.example.tictactoe;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityData extends ViewModel {
    public MutableLiveData<String> clickedValue = new MutableLiveData<>();
    public MutableLiveData<String> boardSize = new MutableLiveData<>();
    public MutableLiveData<String> streak = new MutableLiveData<>();

    public MainActivityData() {
        clickedValue.setValue("");
    }

    public String getClickedValue() {
        return clickedValue.getValue();
    }

    public void setClickedValue(String value) {
        clickedValue.setValue(value);
    }

    public void setBoardSize(String value){
        boardSize.setValue(value);
    }

    public String getBoardSize(){
        return boardSize.getValue();
    }

    public void setStreak(String value){
        streak.setValue(value);
    }

    public String getStreak(){
        return streak.getValue();
    }

}
