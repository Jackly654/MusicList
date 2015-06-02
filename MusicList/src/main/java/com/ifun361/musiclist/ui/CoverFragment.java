package com.ifun361.musiclist.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ifun361.musiclist.R;

public class CoverFragment extends BaseFragment {

    private RelativeLayout mFragmentLayout;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setContentView(mFragmentLayout);

        Bundle args = savedInstanceState;
        if (args == null) {
            args = getArguments();
        }

        initAlbumState(args);
    }

    private void initAlbumState(Bundle state) {
        if (state != null) {
        }
        setFragmentLoading();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentLayout = (RelativeLayout) inflater.inflate(R.layout.activity_cover_fragment, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
