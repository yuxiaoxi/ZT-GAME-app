package com.example.zt_game_app.utils.https;

import java.util.Map;

import com.duowan.mobile.netroid.AuthFailureError;
import com.duowan.mobile.netroid.Listener;
import com.duowan.mobile.netroid.request.StringRequest;

public class PostByParamsRequest extends StringRequest {
    private Map<String, String> mParams;

    // 传入Post参数的Map集合
    public PostByParamsRequest(String url, Map<String, String> params, Listener<String> listener) {
        super(Method.POST, url, listener);
        mParams = params;
    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }

}