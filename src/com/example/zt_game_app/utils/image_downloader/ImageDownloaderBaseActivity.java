package com.example.zt_game_app.utils.image_downloader;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zt_game_app.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ImageDownloaderBaseActivity extends Activity {
	protected ImageLoader imageLoader = ImageLoader.getInstance();

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.item_clear_memory_cache) {
			imageLoader.clearMemoryCache();
			return true;
		} else if (itemId == R.id.item_clear_disc_cache) {
			imageLoader.clearDiscCache();
			return true;
		} else {
			return false;
		}
	}
}
