package com.example.musicplayer.event;

import com.example.musicplayer.data.model.Song;

public class FavoriteChangeEvent {

    public Song song;

    public FavoriteChangeEvent(Song song) {
        this.song = song;
    }
}
