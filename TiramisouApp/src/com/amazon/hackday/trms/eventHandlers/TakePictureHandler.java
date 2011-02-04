package com.amazon.hackday.trms.eventHandlers;

import com.amazon.hackday.trms.Preview;
import com.google.common.base.Preconditions;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.view.View;
import android.view.View.OnClickListener;

public class TakePictureHandler implements OnClickListener {
	private final Preview previewer;
	private final PictureDataCallback callback;
	private final Activity cameraActivity;
	
	public TakePictureHandler(Preview previewer, PictureDataCallback callback, Activity cameraActivity)
	{	
		this.previewer = Preconditions.checkNotNull(previewer);
		this.callback = Preconditions.checkNotNull(callback);
		this.cameraActivity = Preconditions.checkNotNull(cameraActivity);
	}
	
	public void onClick(View v) {
		previewer.bringToFront();
		previewer.mCamera.takePicture(shutterCallback, rawCallback, jpegCallback);				
	}	

	ShutterCallback shutterCallback = new ShutterCallback(){public void onShutter() {}};
	PictureCallback jpegCallback = new PictureCallback() {public void onPictureTaken(byte[] data, Camera camera) {}};
	
	PictureCallback rawCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			callback.picturePosted(data);
			cameraActivity.finish();
		}
	};
}
