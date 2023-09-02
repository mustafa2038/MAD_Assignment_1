package com.example.tictactoe;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityData extends ViewModel {
    public MutableLiveData<Integer> clickedValue = new MutableLiveData<>();

    public MainActivityData() {
        clickedValue.setValue(0);
    }

    public int getClickedValue() {
        return clickedValue.getValue();
    }

    public void setClickedValue(int value) {
        clickedValue.setValue(value);
    }
}
