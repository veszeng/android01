package com.sct.screenshot;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.List;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;

import java.util.Map;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class ShotService extends Service {
	public static AlertDialog dialog;
	private ShotView mShotView;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i("myProject", "111111111111111111--------onBind:" + intent.getAction());
		return null;
	}

	@SuppressLint("WrongConstant")
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		  new Handler().postDelayed(new Runnable(){   
	            public void run() {   
	           	  Log.i("", "==============-textInteger 3333333333==============");
	           	OnScreenClick();
	            }   

	         }, 400);
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onCreate() {
		Log.i("myProject", "111111111111111111-------MyService create");

	}

	public void OnScreenClick() {

		Log.i("myProject", "11111111111111111------OnScreenClick--");
		if (Constants.isShot) {
			DisplayMetrics dm = new DisplayMetrics();
			dm = getResources().getDisplayMetrics();
			int screenWidth = dm.widthPixels;
			int screenHeight = dm.heightPixels;
			View view = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
			dialog = new AlertDialog.Builder(this, R.style.Dialog_Fullscreen).setView(view).create();
			dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG);
			dialog.setCancelable(true);
			dialog.setOnCancelListener(new OnCancelListener() {
				@Override
				public void onCancel(DialogInterface dialog) {
					Constants.isShot = true;
					mShotView.Bitmaprecycle();
				}
			});
			Constants.isShot = false;
			mShotView = (ShotView) view.findViewById(R.id.shotView);
			mShotView.getWidth_and_Height(screenWidth, screenHeight);
			mShotView.setDialog(dialog);
			Bitmap bgBitmap = mShotView.getBitmap();
			if (bgBitmap != null) {
				bgBitmap.recycle();
			}
			bgBitmap = SurfaceControl.screenshot(screenWidth, screenHeight);
			mShotView.setBitmap(bgBitmap);
			dialog.show();
			dialog.getWindow().setLayout(screenWidth, screenHeight);
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("myProject", "111111111111111111-----MyService---onDestroy");

	}

}
