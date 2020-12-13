package com.example.musicplayer.ui.music;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.musicplayer.data.model.Song;
import com.example.musicplayer.player.PlayMode;
import com.example.musicplayer.player.PlaybackService;
import com.example.musicplayer.ui.base.BasePresenter;
import com.example.musicplayer.ui.base.BaseView;

/* package */ interface MusicPlayerContract {

    interface View extends BaseView<Presenter> {

        void handleError(Throwable error);

        void onPlaybackServiceBound(PlaybackService service);

        void onPlaybackServiceUnbound();

        void onSongSetAsFavorite(@NonNull Song song);

        void onSongUpdated(@Nullable Song song);

        void updatePlayMode(PlayMode playMode);

        void updatePlayToggle(boolean play);

        void updateFavoriteToggle(boolean favorite);
    }

    interface Presenter extends BasePresenter {

        void retrieveLastPlayMode();

        void setSongAsFavorite(Song song, boolean favorite);

        void bindPlaybackService();

        void unbindPlaybackService();
    }
}
