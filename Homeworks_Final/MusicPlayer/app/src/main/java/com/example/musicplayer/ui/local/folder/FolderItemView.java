package com.example.musicplayer.ui.local.folder;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.musicplayer.R;
import com.example.musicplayer.data.model.Folder;
import com.example.musicplayer.ui.base.adapter.IAdapterView;

public class FolderItemView extends RelativeLayout implements IAdapterView<Folder> {

    @BindView(R.id.text_view_name)
    TextView textViewName;
    @BindView(R.id.text_view_info)
    TextView textViewInfo;
    @BindView(R.id.layout_action)
    View buttonAction;

    public FolderItemView(Context context) {
        super(context);
        View.inflate(context, R.layout.item_added_folder, this);
        ButterKnife.bind(this);
    }

    @Override
    public void bind(Folder folder, int position) {
        textViewName.setText(folder.getName());
        textViewInfo.setText(getContext().getString(
                R.string.mp_local_files_folder_list_item_info_formatter,
                folder.getNumOfSongs(),
                folder.getPath()
        ));
    }
}
