package com.example.zt_game_app.test;

import java.util.ArrayList;

import com.example.zt_game_app.R;
import com.example.zt_game_app.utils.http.pulltorefresh.PullToRefreshBase.OnRefreshListener;
import com.example.zt_game_app.utils.http.pulltorefresh.PullToRefreshListView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class PullfreshTest extends Activity {
	private PullToRefreshListView mPullListView = null;
	private ListView mListView = null;
	public static final int MODE_PULL_DOWN_TO_REFRESH = 0x1; //下拉
	public static final int MODE_DEFAULT_LOAD = 0x2; //上拉
	private boolean isRefresh; //判断是否要清除更新
	private int mTimes = 0; //分页的页码
	private PullAdapter mAdapter; 
	private ArrayList<String> mList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pullfresh_test);
		initView();
		initData(mTimes);
	}

	private void initView() {
		mPullListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
		mPullListView.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh(int pullDirection) {
				switch (pullDirection) {
				// 1下拉,2上拉
				case MODE_PULL_DOWN_TO_REFRESH:
					isRefresh = true;
					mTimes = 0;
					initData(mTimes);
					break;
				case MODE_DEFAULT_LOAD:
					isRefresh = false;
					mTimes++;
					initData(mTimes);
					break;
				}
			}
		});
		mListView = mPullListView.getRefreshableView();
	}

	private void initData(int mTimes) {
		get(mTimes);
	}

	private void get(int mTimes) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("贺喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		list.add("恭喜老板");
		if (isRefresh == true) {
			mList.clear();
		}
		if (list != null) {
			for (String e : list) {
				mList.add(e);
			}
		}
		if (mAdapter == null) {
			if (mList != null) {
				mAdapter = new PullAdapter(mList, PullfreshTest.this);
				mListView.setAdapter(mAdapter);
			}
		} else {
			mAdapter.notifyDataSetChanged();
		}
		if (isRefresh == true) {
			mAdapter.notifyDataSetChanged();
		}
		mPullListView.onRefreshComplete();
	}

}
