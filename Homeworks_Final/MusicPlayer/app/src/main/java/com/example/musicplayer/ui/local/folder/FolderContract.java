package com.example.musicplayer.ui.local.folder;

import com.example.musicplayer.data.model.Folder;
import com.example.musicplayer.data.model.PlayList;
import com.example.musicplayer.ui.base.BasePresenter;
import com.example.musicplayer.ui.base.BaseView;

import java.io.File;
import java.util.List;

/* package */ interface FolderContract {

    interface View extends BaseView<Presenter> {

        void showLoading();

        void hideLoading();

        void handleError(Throwable error);

        void onFoldersLoaded(List<Folder> folders);

        void onFoldersAdded(List<Folder> folders);

        void onFolderUpdated(Folder folder);

        void onFolderDeleted(Folder folder);

        void onPlayListCreated(PlayList playList);
    }

    interface Presenter extends BasePresenter {

        void loadFolders();

        void addFolders(List<File> folders, List<Folder> existedFolders);

        void refreshFolder(Folder folder);

        void deleteFolder(Folder folder);

        void createPlayList(PlayList playList);

        void addFolderToPlayList(Folder folder, PlayList playList);
    }
}
