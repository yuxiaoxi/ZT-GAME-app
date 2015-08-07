package com.example.zt_game_app.utils.https;

import java.io.File;

import org.apache.http.protocol.HTTP;

import android.content.Context;
import android.widget.ImageView;

import com.duowan.mobile.netroid.Listener;
import com.duowan.mobile.netroid.Network;
import com.duowan.mobile.netroid.RequestQueue;
import com.duowan.mobile.netroid.cache.BitmapImageCache;
import com.duowan.mobile.netroid.cache.DiskCache;
import com.duowan.mobile.netroid.image.NetworkImageView;
import com.duowan.mobile.netroid.stack.HurlStack;
import com.duowan.mobile.netroid.toolbox.BasicNetwork;
import com.duowan.mobile.netroid.toolbox.FileDownloader;
import com.duowan.mobile.netroid.toolbox.ImageLoader;

public class Netroid {

	// Netroid入口，私有该实例，提供方法对外服务。
	public static RequestQueue mRequestQueue;

	// 图片加载管理器，私有该实例，提供方法对外服务。
	private static ImageLoader mImageLoader;

	// 文件下载管理器，私有该实例，提供方法对外服务。
	private static FileDownloader mFileDownloader;

	private Netroid() {
	}

	public static void init(Context ctx) {
		if (mRequestQueue != null)
			throw new IllegalStateException("initialized");

		// 创建Netroid主类，指定硬盘缓存方案
		Network network = new BasicNetwork(
				new HurlStack(Const.USER_AGENT, null), HTTP.UTF_8);
		mRequestQueue = new RequestQueue(network, 4, new DiskCache(new File(
				ctx.getCacheDir(), Const.HTTP_DISK_CACHE_DIR_NAME),
				Const.HTTP_DISK_CACHE_SIZE));

		// 创建ImageLoader实例，指定内存缓存方案
		// 注：SelfImageLoader的实现示例请查看图片加载的相关文档
		// 注：ImageLoader及FileDownloader不是必须初始化的组件，如果没有用处，不需要创建实例
		mImageLoader = new SelfImageLoader(mRequestQueue, new BitmapImageCache(
				Const.HTTP_MEMORY_CACHE_SIZE));

		mFileDownloader = new FileDownloader(mRequestQueue, 1);

		mRequestQueue.start();
	}

	// 示例做法：执行自定义请求以获得书籍列表
	// public static void getBookList(int pageNo, Listener<List<Book>> listener)
	// {
	// mRequestQueue.add(new BookListRequest("http://server.com/book_list/" +
	// pageNo, listener));
	// }

	// 加载单张图片
	public static void displayImage(String url, ImageView imageView) {
		ImageLoader.ImageListener listener = ImageLoader.getImageListener(
				imageView, 0, 0);
		mImageLoader.get(url, listener, 0, 0);
	}

	// 批量加载图片
	public static void displayImage(String url, NetworkImageView imageView) {
		imageView.setImageUrl(url, mImageLoader);
	}

	// 执行文件下载请求
	public static FileDownloader.DownloadController addFileDownload(
			String storeFilePath, String url, Listener<Void> listener) {
		return mFileDownloader.add(storeFilePath, url, listener);
	}

}

class Const {
	// http parameters
	public static int maxMemory = (int) Runtime.getRuntime().maxMemory();
	public static final int HTTP_MEMORY_CACHE_SIZE = maxMemory / 8; // 2MB
	public static final int HTTP_DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB
	public static final String HTTP_DISK_CACHE_DIR_NAME = "netroid";
	public static final String USER_AGENT = "netroid.cn";
}