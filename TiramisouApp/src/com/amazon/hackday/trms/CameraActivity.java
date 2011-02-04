package com.amazon.hackday.trms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.amazon.hackday.trms.eventHandlers.PictureDataCallback;
import com.amazon.hackday.trms.eventHandlers.TakePictureHandler;

public class CameraActivity extends Activity {
	public String PICTURE_DATA_CALLBACK = "PictureDataCallback";
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.cameralayout);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                       
        View shutterButton = (View) findViewById(R.id.camera_takePicture);
        Preview previewer = (Preview) findViewById(R.id.preview); 
        PictureDataCallback pictureDataCallback = new PictureDataCallback(){
			public void picturePosted(byte[] pictureData) {
				// Do nothing! HAHAHHA! IT's Hack Day!
			}        	
        };

		shutterButton.setOnClickListener(new TakePictureHandler(previewer, pictureDataCallback, this));
	}
	
    protected void onPause() {
        super.onPause();
    }
}



