package com.amazon.hackday.trms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;

import com.amazon.hackday.trms.eventHandlers.PictureDataCallback;

public class FindAsinCameraActivity extends Activity {
	public static final String PICTURE_DATA_CALLBACK = "PictureDataCallback";
	
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

		shutterButton.setOnClickListener(shutterListener);
	}
	OnClickListener shutterListener = new OnClickListener() {
		
		public void onClick(View view) {
			FindAsinActivity.calledCamera = true;
			Context context = view.getContext();
			
			Intent intent = new Intent(FindAsinCameraActivity.this, FindAsinActivity.class);
            //Next create the bundle and initialize it
            Bundle bundle = new Bundle();
            //Add the parameters to bundle as
            bundle.putString("UPC", "018208254460");
            intent.putExtras(bundle);			
			try {
				//Start next activity
				context.startActivity(intent);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}			
		}
	};
}





