package com.example.zt_game_app.utils.https;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.protocol.HTTP;

import android.content.res.AssetManager;

import com.duowan.mobile.netroid.NetworkResponse;
import com.duowan.mobile.netroid.RequestQueue;
import com.duowan.mobile.netroid.request.ImageRequest;
import com.duowan.mobile.netroid.toolbox.ImageLoader;

public class SelfImageLoader extends ImageLoader {

	public static final String RES_ASSETS = "assets://";
    public static final String RES_SDCARD = "sdcard://";
    public static final String RES_HTTP = "http://";
    
    private AssetManager mAssetManager;
    
    
    
	public SelfImageLoader(RequestQueue queue, ImageCache imageCache) {
		super(queue, imageCache);
		// TODO Auto-generated constructor stub
	}

	public SelfImageLoader(RequestQueue queue, ImageCache imageCache,AssetManager mAssetManager) {
		super(queue, imageCache);
		this.mAssetManager = mAssetManager;
	}

	@Override
    public ImageRequest buildRequest(String requestUrl, int maxWidth, int maxHeight) {
        ImageRequest request;
        if (requestUrl.startsWith(RES_ASSETS)) {
            request = new ImageRequest(requestUrl.substring(RES_ASSETS.length()), maxWidth, maxHeight) {
                @Override
                public NetworkResponse perform() {
                    try {
                        return new NetworkResponse(toBytes(mAssetManager.open(getUrl())), HTTP.UTF_8);
                    } catch (IOException e) {
                        return new NetworkResponse(new byte[1], HTTP.UTF_8);
                    }
                }
            };
        }
        else if (requestUrl.startsWith(RES_SDCARD)) {
            request = new ImageRequest(requestUrl.substring(RES_SDCARD.length()), maxWidth, maxHeight) {
                @Override
                public NetworkResponse perform() {
                    try {
                        return new NetworkResponse(toBytes(new FileInputStream(getUrl())), HTTP.UTF_8);
                    } catch (IOException e) {
                        return new NetworkResponse(new byte[1], HTTP.UTF_8);
                    }
                }
            };
        }
        else if (requestUrl.startsWith(RES_HTTP)) {
            request = new ImageRequest(requestUrl, maxWidth, maxHeight);
        }
        else {
            return null;
        }

        //makeRequest(request);
        return request;
    }
	
	public byte[]  toBytes(InputStream fs){
		byte [] bte= new byte[1024];
		try {
			fs.read(bte);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bte;
		
	}
	

}

/*// 示例：读取http资源的调用方法
String url = "http://server.domain/sample.jpg";
ImageLoader.get(url, listener);

// 示例：读取assets资源的调用方法
String url = SelfImageLoader.RES_ASSETS + "sample.jpg";
ImageLoader.get(url, listener);

// 示例：读取sdcard资源的调用方法
String url = SelfImageLoader.RES_SDCARD + "/sdcard/sample.jpg";
ImageLoader.get(url, listener);*/
