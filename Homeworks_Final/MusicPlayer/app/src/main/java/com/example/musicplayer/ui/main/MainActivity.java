package com.example.musicplayer.ui.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import com.example.musicplayer.R;
import com.example.musicplayer.ui.base.BaseActivity;
import com.example.musicplayer.ui.base.BaseFragment;
import com.example.musicplayer.ui.local.LocalFilesFragment;
import com.example.musicplayer.ui.music.MusicPlayerFragment;
import com.example.musicplayer.ui.playlist.PlayListFragment;
import com.example.musicplayer.ui.settings.SettingsFragment;

import java.util.List;

public class MainActivity extends BaseActivity {

    static final int DEFAULT_PAGE_INDEX = 2;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindViews({R.id.radio_button_play_list, R.id.radio_button_music, R.id.radio_button_local_files, R.id.radio_button_settings})
    List<RadioButton> radioButtons;

    String[] mTitles;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        // Main Controls' Titles
        mTitles = getResources().getStringArray(R.array.mp_main_titles);

        // Fragments
        BaseFragment[] fragments = new BaseFragment[mTitles.length];
        fragments[0] = new PlayListFragment();
        fragments[1] = new MusicPlayerFragment();
        fragments[2] = new LocalFilesFragment();
        fragments[3] = new SettingsFragment();

        // Inflate ViewPager
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), mTitles, fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.mp_margin_large));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Empty
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Empty
            }

            @Override
            public void onPageSelected(int position) {
                radioButtons.get(position).setChecked(true);
            }
        });

        radioButtons.get(DEFAULT_PAGE_INDEX).setChecked(true);

//        //1.先请求判断是否具有对应权限
//        if(ContextCompat.checkSelfPermission
//                (this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED)
//        //根据返回的结果，判断对应的权限是否有。
//        {
//            ActivityCompat.requestPermissions
//                    (this,
//                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                            0);
//        }

        //2.先请求判断是否具有对应权限
        if(ContextCompat.checkSelfPermission
                (this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        //根据返回的结果，判断对应的权限是否有。
        {
            ActivityCompat.requestPermissions
                    (this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            0);
        }
//
//        //3.先请求判断是否具有对应权限
//        if(ContextCompat.checkSelfPermission
//                (this, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEM)
//                != PackageManager.PERMISSION_GRANTED)
//        //根据返回的结果，判断对应的权限是否有。
//        {
//            ActivityCompat.requestPermissions
//                    (this,
//                            new String[]{Manifest.permission.MOUNT_UNMOUNT_FILESYSTEM},
//                            0);
//        }


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @OnCheckedChanged({R.id.radio_button_play_list, R.id.radio_button_music, R.id.radio_button_local_files, R.id.radio_button_settings})
    public void onRadioButtonChecked(RadioButton button, boolean isChecked) {
        if (isChecked) {
            onItemChecked(radioButtons.indexOf(button));
        }
    }

    private void onItemChecked(int position) {
        viewPager.setCurrentItem(position);
        toolbar.setTitle(mTitles[position]);
    }
}
