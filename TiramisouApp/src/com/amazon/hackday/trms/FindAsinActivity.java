package com.amazon.hackday.trms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.amazon.hackday.trms.eventHandlers.StartIntentClickHandler;

public class FindAsinActivity extends Activity {
	
	static boolean calledCamera = false;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent takePictureIntent = new Intent(this, CameraActivity.class);
		startActivity(takePictureIntent);
        
        setContentView(R.layout.find_asin);
        
        if (FindAsinActivity.calledCamera == true) {
        	EditText text = (EditText)findViewById(R.id.EnterCode);
        	text.setText("018208254460");
        }
		//First Extract the bundle from intent
		Bundle bundle = getIntent().getExtras();
		try {
			//Next extract the values using the key as
			String UPC = bundle.getString("UPC");
			if (UPC != null) {
	        	EditText text = (EditText)findViewById(R.id.EnterCode);
	        	text.setText(UPC);				
			}
		}
		catch (Exception e) {
			
		}

		Button startover = (Button)findViewById(R.id.submit);
		Intent intent = new Intent(this, DisplayFeeActivity.class);
		OnClickListener submitClickListener = new StartIntentClickHandler(this, intent);    
		startover.setOnClickListener(submitClickListener);
		
		View takePicture = (View) findViewById(R.id.ship_takePicture);
		takePicture.setOnClickListener(pictureListener);		
    } 
    
    OnClickListener pictureListener = new OnClickListener() {
		
		public void onClick(View view) {
			FindAsinActivity.calledCamera = true;
			Context context = view.getContext();
			
			Intent intent = new Intent(FindAsinActivity.this, CameraActivity.class);
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
