package com.amazon.hackday.trms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.amazon.hackday.trms.eventHandlers.StartIntentClickHandler;

public class FindAsinActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent takePictureIntent = new Intent(this, CameraActivity.class);
		startActivity(takePictureIntent);
        
        setContentView(R.layout.find_asin);

		Button startover = (Button)findViewById(R.id.submit);
		Intent intent = new Intent(this, DisplayFeeActivity.class);
		OnClickListener submitClickListener = new StartIntentClickHandler(this, intent);    
		startover.setOnClickListener(submitClickListener);
		
		View takePicture = (View) findViewById(R.id.ship_takePicture);
		takePicture.setOnClickListener(new StartIntentClickHandler(this, takePictureIntent));		
    } 
}
