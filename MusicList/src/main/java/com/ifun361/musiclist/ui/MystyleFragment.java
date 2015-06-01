package com.ifun361.musiclist.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ifun361.musiclist.R;

/**
 * 版权所有 2005-2015 中国日报社网站。 保留所有权利。<br>
 * 项目名：Android客户端<br>
 * 描述：收藏界面(改为我的格调)
 * 
 * @author baoxinyuan
 * @version 1.0
 * @since JDK1.6
 */
public class MystyleFragment extends BaseFragment {

	private RelativeLayout mFragmentLayout;
	private ImageView mPlayerView;
	private TextView mTitleText;

    protected ImageView topTitleLeftIcon;

	private Handler mDataSetHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				initDataSet();
				break;
			default:
			}
		}
	};

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setContentView(mFragmentLayout);
		Bundle args = savedInstanceState;
		if (args == null) {
			args = getArguments();
		}
		initAlbumState(args);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mFragmentLayout = (RelativeLayout) inflater.inflate(
				R.layout.fragment_mystyle, null);
		mFragmentLayout.setBackgroundResource(R.drawable.bg_sample_02);

        initView();
		return super.onCreateView(inflater, container, savedInstanceState);

	}

    private void initView() {
        topTitleLeftIcon = (ImageView) getActivity().findViewById(R.id.top_title_left_icon);
        topTitleLeftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "onClick", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
	public void onHiddenChanged(boolean hidden) {
		if (hidden) {
			super.onHiddenChanged(hidden);
		} else {
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onFragmentRefresh() {
		initAlbumState(null);
	}

	private void initAlbumState(Bundle state) {
		if (state != null) {
		}
		setFragmentLoading();
		mDataSetHandler.sendEmptyMessage(1);
		mDataSetHandler.sendEmptyMessageDelayed(0, 400);
	}

	private void initDataSet() {
		setFragmentShowData();
	}



}