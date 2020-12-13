package com.example.musicplayer.event;

import com.example.musicplayer.data.model.PlayList;

public class PlayListUpdatedEvent {

    PlayList playList;

    public PlayListUpdatedEvent(PlayList playList) {
        this.playList = playList;
    }
}
