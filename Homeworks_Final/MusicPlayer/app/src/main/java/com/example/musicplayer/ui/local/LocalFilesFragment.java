package com.example.musicplayer.ui.local;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import com.example.musicplayer.R;
import com.example.musicplayer.ui.base.BaseFragment;
import com.example.musicplayer.ui.local.all.AllLocalMusicFragment;
import com.example.musicplayer.ui.local.folder.FolderFragment;

import java.util.ArrayList;
import java.util.List;

public class LocalFilesFragment extends BaseFragment {

    // private static final String TAG = "LocalFilesFragment";

    static final int DEFAULT_SEGMENT_INDEX = 0;

    @BindViews({R.id.radio_button_all, R.id.radio_button_folder})
    List<RadioButton> segmentedControls;

    List<Fragment> mFragments = new ArrayList<>(2);

    final int[] FRAGMENT_CONTAINER_IDS = {
            R.id.layout_fragment_container_all, R.id.layout_fragment_container_folder
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments.add(new AllLocalMusicFragment());
        mFragments.add(new FolderFragment());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_local_files, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            Fragment fragment = mFragments.get(i);
            fragmentTransaction.add(FRAGMENT_CONTAINER_IDS[i], fragment, fragment.getTag());
            fragmentTransaction.hide(fragment);
        }
        fragmentTransaction.commit();

        segmentedControls.get(DEFAULT_SEGMENT_INDEX).setChecked(true);
    }

    @OnCheckedChanged({R.id.radio_button_all, R.id.radio_button_folder})
    public void onSegmentedChecked(RadioButton radioButton, boolean isChecked) {
        int index = segmentedControls.indexOf(radioButton);
        Fragment fragment = mFragments.get(index);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (isChecked) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.hide(fragment);
        }
        fragmentTransaction.commit();
    }
}
