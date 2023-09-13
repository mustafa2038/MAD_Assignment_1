package com.example.tictactoe;

import android.graphics.drawable.Drawable;

public class Player {
    private String playerName;
    private Drawable playerAvatar;
    private Drawable playerMarker;
    private String playerMarkerName;

    public Player(String playerName, Drawable playerAvatar, Drawable playerMarker, String playerMarkerName) {
        this.playerName = playerName;
        this.playerAvatar = playerAvatar;
        this.playerMarker = playerMarker;
        this.playerMarkerName = playerMarkerName;
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

    public String getPlayerMarkerName() {
        return playerMarkerName;
    }

    public void setPlayer1MarkerName(String playerMarkerName) {
        this.playerMarkerName = playerMarkerName;
    }
}
