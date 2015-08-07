package com.example.zt_game_app.test;

import java.util.ArrayList;
import java.util.List;

import com.example.zt_game_app.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PullAdapter extends BaseAdapter {
	private Context mContext = null;
	private LayoutInflater mInflater = null;
	private List<String> mList;

	public PullAdapter(ArrayList<String> list, Context context) {
		this.mContext = context;
		this.mList = list;
		if (context != null) {
			this.mInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		LinearLayout layout = null;
		if (convertView == null) {
			layout = (LinearLayout) mInflater.inflate(R.layout.adapter_test,
					null);
		} else {
			layout = (LinearLayout) convertView;
		}
		TextView title = (TextView) layout.findViewById(R.id.title);
		title.setText(mList.get(position));
		return layout;
	}

}
