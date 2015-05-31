package com.ifun361.musiclist.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ifun361.musiclist.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 版权所有 2005-2015 中国日报社网站。 保留所有权利。<br>
 * 项目名：Android客户端<br>
 * 描述：用户界面
 * 
 * @author baoxinyuan
 * @version 1.0
 * @since JDK1.6
 */
public class UserFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

	private static final int MENU_CLEAR_CACHE = 0;
	private static final int MENU_CLEAR_DOWNLOAD = MENU_CLEAR_CACHE + 1;
	private static final int MENU_SHARE = MENU_CLEAR_DOWNLOAD + 1;
	private static final int MENU_FEEDBACK = MENU_SHARE + 1;
	private static final int MENU_ABOUT_US = MENU_FEEDBACK + 1;

	private RelativeLayout mFragmentLayout;
	private ImageView mPlayerView;
	private TextView mTitleText;
	private TextView mCacheSizeView;
	private TextView mDownloadSizeView;
	private View mClearCache;
	private ArrayList<Object> mMenuView = new ArrayList<Object>();
	//private ArrayList<TextView> mMenuView = new ArrayList<TextView>();
	private Switch mWifiButton;

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
				R.layout.fragment_user, null);
		//mFragmentLayout.setBackgroundResource(R.drawable.bg_sample_03);
		initView();
		updateView();
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	// set up listeners and view variables
	private void initView() {
		/* set up view variables that need to be updated */
		mCacheSizeView = (TextView) mFragmentLayout.findViewById(R.id.clear_cache_data_size);
		mDownloadSizeView = (TextView) mFragmentLayout.findViewById(R.id.clear_download_data_size);
		mWifiButton = (Switch) mFragmentLayout.findViewById(R.id.wifi_only_toggle);
		mMenuView.add(MENU_CLEAR_CACHE, mFragmentLayout.findViewById(R.id.clear_cache_data));
		mMenuView.add(MENU_CLEAR_DOWNLOAD, mFragmentLayout.findViewById(R.id.clear_download_data));
		mMenuView.add(MENU_SHARE, mFragmentLayout.findViewById(R.id.share));
		mMenuView.add(MENU_FEEDBACK, mFragmentLayout.findViewById(R.id.feedback));
		mMenuView.add(MENU_ABOUT_US, mFragmentLayout.findViewById(R.id.about_us));

		/* set up listeners */
		mWifiButton.setOnCheckedChangeListener(this);
		for (int i = 0; i < mMenuView.size(); i ++){
			View v = (View) mMenuView.get(i);
			v.setOnClickListener(this);
		}
	}

	//update some static elements of the view
	private void updateView() {
		mCacheSizeView.setText("xxxM");
		mDownloadSizeView.setText("xxxD");
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

	@Override
	public void onClick(View view) {
		int index = mMenuView.indexOf(view);
		switch (index){
			case MENU_CLEAR_CACHE :
				Toast.makeText(this.getActivity(), "clear cache", Toast.LENGTH_SHORT).show();
				break;
			case MENU_CLEAR_DOWNLOAD:
				Toast.makeText(this.getActivity(), "clear downloaded data", Toast.LENGTH_SHORT).show();
				break;
			case MENU_SHARE:
				Toast.makeText(this.getActivity(), "share", Toast.LENGTH_SHORT).show();
				break;
			case MENU_FEEDBACK:
				Toast.makeText(this.getActivity(), "feedback", Toast.LENGTH_SHORT).show();
				break;
			case MENU_ABOUT_US:
				Toast.makeText(this.getActivity(), "about us", Toast.LENGTH_SHORT).show();
				break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
		if (b)
			Toast.makeText(this.getActivity(), "wifi is on", Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(this.getActivity(), "wifi if off", Toast.LENGTH_SHORT).show();

	}
}