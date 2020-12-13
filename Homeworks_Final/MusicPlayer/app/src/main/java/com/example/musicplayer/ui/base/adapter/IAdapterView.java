package com.example.musicplayer.ui.base.adapter;

/**
 * Desc: Reusable list item view.
 * - http://blog.csdn.net/kroclin/article/details/41830315
 */
public interface IAdapterView<T> {

    void bind(T item, int position);
}
