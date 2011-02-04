package com.amazon.hackday.trms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EnterAsinActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_asin);
        
		Button startover = (Button)findViewById(R.id.submit);
		startover.setOnClickListener(submitClickListener);
    }
    
   OnClickListener submitClickListener = new OnClickListener() {
		
		public void onClick(View view) {
			Context context = view.getContext();
			Intent intent = new Intent(EnterAsinActivity.this, DisplayFeeActivity.class);
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