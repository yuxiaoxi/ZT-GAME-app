package com.example.zt_game_app.utils.https;

import com.duowan.mobile.netroid.Listener;
import com.duowan.mobile.netroid.NetworkResponse;
import com.duowan.mobile.netroid.Request;
import com.duowan.mobile.netroid.Response;

//修改优先级
public class MyRequest extends Request<Void> {

	public MyRequest(int method, String url, Listener<Void> listener) {
		super(method, url, listener);
	}

	@Override
	protected Response<Void> parseNetworkResponse(NetworkResponse arg0) {
		return null;
	}

	@Override
	public  com.duowan.mobile.netroid.Request.Priority getPriority() {
		return com.duowan.mobile.netroid.Request.Priority.LOW;
	}
	
	
	
}
