package com.example.musicplayer.ui.base;

import android.graphics.Point;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.DialogFragment;

public class BaseDialogFragment extends DialogFragment {

    private static final float DIALOG_WIDTH_PROPORTION = 0.85f;

    protected void resizeDialogSize() {
        Window window = getDialog().getWindow();
        Point size = new Point();
        window.getWindowManager().getDefaultDisplay().getSize(size);
        window.setLayout((int) (size.x * DIALOG_WIDTH_PROPORTION), WindowManager.LayoutParams.WRAP_CONTENT);
    }
}
