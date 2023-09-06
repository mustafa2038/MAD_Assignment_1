package com.example.tictactoe;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityData extends ViewModel {
    public MutableLiveData<String> clickedValue = new MutableLiveData<>();
    public MutableLiveData<String> boardSize = new MutableLiveData<>();
    public MutableLiveData<String> streak = new MutableLiveData<>();
    public MutableLiveData<String> player1Name = new MutableLiveData<>();
    public MutableLiveData<String> player2Name = new MutableLiveData<>();

    public MutableLiveData<Drawable> player1AvatarDrawable = new MutableLiveData<Drawable>();
    public MutableLiveData<Drawable> player2AvatarDrawable = new MutableLiveData<Drawable>();

    public MutableLiveData<Drawable> player1MarkerDrawable = new MutableLiveData<>();
    public MutableLiveData<Drawable> player2MarkerDrawable = new MutableLiveData<>();
    public MutableLiveData<String> boardClicked = new MutableLiveData<>("F");
    public MutableLiveData<String> streakClicked = new MutableLiveData<>("F");

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

    public Drawable getPlayer1AvatarDrawable() {
        return player1AvatarDrawable.getValue();
    }

    public void setPlayer1AvatarDrawable(Drawable value) {
        player1AvatarDrawable.setValue(value);
    }

    public Drawable getPlayer2AvatarDrawable() {
        return player2AvatarDrawable.getValue();
    }

    public void setPlayer2AvatarDrawable(Drawable value) {
        player2AvatarDrawable.setValue(value);
    }

    public Drawable getPlayer1MarkerDrawable() {
        return player1MarkerDrawable.getValue();
    }

    public void setPlayer1MarkerDrawable(Drawable value) {
        player1MarkerDrawable.setValue(value);
    }

    public Drawable getPlayer2MarkerDrawable() {
        return player2MarkerDrawable.getValue();
    }

    public void setPlayer2MarkerDrawable(Drawable value) {
        player2MarkerDrawable.setValue(value);
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

    public String getBoardClicked(){return boardClicked.getValue();}
    public void setBoardClicked(String value){boardClicked.setValue(value);}
    public String getStreakClicked(){return streakClicked.getValue();}
    public void setStreakClicked(String value){streakClicked.setValue(value);}
}
