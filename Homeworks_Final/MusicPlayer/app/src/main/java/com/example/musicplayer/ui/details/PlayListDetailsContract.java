package com.example.musicplayer.ui.details;

import com.example.musicplayer.data.model.PlayList;
import com.example.musicplayer.data.model.Song;
import com.example.musicplayer.ui.base.BasePresenter;
import com.example.musicplayer.ui.base.BaseView;

public interface PlayListDetailsContract {

    interface View extends BaseView<Presenter> {

        void showLoading();

        void hideLoading();

        void handleError(Throwable e);

        void onSongDeleted(Song song);
    }

    interface Presenter extends BasePresenter {

        void addSongToPlayList(Song song, PlayList playList);

        void delete(Song song, PlayList playList);
    }
}
