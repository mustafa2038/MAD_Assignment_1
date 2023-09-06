package com.example.tictactoe;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityData extends ViewModel {
    public MutableLiveData<String> clickedValue = new MutableLiveData<>();

    public MainActivityData() {
        clickedValue.setValue("");
    }

    public String getClickedValue() {
        return clickedValue.getValue();
    }

    public void setClickedValue(String value) {
        clickedValue.setValue(value);
    }
}
