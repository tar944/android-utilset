package com.navercorp.utilset.storage;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import android.content.Context;

/**
 * 
 * @author jaemin.woo
 *
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class DiskUtilsTest {
	private Context context;

	@Before
	public void setUp() {
		ShadowLog.stream = System.out;
		this.context = Robolectric.application;
	}
	
	public boolean isExternalStorageMounted() {
		return DiskUtils.isExternalStorageMounted();
	}
	
	@Test
	public void shouldReturnExternalDirectoryPathIfExternalStorageIsMounted() {
		if (!isExternalStorageMounted())
			return;
		
		String root = DiskUtils.getExternalContextRootDir(context);
		assertNotNull(root);
	}
	
	@Test
	public void shouldReturnExternalContextRootDirectoryIfExternalStorageIsMounted() {
		if (!isExternalStorageMounted())
			return;
		
		String root = DiskUtils.getExternalContextRootDir(context);
		assertNotNull(root);
		
		String path = DiskUtils.getExternalDirPath(context);
		assertNotNull(path);
		
		assertEquals(root + DiskUtils.CACHE_FOLDER, path);
	}
	
	@Test
	public void shouldReturnExternalTemporaryDirectoryPathIfExternalStorageIsMounted() {
		if (!isExternalStorageMounted())
			return;
		
		String root = DiskUtils.getExternalContextRootDir(context);
		assertNotNull(root);
		
		String path = DiskUtils.getExternalTemporaryDirPath(context);
		assertNotNull(path);
		
		assertEquals(root + DiskUtils.TEMPORARY_FOLDER, path);
	}
}
