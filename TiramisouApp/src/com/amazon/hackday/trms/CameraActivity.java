package com.amazon.hackday.trms;

import java.util.*;

import android.app.Activity;
import android.content.*;
import android.os.*;
import android.view.*;
import android.util.*;
import java.io.*;
import android.hardware.Camera;
import android.hardware.Camera.*;
import android.widget.*;

public class CameraActivity extends Activity {
	private Preview preview; // ???
	//private Camera camera;
	private static byte[] picture;
	Parameters cameraParams;
	Button buttonClick;
	int cameraLocked;
	int defaultCamera;
	int numberOfCameras;
	String nextPage;
	
	public static byte[] getPicture(){
		return picture;
	}
	
	public static void setPicture(byte[] pictureIn){
		picture=pictureIn;
	}
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Bundle bnd = this.getIntent().getExtras();
		nextPage = bnd.getString("Next Page");
		setContentView(R.layout.cameralayout);
		
        // Hide the window title.
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        //mCamera=new Camera();
        
        buttonClick = (Button) findViewById(R.id.buttonClick);
        preview = (Preview) findViewById(R.id.preview); 
		buttonClick.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				preview.mCamera.takePicture(shutterCallback, rawCallback, jpegCallback);
				if (nextPage.trim().equalsIgnoreCase("Shipping")){
					Log.d("TRMS", "Jumping to shipping page");
					Intent myIntent = new Intent(CameraActivity.this, ShipConfirmActivity.class);
					Bundle bnd = new Bundle();
					bnd.putByteArray("picture", picture);
					myIntent.putExtra("Next Page", "Shipping");
					//myIntent.putExtra("com.android.samples.SpecialValue", "Hello, Joe!"); // key/value pair, where key needs current package prefix.
					startActivity(myIntent);
				}
				else Log.w("TRMS", "Not jumping to shipping page, nextPage = " + nextPage);
				/*prv.mCamera.takePicture(shutterCallback, rawCallback,
						jpegCallback);*/
				
			}
			
		});

        // Create a RelativeLayout container that will hold a SurfaceView,
        // and set it as the content of our activity.
        //prv = new Preview(this);
        
        //camera = Camera.open();
        /*cameraParams = camera.getParameters();
        try{
        	camera.setPreviewDisplay(prv.mHolder);
        }
        catch (Exception ex){
        	
       }*/
        
        //setContentView(prv);

	}
	
    protected void onPause() {
        super.onPause();

        // Because the Camera object is a shared resource, it's very
        // important to release it when the activity is paused.
        /*if (preview.mCamera != null) {
            preview.mCamera.release();
            preview.mCamera = null;
        }*/
    }
    
    protected void onResume() {
        super.onResume();

        // Open the default i.e. the first rear facing camera.
        /*Camera camera = Camera.open();
        cameraLocked = defaultCamera;
        preview.mCamera = camera;*/
    }

    ShutterCallback shutterCallback = new ShutterCallback() {
		public void onShutter() {
			//Log.d(TAG, "onShutter'd");
		}
	};

	/** Handles data for raw picture */
	PictureCallback rawCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			CameraActivity.setPicture(data);
//			Log.d(TAG, "onPictureTaken - raw");
		}
	};

	/** Handles data for jpeg picture */
	PictureCallback jpegCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			FileOutputStream outStream = null;
			try {
				// write to local sandbox file system
				// outStream =
				// CameraDemo.this.openFileOutput(String.format("%d.jpg",
				// System.currentTimeMillis()), 0);
				// Or write to sdcard
				outStream = new FileOutputStream(String.format(
						"/sdcard/%d.jpg", System.currentTimeMillis()));
				outStream.write(data);
				outStream.close();
//				Log.d(TAG, "onPictureTaken - wrote bytes: " + data.length);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
			}
//			Log.d(TAG, "onPictureTaken - jpeg");
		}
	};

}



