package com.example.tictactoe;

import android.graphics.drawable.Drawable;

public class Player {
    private String playerName;
    private Drawable playerAvatar;
    private Drawable playerMarker;

    public Player(String playerName, Drawable playerAvatar, Drawable playerMarker) {
        this.playerName = playerName;
        this.playerAvatar = playerAvatar;
        this.playerMarker = playerMarker;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Drawable getPlayerAvatar() {
        return playerAvatar;
    }

    public void setPlayerAvatar(Drawable playerAvatar) {
        this.playerAvatar = playerAvatar;
    }

    public Drawable getPlayerMarker() {
        return playerMarker;
    }

    public void setPlayerMarker(Drawable playerMarker) {
        this.playerMarker = playerMarker;
    }
}
