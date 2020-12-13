package com.example.musicplayer.event;

import com.example.musicplayer.data.model.PlayList;

public class PlayListCreatedEvent {

    public PlayList playList;

    public PlayListCreatedEvent(PlayList playList) {
        this.playList = playList;
    }
}
