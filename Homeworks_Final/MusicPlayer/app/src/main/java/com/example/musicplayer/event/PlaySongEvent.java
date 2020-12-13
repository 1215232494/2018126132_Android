package com.example.musicplayer.event;

import com.example.musicplayer.data.model.Song;

public class PlaySongEvent {

    public Song song;

    public PlaySongEvent(Song song) {
        this.song = song;
    }
}
