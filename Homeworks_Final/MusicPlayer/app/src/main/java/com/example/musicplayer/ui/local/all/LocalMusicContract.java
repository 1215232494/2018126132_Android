package com.example.musicplayer.ui.local.all;

import android.content.Context;

import androidx.loader.app.LoaderManager;

import com.example.musicplayer.data.model.Song;
import com.example.musicplayer.ui.base.BasePresenter;
import com.example.musicplayer.ui.base.BaseView;

import java.util.List;

/* package */ interface LocalMusicContract {

    interface View extends BaseView<Presenter> {

        LoaderManager getLoaderManager();

        Context getContext();

        void showProgress();

        void hideProgress();

        void emptyView(boolean visible);

        void handleError(Throwable error);

        void onLocalMusicLoaded(List<Song> songs);
    }

    interface Presenter extends BasePresenter {

        void loadLocalMusic();
    }
}
