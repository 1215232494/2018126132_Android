package com.example.musicplayer.ui.playlist;

import com.example.musicplayer.data.model.PlayList;
import com.example.musicplayer.ui.base.BasePresenter;
import com.example.musicplayer.ui.base.BaseView;

import java.util.List;

/* package */ interface PlayListContract {

    interface View extends BaseView<Presenter> {

        void showLoading();

        void hideLoading();

        void handleError(Throwable error);

        void onPlayListsLoaded(List<PlayList> playLists);

        void onPlayListCreated(PlayList playList);

        void onPlayListEdited(PlayList playList);

        void onPlayListDeleted(PlayList playList);
    }

    interface Presenter extends BasePresenter {

        void loadPlayLists();

        void createPlayList(PlayList playList);

        void editPlayList(PlayList playList);

        void deletePlayList(PlayList playList);
    }
}
