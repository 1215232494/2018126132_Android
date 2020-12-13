package com.example.musicplayer.event;

import com.example.musicplayer.data.model.PlayList;

public class PlayListNowEvent {

    public PlayList playList;
    public int playIndex;

    public PlayListNowEvent(PlayList playList, int playIndex) {
        this.playList = playList;
        this.playIndex = playIndex;
    }
}
